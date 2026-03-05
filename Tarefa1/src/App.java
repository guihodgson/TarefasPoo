public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 40, 0, 4);
        Inimigo loboCapanga = new Inimigo("Lobo Solitario", 30, 0, 6);
        InputHandler inputHandler = new InputHandler();

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(loboCapanga.getNome() + ": (" + loboCapanga.getVida() + "/" + loboCapanga.getVidaMax() + " HP)");
            System.out.println();

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

        } while (heroi.estaVivo() && Inimigo.estaVivo());
    }
}
