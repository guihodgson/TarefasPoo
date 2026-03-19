package Entidades;

import Cartas.CartaDano;
import Cartas.CartaEscudo;

public class GerenciadorInimigo {
    public static Inimigo criarInimigo(int opcao) {
        Inimigo inimigo;
        switch (opcao) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano("Investida", null, 1, 7);
                CartaDano ataqueTaiForte = new CartaDano("Chute da Pantera", null, 1, 14);

                CartaEscudo escudoTaiMed = new CartaEscudo("Escudo medio", null, 1, 6);

                inimigo.adicionarCarta(escudoTaiMed, 2);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano("Investida", null, 1, 8);
                CartaDano ataqueShenForte = new CartaDano("Canhao Dragao", null, 1, 14);

                CartaEscudo escudoShenMed = new CartaEscudo("Escudo medio", null, 1, 5);

                inimigo.adicionarCarta(escudoShenMed, 2);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano("Investida", null, 1, 8);
                CartaDano ataqueKaiForte = new CartaDano("Espada Espiritual", null, 1, 16);

                CartaEscudo escudoKaiMed = new CartaEscudo("Escudo medio", null, 1, 6);

                inimigo.adicionarCarta(escudoKaiMed, 2);
                inimigo.adicionarCarta(ataqueKaiPeq, 4);
                inimigo.adicionarCarta(ataqueKaiForte, 3);
            }
            default -> {
                throw new AssertionError();
            }
        }
        return inimigo;
    }
}
