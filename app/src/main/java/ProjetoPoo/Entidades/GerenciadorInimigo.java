package ProjetoPoo.Entidades;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Artes;
import ProjetoPoo.Cor;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;

public class GerenciadorInimigo {
    public static Inimigo criarInimigo(int opcao) {
        Inimigo inimigo;

        EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(2, TipoEfeito.VENENO);
        EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);


        switch (opcao) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida da Pantera"), "Um soco poderoso de Tai Lung", 1, 7, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano ataqueTaiForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Chute da Pantera"), "Um chute de Kung Fu poderosíssimo de Tai Lung", 1, 14, AlvoCarta.UM_ALVO, Artes.BANG1);

                CartaEscudo escudoTaiMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio da Pantera"), "Defesa com o antebraço de Tai Lung", 1, 6, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEfeito venenoTaiPeq = new CartaEfeito(Cor.formataCor(Cor.VERDE_CLARO, "Garra Envenenada"), "Um corte que aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito vulneravelTaiPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Golpe Imobilizante"), "Um golpe que deixa o alvo vulnerável", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito enfraquecidoTaiPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Rugido da Pantera"), "Um rugido que enfraquece o alvo", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);

                inimigo.adicionarCarta(escudoTaiMed, 2);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
                inimigo.adicionarCarta(venenoTaiPeq, 1);
                inimigo.adicionarCarta(vulneravelTaiPeq, 1);
                inimigo.adicionarCarta(enfraquecidoTaiPeq, 1);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida do Pavão"), "Um ataque de penas afiadas de Lord Shen", 1, 8, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano ataqueShenForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Canhão Dragão"), "Um bombardeio poderosíssimo do canhão de Lord Shen", 1, 14, AlvoCarta.UM_ALVO, Artes.BANG1);

                CartaEscudo escudoShenMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio do Pavão"), "Defesa das asas de Lord Shen", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEfeito venenoShenPeq = new CartaEfeito(Cor.formataCor(Cor.VERDE_CLARO, "Pena Envenenada"), "Uma pena afiada que aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito vulneravelShenPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Pena Perfurante"), "Um corte que deixa o alvo vulnerável", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito enfraquecidoShenPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Rajada de Penas"), "Uma rajada que enfraquece o alvo", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);

                inimigo.adicionarCarta(escudoShenMed, 2);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
                inimigo.adicionarCarta(venenoShenPeq, 1);
                inimigo.adicionarCarta(vulneravelShenPeq, 1);
                inimigo.adicionarCarta(enfraquecidoShenPeq, 1);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida do Touro"), "Um ataque das lâminas espirituais de Kai", 1, 8, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano ataqueKaiForte = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Assalto Espiritual"), "Um ataque poderosíssimo de roubar as almas por Kai", 1, 16, AlvoCarta.UM_ALVO, Artes.BANG1);

                CartaEscudo escudoKaiMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Bloqueio do Touro"), "Defesa dos chifres de Kai", 1, 6, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEfeito venenoKaiPeq = new CartaEfeito(Cor.formataCor(Cor.VERDE_CLARO, "Lâmina Corrompida"), "Um golpe espiritual que aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito vulneravelKaiPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Correntes Espirituais"), "Um golpe que deixa o alvo vulnerável", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito enfraquecidoKaiPeq = new CartaEfeito(Cor.formataCor(Cor.AMARELO_CLARO, "Grito Espiritual"), "Um golpe espiritual que enfraquece o alvo", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);

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
