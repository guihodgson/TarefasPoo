
import Cartas.Carta;
import Entidades.*;

public class Batalha {
    public static boolean batalhar(Heroi heroi, Inimigo inimigo, InputHandler inputHandler) {
        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo)");
            System.out.println("--- VS ---");
            System.out.println(inimigo.getNome() + ": (" + inimigo.getVida() + "/" + inimigo.getVidaMax() + " HP) (" + inimigo.getEscudo() + " de escudo) (" + inimigo.getBuffDano() + " de dano extra por " + inimigo.getTempoBuff() + " round(s))");
            System.out.println();

            inimigo.printarProxAcao();
            System.out.println();

            if (heroi.getTempoBuff() > 0) {
                System.out.println(heroi.getNome() + " possui " + heroi.getBuffDano() + " de dano extra por mais " + heroi.getTempoBuff() + " round(s)\n");
            }

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), true);

            if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                    heroi.usarCartaNDeck(opcao, inimigo);
                }
                else {
                    System.out.println("Energia insuficiente.");
                    inputHandler.pressEnter();
                }

            }
            else if (opcao == heroi.tamDeck()){
                inimigo.resetarRound();
                inimigo.usarCartas(heroi);
                inputHandler.pressEnter();

                heroi.resetarRound();
            }
            else {
                System.out.println("Opcao invalida, tente novamente\n");
            }
        } while (heroi.estaVivo() && inimigo.estaVivo());

        if (heroi.estaVivo()) {
            return true;
        }
        else {
            return false; 
        }
    }
}
