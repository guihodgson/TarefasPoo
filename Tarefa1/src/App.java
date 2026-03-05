
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 40, 0, 4);
        Inimigo loboCapanga = new Inimigo("Lobo Solitario", 30, 0, 6);
        CartaDano cartaDano = new CartaDano("CartaDano", 2, 4);
        CartaEscudo cartaEscudo = new CartaEscudo("CartaEscudo", 2, 4);
        InputHandler inputHandler = new InputHandler();
        ArrayList<String> opcoesCartas = new ArrayList<>();
        opcoesCartas.add("Posicao 0 invalida");
        opcoesCartas.add("Carta Dano (" + cartaDano.getCusto() + " de energia)");
        opcoesCartas.add("Carta Escudo (" + cartaEscudo.getCusto() + " de energia)");
        opcoesCartas.add("Encerrar Turno");

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(loboCapanga.getNome() + ": (" + loboCapanga.getVida() + "/" + loboCapanga.getVidaMax() + " HP)");
            System.out.println();

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(opcoesCartas);

            if (opcao == 1) {
                if (heroi.podeGastarEnergia(cartaDano.getCusto())) {
                    cartaDano.usarAtaque(loboCapanga);
                }
                else {
                    System.out.println("\nEnergia insuficiente.\n");
                    inputHandler.pressEnter();
                }
                continue;
            }

            if (opcao == 2) {
                if (heroi.podeGastarEnergia(cartaEscudo.getCusto())) {
                    cartaEscudo.usarEscudo(heroi);
                }
                else {
                    System.out.println("\nEnergia insuficiente.\n");
                    inputHandler.pressEnter();
                }
                continue;
            }

            if (opcao == 3) {
                loboCapanga.atacar(heroi);
                System.out.println(loboCapanga.getNome() + " atacou e causou " + (((loboCapanga.getDanoBase() - heroi.getEscudo()) >= 0) ? loboCapanga.getDanoBase() - heroi.getEscudo() : 0) + " de dano.");
                heroi.resetRound();
                inputHandler.pressEnter();
            }

        } while (heroi.estaVivo() && loboCapanga.estaVivo());
    }
}
