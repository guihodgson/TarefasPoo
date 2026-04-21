package ProjetoPoo.Entidades;

import java.util.Random;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Cor;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Eventos.Artes;
import ProjetoPoo.Eventos.ContextoHeroi;
import ProjetoPoo.Eventos.TipoEvento;

public class GerenciadorInimigo {

    private Random random = new Random();

    /**
     * Cria um inimigo com seu baralho de cartas.
     *
     * @param opcao identificador do inimigo (0 = Tai Lung, 1 = Lord Shen, 2 = Kai)
     */
    public Inimigo criarBoss(ContextoHeroi ctx) {
        Inimigo inimigo;

        EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(2, TipoEfeito.VENENO);
        EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);


        switch (ctx.getArea()) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1, TipoInimigo.BOSS);
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
                inimigo = new Inimigo("Lord Shen", 32, 0, 1, TipoInimigo.BOSS);
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
                inimigo = new Inimigo("Kai", 36, 0, 1, TipoInimigo.BOSS);
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

    public Inimigo criarInimigoAleatorio(TipoEvento tipoEvento, ContextoHeroi ctx) {
        switch (tipoEvento) {
            case BATALHA_COMUM -> {
                return criarInimigoComum(ctx);
            }
            case BATALHA_ELITE -> {
                return criarInimigoElite(ctx);
            }
            case BOSS -> {
                return criarBoss(ctx);
            }
            default -> {
                throw new AssertionError();
            }
        }
    }

    public Inimigo criarInimigoComum(ContextoHeroi ctx) {
        return criarInimigoComum(ctx, false, 0);
    }

    public Inimigo criarInimigoComum(ContextoHeroi ctx, boolean teste, int id) {
        final int QTD_INIMIGOS0 = 3;
        final int QTD_INIMIGOS1 = 3;
        final int QTD_INIMIGOS2 = 3;

        switch (ctx.getArea()) {
            case 0 -> {
                int escolha = random.nextInt(QTD_INIMIGOS0);
                if (teste) {
                    escolha = id;
                }
                switch (escolha) {
                    case 0 -> {
                        Inimigo inimigo = new Inimigo("Javali Salteador", 16, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Investida do Javali"), "Um ataque básico do javali salteador", 1, 6, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoMed = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Casco do Javali"), "Defesa com o casco do javali salteador", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoMed, 3);
                        return inimigo;
                    }
                    case 1 -> {
                        Inimigo inimigo = new Inimigo("Lince", 12, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Mordida do Lince"), "Uma mordida do lince", 1, 4, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Lince"), "O lince tenta esquivar do próximo ataque", 1, 3, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                    case 2 -> {
                        Inimigo inimigo = new Inimigo("Abutre", 12, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Garras do Abutre"), "Um ataque com garras do abutre", 1, 3, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Voo do Abutre"), "O abutre voa para evitar o próximo ataque", 1, 4, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                }
            }
            case 1 -> {
                int escolha = random.nextInt(QTD_INIMIGOS1);
                if (teste) {
                    escolha = id;
                }
                switch (escolha) {
                    case 0 -> {
                        Inimigo inimigo = new Inimigo("Lobo Simples", 16, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Mordida do Lobo"), "Uma mordida do lobo simples", 1, 10, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Lobo"), "O lobo tenta esquivar do próximo ataque", 1, 7, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                    case 1 -> {
                        Inimigo inimigo = new Inimigo("Gorila Bruto", 20, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Soco do Gorila"), "Um soco poderoso do gorila bruto", 1, 12, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Gorila"), "O gorila tenta esquivar do próximo ataque", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                    case 2 -> {
                        Inimigo inimigo = new Inimigo("Cobra Venenosa", 14, 0, 1, TipoInimigo.COMUM);
                        EfeitoVeneno veneno = new EfeitoVeneno(3, TipoEfeito.VENENO);
                        CartaEfeito veneno3 = new CartaEfeito(Cor.formataCor(Cor.VERMELHO_CLARO, "Mordida da Cobra"), "Uma mordida da cobra", 1, AlvoCarta.UM_ALVO, Artes.BANG1, veneno);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Estrangular da Cobra"), "Uma acao de estrangulamento da cobra", 1, 8, AlvoCarta.UM_ALVO, Artes.BANG1);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(veneno3, 3);
                        return inimigo;
                    }
                }
            }
            case 2 -> {
                int escolha = random.nextInt(QTD_INIMIGOS2);
                if (teste) {
                    escolha = id;
                }
                switch (escolha) {
                    case 0 -> {
                        Inimigo inimigo = new Inimigo("Lobo de Jade", 20, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Mordida do Lobo de Jade"), "Uma mordida do lobo de jade", 1, 14, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Lobo de Jade"), "O lobo de jade tenta esquivar do próximo ataque", 1, 10, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                    case 1 -> {
                        Inimigo inimigo = new Inimigo("Gorila de Jade", 24, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Soco do Gorila de Jade"), "Um soco poderoso do gorila de jade", 1, 16, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Gorila de Jade"), "O gorila de jade tenta esquivar do próximo ataque", 1, 8, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                    case 2 -> {
                        Inimigo inimigo = new Inimigo("Porco de Jade", 18, 0, 1, TipoInimigo.COMUM);
                        CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Soco do Porco de Jade"), "Um soco poderoso do porco de jade", 1, 10, AlvoCarta.UM_ALVO, Artes.BANG1);
                        CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Porco de Jade"), "O porco de jade tenta esquivar do próximo ataque", 1, 6, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                        inimigo.adicionarCarta(ataquePeq, 5);
                        inimigo.adicionarCarta(escudoPeq, 3);
                        return inimigo;
                    }
                }
            }
        }
        return null;
    }

    public Inimigo criarInimigoElite(ContextoHeroi ctx) {
        switch (ctx.getArea()) {
            case 0 -> {
                Inimigo inimigo = new Inimigo("Lobo de Pedra", 22, 0, 1, TipoInimigo.ELITE);
                CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Mordida do Lobo de Pedra"), "Uma mordida do lobo de pedra", 1, 12, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Lobo de Pedra"), "O lobo de pedra tenta esquivar do próximo ataque", 1, 7, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                inimigo.adicionarCarta(ataquePeq, 5);
                inimigo.adicionarCarta(escudoPeq, 3);
                return inimigo;
            }
            case 1 -> {
                Inimigo inimigo = new Inimigo("Tigre de Pedra", 24, 0, 1, TipoInimigo.ELITE);
                CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Garras do Tigre de Pedra"), "Um ataque com garras do tigre de pedra", 1, 14, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Tigre de Pedra"), "O tigre de pedra tenta esquivar do próximo ataque", 1, 8, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                inimigo.adicionarCarta(ataquePeq, 5);
                inimigo.adicionarCarta(escudoPeq, 3);
                return inimigo;
            }
            case 2 -> {
                Inimigo inimigo = new Inimigo("Dragão de Pedra", 26, 0, 1, TipoInimigo.ELITE);
                CartaDano ataquePeq = new CartaDano(Cor.formataCor(Cor.VERMELHO_CLARO, "Sopro do Dragão de Pedra"), "Um ataque de fogo do dragão de pedra", 1, 16, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaEscudo escudoPeq = new CartaEscudo(Cor.formataCor(Cor.AZUL_CLARO, "Esquiva do Dragão de Pedra"), "O dragão de pedra tenta esquivar do próximo ataque", 1, 9, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                inimigo.adicionarCarta(ataquePeq, 5);
                inimigo.adicionarCarta(escudoPeq, 3);
                return inimigo;
            }
        }
        return null;
    }


}
