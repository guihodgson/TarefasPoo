package Entidades;

import Cartas.CartaDano;
import Cartas.CartaEscudo;

public class GerenciadorInimigo {
    public static Inimigo criarInimigo(int opcao) {
        Inimigo inimigo;
        switch (opcao) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano("Investida da Pantera", "um soco poderoso de Tai Lung", 1, 7);
                CartaDano ataqueTaiForte = new CartaDano("Chute da Pantera", "um chute de Kung Fu poderosíssimo de Tai Lung", 1, 14);

                CartaEscudo escudoTaiMed = new CartaEscudo("Bloqueio da Pantera", "defesa do antebraço de Tai Lung", 1, 6);

                inimigo.adicionarCarta(escudoTaiMed, 2);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano("Investida do Pavão", "um ataque de penas afiadas de Lord Shen", 1, 8);
                CartaDano ataqueShenForte = new CartaDano("Canhão Dragão", "um bombardeio poderosíssimo do canhão de Lord Shen", 1, 14);

                CartaEscudo escudoShenMed = new CartaEscudo("Bloqueio do Pavão", "defesa das asas de Lord Shen", 1, 5);

                inimigo.adicionarCarta(escudoShenMed, 2);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano("Investida do Touro", "um ataque das lâminas espirituais de Kai", 1, 8);
                CartaDano ataqueKaiForte = new CartaDano("Assalto Espiritual", "um ataque poderosíssimo de roubar as almas por Kai", 1, 16);

                CartaEscudo escudoKaiMed = new CartaEscudo("Bloqueio do Touro", "defesa dos chifres de Kai", 1, 6);

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
