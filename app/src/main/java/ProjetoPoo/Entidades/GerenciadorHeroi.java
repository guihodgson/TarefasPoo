package ProjetoPoo.Entidades;

import ProjetoPoo.Cartas.CartaCura;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Cartas.AlvoCarta;

public class GerenciadorHeroi {

    public static Heroi criarHeroi() {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 32, 0, 5);

        // Efeitos

        EfeitoBonusDano efeitoBonusDano1 = new EfeitoBonusDano(1, 2, TipoEfeito.BONUS_DANO);
        EfeitoBonusDano efeitoBonusDano2 = new EfeitoBonusDano(2, 3, TipoEfeito.BONUS_DANO);

        EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(3, 2, TipoEfeito.VENENO);
        EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);

        // Baralho Po

        CartaDano cartaSkidoosh = new CartaDano("Skidoosh (15 de ataque)", "O Ataque Espiritual mais forte do Dragão Guerreiro", 5, 15, AlvoCarta.UM_ALVO);
        CartaDano cartaDanoMed = new CartaDano("Barrigada do Panda (5 de ataque)", "Uma forte investida com a barriga do Dragão Guerreiro", 2, 5, AlvoCarta.UM_ALVO);
        CartaDano cartaDanoPeq = new CartaDano("Soco do Panda (2 de ataque)", "Um soco levemente carinhoso do Dragão Guerreiro", 1, 2, AlvoCarta.UM_ALVO);
        CartaDano cartaDanoGlobalMed = new CartaDano("Flatulencia do Dragão Guerreiro (3 de ataque para todos os inimigos)", "O Dragão Guerreiro solta uma flatulencia que atinge todos os inimigos", 2, 3, AlvoCarta.GLOBAL);

        CartaEscudo cartaEscudoGrnd = new CartaEscudo("A Fuga do Panda (10 de defesa)", "O Dragão Guerreiro sairá correndo da batalha fugindo dos danos do ataque", 3, 10, AlvoCarta.USO_PROPRIO);
        CartaEscudo cartaEscudoMed = new CartaEscudo("Absorção de dano na Barriga (5 de defesa)", "A barriga do Dragão Guerreiro será usada para absorver o ataque", 2, 5, AlvoCarta.USO_PROPRIO);
        CartaEscudo cartaEscudoPeq = new CartaEscudo("Cambalhota do Panda (2 de defesa)", "O Dragão Guerreiro dará uma cambalhota e esquivará do dano do ataque", 1, 2, AlvoCarta.USO_PROPRIO);

        CartaEfeito cartaBuffPeq = new CartaEfeito("Sorte no Ataque (+1 de ataque por 2 rounds)", "A sorte do Dragão Guerreiro aumentará o ataque do Dragão Guerreiro por 2 rounds", 1, AlvoCarta.USO_PROPRIO , efeitoBonusDano1);
        CartaEfeito cartaBuffMed = new CartaEfeito("Canalizar o Chi (+2 de ataque por 3 rounds)", "O uso do Chi no ataque do Dragão Guerreiro aumentará o ataque por 3 rounds", 2, AlvoCarta.USO_PROPRIO , efeitoBonusDano2);

        CartaEfeito cartaVenenoPeq = new CartaEfeito("Macarrão Envenenado (3 de veneno por 2 rounds)", "Uma comida special que aplica veneno no inimigo", 1, AlvoCarta.UM_ALVO, efeitoVeneno3);
        CartaEfeito cartaVulneravelPeq = new CartaEfeito("Golpe Certeiro (+25% dano recebido por 2 rounds)", "O golpe certeiro deixa o inimigo mais vulnerável a ataques", 1, AlvoCarta.UM_ALVO, efeitoVulneravel25);
        CartaEfeito cartaEnfraquecidoPeq = new CartaEfeito("Ameaça do Dragão Guerreiro (-25% dano causado por 2 rounds)", "O medo sobre o Dragão Guerreiro deixa o inimigo enfraquecido e ataca com menos dano", 1, AlvoCarta.UM_ALVO, efeitoEnfraquecido25);

        CartaCura cartaCuraPeq = new CartaCura("Cura do Biscoito Chinês (3 de cura)", "O Biscoito Chinês dará mais vida para curar-se", 2, 3, AlvoCarta.USO_PROPRIO);
        CartaCura cartaCuraMed = new CartaCura("Cura do Lámen (5 de cura)", "O Lámen do Papai Ping dará mais vida para curar-se", 3, 5, AlvoCarta.USO_PROPRIO);
        CartaCura cartaCuraGrnd = new CartaCura("Cura do Bao (7 de cura)", "O Pãozinho Bao do Papai Ping dará mais vida para curar-se", 4, 7, AlvoCarta.USO_PROPRIO);

        heroi.adicionarCartaBaralho(cartaDanoMed, 3);
        heroi.adicionarCartaBaralho(cartaDanoPeq, 2);
        heroi.adicionarCartaBaralho(cartaSkidoosh, 1);
        heroi.adicionarCartaBaralho(cartaDanoGlobalMed, 1);

        heroi.adicionarCartaBaralho(cartaEscudoPeq, 1);
        heroi.adicionarCartaBaralho(cartaEscudoMed, 2);
        heroi.adicionarCartaBaralho(cartaEscudoGrnd, 1);

        heroi.adicionarCartaBaralho(cartaBuffPeq, 2);
        heroi.adicionarCartaBaralho(cartaBuffMed, 2);

        heroi.adicionarCartaBaralho(cartaVenenoPeq, 2);
        heroi.adicionarCartaBaralho(cartaVulneravelPeq, 2);
        heroi.adicionarCartaBaralho(cartaEnfraquecidoPeq, 2);

        heroi.adicionarCartaBaralho(cartaCuraPeq, 1);
        heroi.adicionarCartaBaralho(cartaCuraMed, 1);
        heroi.adicionarCartaBaralho(cartaCuraGrnd, 1);

        heroi.deckInicial();
        return heroi;
    }
}
