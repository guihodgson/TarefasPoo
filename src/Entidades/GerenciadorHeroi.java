package Entidades;

import Cartas.CartaBonusDano;
import Cartas.CartaCura;
import Cartas.CartaDano;
import Cartas.CartaEnfraquecido;
import Cartas.CartaEscudo;
import Cartas.CartaVeneno;
import Cartas.CartaVulneravel;

public class GerenciadorHeroi {

    public static Heroi criarHeroi() {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 32, 0, 5);

        // Baralho Po

        CartaDano cartaSkidoosh = new CartaDano("Skidoosh (15 de ataque)", "O Ataque Espiritual mais forte do Dragão Guerreiro", 5, 15);
        CartaDano cartaDanoMed = new CartaDano("Barrigada do Panda (5 de ataque)", "Uma forte investida com a barriga do Dragão Guerreiro", 2, 5);
        CartaDano cartaDanoPeq = new CartaDano("Soco do Panda (2 de ataque)", "Um soco levemente carinhoso do Dragão Guerreiro", 1, 2);

        CartaEscudo cartaEscudoGrnd = new CartaEscudo("A Fuga do Panda (10 de defesa)", "O Dragão Guerreiro sairá correndo da batalha fugindo dos danos do ataque", 3, 10);
        CartaEscudo cartaEscudoMed = new CartaEscudo("Absorção de dano na Barriga (5 de defesa)", "A barriga do Dragão Guerreiro será usada para absorver o ataque", 2, 5);
        CartaEscudo cartaEscudoPeq = new CartaEscudo("Cambalhota do Panda (2 de defesa)", "O Dragão Guerreiro dará uma cambalhota e esquivará do dano do ataque", 1, 2);

        CartaBonusDano cartaBuffPeq = new CartaBonusDano("Sorte no Ataque (+1 de ataque por 2 rounds)", "A sorte do Dragão Guerreiro aumentará o ataque do Dragão Guerreiro por 2 rounds", 1, 1, 2);
        CartaBonusDano cartaBuffMed = new CartaBonusDano("Canalizar o Chi (+2 de ataque por 3 rounds)", "O uso do Chi no ataque do Dragão Guerreiro aumentará o ataque por 3 rounds", 2, 2, 3);

        CartaVeneno cartaVenenoPeq = new CartaVeneno("Macarrão Envenenado (1 de veneno por 2 rounds)", "Uma comida especial que aplica veneno no inimigo", 1, 1, 2);
        CartaVulneravel cartaVulneravelPeq = new CartaVulneravel("Golpe Certeiro (+25% dano recebido por 2 rounds)", "O golpe certeiro deixa o inimigo mais vulnerável a ataques", 1, 25, 1);
        CartaEnfraquecido cartaEnfraquecidoPeq = new CartaEnfraquecido("Ameaça do Dragão Guerreiro (-25% dano causado por 2 rounds)", "O medo sobre o Dragão Guerreiro deixa o inimigo enfraquecido e ataca com menos dano", 1, 25, 2);

        CartaCura cartaCuraPeq = new CartaCura("Cura do Biscoito Chinês (3 de cura)", "O Biscoito Chinês dará mais vida para curar-se", 2, 3);
        CartaCura cartaCuraMed = new CartaCura("Cura do Lámen (5 de cura)", "O Lámen do Papai Ping dará mais vida para curar-se", 3, 5);
        CartaCura cartaCuraGrnd = new CartaCura("Cura do Bao (7 de cura)", "O Pãozinho Bao do Papai Ping dará mais vida para curar-se", 4, 7);

        heroi.adicionarCartaBaralho(cartaDanoMed, 3);
        heroi.adicionarCartaBaralho(cartaDanoPeq, 2);
        heroi.adicionarCartaBaralho(cartaSkidoosh, 1);

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
