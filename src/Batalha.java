
import Cartas.Carta;
import Entidades.*;

public class Batalha {

    private static String montarStatus(Entidade entidade) {
        String status = "HP: " + entidade.getVida() + "/" + entidade.getVidaMax() + " | Escudo: " + entidade.getEscudo();

        int bonus = entidade.calcularBonusDano();
        if (bonus > 0) {
            status += " | Bonus: " + bonus + " por " + entidade.calcularTempoBonusDano(bonus) + " round(s)";
        }

        int veneno = entidade.calcularVeneno();
        if (veneno > 0) {
            status += " | Veneno: " + veneno + " por " + entidade.calcularTempoVeneno(veneno) + " round(s)";
        }

        int vulneravel = entidade.calcularVulneravel();
        if (vulneravel > 0) {
            status += " | Vulneravel: +" + vulneravel + "% de dano por " + entidade.calcularTempoVulneravel(vulneravel) + " round(s)";
        }

        int enfraquecido = entidade.calcularEnfraquecido();
        if (enfraquecido > 0) {
            status += " | Enfraquecido: -" + enfraquecido + "% de dano por " + entidade.calcularTempoEnfraquecido(enfraquecido) + " round(s)";
        }

        return status;
    }

    public static boolean batalhar(Heroi heroi, Inimigo inimigo, InputHandler inputHandler) {
        do {
            System.out.println("================================================================================");
            System.out.println("HEROI: " + heroi.getNome());
            System.out.println(montarStatus(heroi));
            System.out.println("------------------------------------------------------------");
            System.out.println("VILAO: " + inimigo.getNome());
            System.out.println(montarStatus(inimigo));
            System.out.println("================================================================================");
            System.out.println();

            inputHandler.sleep(0.7);

            inimigo.printarProxAcao();
            System.out.println();

            inputHandler.sleep(0.7);

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), true);

            if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                    heroi.atualizarEfeito("ataque");
                    heroi.usarCartaNDeck(opcao, inimigo);
                    inputHandler.clear();
                }
                else {
                    System.out.println("Energia insuficiente.");
                    inputHandler.pressEnter();
                    inputHandler.clear();
                }

            }
            else if (opcao == heroi.tamDeck()){
                inimigo.resetarRound();
                heroi.atualizarEfeito("fimRound");
                inimigo.atualizarEfeito("fimRound");

                if (!inimigo.estaVivo()) {
                    break;
                }

                inimigo.usarCartas(heroi);
                inputHandler.pressEnter();
                inputHandler.clear();

                heroi.resetarRound();
            }
            else {
                System.out.println("Opcao invalida, tente novamente\n");
                inputHandler.pressEnter();
                inputHandler.clear();
            }
        } while (heroi.estaVivo() && inimigo.estaVivo());

        return heroi.estaVivo();
    }
}
