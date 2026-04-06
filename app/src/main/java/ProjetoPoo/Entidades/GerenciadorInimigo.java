package ProjetoPoo.Entidades;

import ProjetoPoo.Cor;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEnfraquecido;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Cartas.CartaVeneno;
import ProjetoPoo.Cartas.CartaVulneravel;

public class GerenciadorInimigo {
    public static Inimigo criarInimigo(int opcao) {
        Inimigo inimigo;
        switch (opcao) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida da Pantera"), "Um soco poderoso de Tai Lung", 1, 7);
                CartaDano ataqueTaiForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Chute da Pantera"), "Um chute de Kung Fu poderosíssimo de Tai Lung", 1, 14);

                CartaEscudo escudoTaiMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio da Pantera"), "Defesa com o antebraço de Tai Lung", 1, 6);
                CartaVeneno venenoTaiPeq = new CartaVeneno(Cor.formataCor(Cor.VERDE_CLARO, "Garra Envenenada"), "Um corte que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelTaiPeq = new CartaVulneravel(Cor.formataCor(Cor.AMARELO_CLARO, "Golpe Imobilizante"), "Um golpe que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoTaiPeq = new CartaEnfraquecido(Cor.formataCor(Cor.AMARELO_CLARO, "Rugido da Pantera"), "Um rugido que enfraquece o alvo", 1, 25, 2);

                inimigo.adicionarCarta(escudoTaiMed, 2);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
                inimigo.adicionarCarta(venenoTaiPeq, 1);
                inimigo.adicionarCarta(vulneravelTaiPeq, 1);
                inimigo.adicionarCarta(enfraquecidoTaiPeq, 1);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida do Pavão"), "Um ataque de penas afiadas de Lord Shen", 1, 8);
                CartaDano ataqueShenForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Canhão Dragão"), "Um bombardeio poderosíssimo do canhão de Lord Shen", 1, 14);

                CartaEscudo escudoShenMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio do Pavão"), "Defesa das asas de Lord Shen", 1, 5);
                CartaVeneno venenoShenPeq = new CartaVeneno(Cor.formataCor(Cor.VERDE_CLARO, "Pena Envenenada"), "Uma pena afiada que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelShenPeq = new CartaVulneravel(Cor.formataCor(Cor.AMARELO_CLARO, "Pena Perfurante"), "Um corte que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoShenPeq = new CartaEnfraquecido(Cor.formataCor(Cor.AMARELO_CLARO, "Rajada de Penas"), "Uma rajada que enfraquece o alvo", 1, 25, 2);

                inimigo.adicionarCarta(escudoShenMed, 2);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
                inimigo.adicionarCarta(venenoShenPeq, 1);
                inimigo.adicionarCarta(vulneravelShenPeq, 1);
                inimigo.adicionarCarta(enfraquecidoShenPeq, 1);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida do Touro"), "Um ataque das lâminas espirituais de Kai", 1, 8);
                CartaDano ataqueKaiForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Assalto Espiritual"), "Um ataque poderosíssimo de roubar as almas por Kai", 1, 16);

                CartaEscudo escudoKaiMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio do Touro"), "Defesa dos chifres de Kai", 1, 6);
                CartaVeneno venenoKaiPeq = new CartaVeneno(Cor.formataCor(Cor.VERDE_CLARO, "Lâmina Corrompida"), "Um golpe espiritual que aplica veneno", 1, 1, 2);
                CartaVulneravel vulneravelKaiPeq = new CartaVulneravel(Cor.formataCor(Cor.AMARELO_CLARO, "Correntes Espirituais"), "Um golpe que deixa o alvo vulnerável", 1, 25, 2);
                CartaEnfraquecido enfraquecidoKaiPeq = new CartaEnfraquecido(Cor.formataCor(Cor.AMARELO_CLARO, "Grito Espiritual"), "Um golpe espiritual que enfraquece o alvo", 1, 25, 2);

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
