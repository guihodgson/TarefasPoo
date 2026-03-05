
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 40, 0, 4);
        Inimigo loboCapanga = new Inimigo("Lobo Solitario", 30, 0, 6);
        InputHandler inputHandler = new InputHandler();
        ArrayList<String> opcoesCartas = new ArrayList<>();
        opcoesCartas.add("Posicao 0 invalida");
        opcoesCartas.add("Carta Dano");
        opcoesCartas.add("Carta Escudo");
        opcoesCartas.add("Encerrar Turno");

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(loboCapanga.getNome() + ": (" + loboCapanga.getVida() + "/" + loboCapanga.getVidaMax() + " HP)");
            System.out.println();

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(opcoesCartas);

            if (opcao == 1) {
                if (heroi.podeGastarEnergia(1)) {
                    // Colocar ataque da cartaDano
                }
                else {
                    System.out.println("Energia insuficiente.");
                }
                continue;
            }
            if (opcao == 2) {
                if (heroi.podeGastarEnergia(1)) {
                    // Colocar escudo da cartaEscudo
                }
                else {
                    System.out.println("Energia insuficiente.");
                }
                continue;
            }
            if (opcao == 3) {
                loboCapanga.atacar(heroi);
                heroi.resetRound();
            }

        } while (heroi.estaVivo() && loboCapanga.estaVivo());
    }
}
