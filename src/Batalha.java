
import Cartas.Carta;
import Entidades.*;

public class Batalha {
    public static boolean batalhar(Heroi heroi, Inimigo inimigo, InputHandler inputHandler) {
        do {
            System.out.println("====================================8====================================");
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo)");
            System.out.println("                                --- X ---");
            System.out.println(inimigo.getNome() + ": (" + inimigo.getVida() + "/" + inimigo.getVidaMax() + " HP) (" + inimigo.getEscudo() + " de escudo) (" + inimigo.calcularBonusDano() + " de dano extra por " + inimigo.calcularTempoBonusDano(inimigo.calcularBonusDano()) + " round(s))");
            System.out.println("====================================8====================================");
            System.out.println();

            inputHandler.sleep(0.7);

            inimigo.printarProxAcao();
            System.out.println();

            inputHandler.sleep(0.7);

            if (heroi.calcularBonusDano() > 0) {
                System.out.println(heroi.getNome() + " possui " + heroi.calcularBonusDano() + " de dano extra por mais " + heroi.calcularTempoBonusDano(heroi.calcularBonusDano()) + " round(s)\n");
            }

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
