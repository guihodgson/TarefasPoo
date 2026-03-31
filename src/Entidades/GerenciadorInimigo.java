package Entidades;

import Cartas.CartaDano;
import Cartas.CartaEnfraquecido;
import Cartas.CartaEscudo;
import Cartas.CartaVeneno;
import Cartas.CartaVulneravel;

public class GerenciadorInimigo {
    public static Inimigo criarInimigo(int opcao) {
        Inimigo inimigo;
        switch (opcao) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano("Investida da Pantera", "Um soco poderoso de Tai Lung", 1, 7);
                CartaDano ataqueTaiForte = new CartaDano("Chute da Pantera", "Um chute de Kung Fu poderosíssimo de Tai Lung", 1, 14);

                CartaEscudo escudoTaiMed = new CartaEscudo("Bloqueio da Pantera", "Defesa com o antebraço de Tai Lung", 1, 6);
                CartaVeneno venenoTaiPeq = new CartaVeneno("Garra Envenenada", "Um corte que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelTaiPeq = new CartaVulneravel("Golpe Imobilizante", "Um golpe que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoTaiPeq = new CartaEnfraquecido("Rugido da Pantera", "Um rugido que enfraquece o alvo", 1, 25, 2);

                inimigo.adicionarCarta(escudoTaiMed, 2);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
                inimigo.adicionarCarta(venenoTaiPeq, 1);
                inimigo.adicionarCarta(vulneravelTaiPeq, 1);
                inimigo.adicionarCarta(enfraquecidoTaiPeq, 1);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano("Investida do Pavão", "Um ataque de penas afiadas de Lord Shen", 1, 8);
                CartaDano ataqueShenForte = new CartaDano("Canhão Dragão", "Um bombardeio poderosíssimo do canhão de Lord Shen", 1, 14);

                CartaEscudo escudoShenMed = new CartaEscudo("Bloqueio do Pavão", "Defesa das asas de Lord Shen", 1, 5);
                CartaVeneno venenoShenPeq = new CartaVeneno("Pena Envenenada", "Uma pena afiada que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelShenPeq = new CartaVulneravel("Pena Perfurante", "Um corte que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoShenPeq = new CartaEnfraquecido("Rajada de Penas", "Uma rajada que enfraquece o alvo", 1, 25, 2);

                inimigo.adicionarCarta(escudoShenMed, 2);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
                inimigo.adicionarCarta(venenoShenPeq, 1);
                inimigo.adicionarCarta(vulneravelShenPeq, 1);
                inimigo.adicionarCarta(enfraquecidoShenPeq, 1);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano("Investida do Touro", "Um ataque das lâminas espirituais de Kai", 1, 8);
                CartaDano ataqueKaiForte = new CartaDano("Assalto Espiritual", "Um ataque poderosíssimo de roubar as almas por Kai", 1, 16);

                CartaEscudo escudoKaiMed = new CartaEscudo("Bloqueio do Touro", "Defesa dos chifres de Kai", 1, 6);
                CartaVeneno venenoKaiPeq = new CartaVeneno("Lâmina Corrompida", "Um golpe espiritual que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelKaiPeq = new CartaVulneravel("Correntes Espirituais", "Um golpe que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoKaiPeq = new CartaEnfraquecido("Grito Espiritual", "Um golpe espiritual que enfraquece o alvo", 1, 25, 2);

                inimigo.adicionarCarta(escudoKaiMed, 2);
                inimigo.adicionarCarta(ataqueKaiPeq, 4);
                inimigo.adicionarCarta(ataqueKaiForte, 3);
                inimigo.adicionarCarta(venenoKaiPeq, 1);
                inimigo.adicionarCarta(vulneravelKaiPeq, 1);
                inimigo.adicionarCarta(enfraquecidoKaiPeq, 1);
            }
            default -> {
                throw new AssertionError();
            }
        }
        return inimigo;
    }
}
