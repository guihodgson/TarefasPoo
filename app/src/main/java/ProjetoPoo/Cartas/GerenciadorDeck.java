package ProjetoPoo.Cartas;

import ProjetoPoo.Batalhas.Artes;
import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Entidades.Heroi;

public class GerenciadorDeck {
    

    /**
     * Cria um deck para o heroi e adiciona nele.
     * @param heroi
     * @param opcao
     */
    public static void criarDeckHeroi(Heroi heroi,int opcao) {

        switch (opcao) {
            case 0 -> {
                // Efeitos

                EfeitoBonusDano efeitoBonusDano1 = new EfeitoBonusDano(1, 2, TipoEfeito.BONUS_DANO);
                EfeitoBonusDano efeitoBonusDano2 = new EfeitoBonusDano(2, 3, TipoEfeito.BONUS_DANO);
            
                EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(3, TipoEfeito.VENENO);
                EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
                EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);
            
                // Baralho Po 1
            
                CartaDano cartaSkidoosh = new CartaDano("Skidoosh (18 de ataque)", "O Ataque Espiritual mais forte do Dragão Guerreiro", 5, 18, AlvoCarta.UM_ALVO, Artes.SKIDOOSH);
                CartaDano cartaDanoMed = new CartaDano("Barrigada do Panda (5 de ataque)", "Uma forte investida com a barriga do Dragão Guerreiro", 2, 5, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoPeq = new CartaDano("Soco do Panda (2 de ataque)", "Um soco levemente carinhoso do Dragão Guerreiro", 1, 2, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoGlobalMed = new CartaDano("Flatulencia do Dragão Guerreiro (8 de ataque para todos os inimigos)", "O Dragão Guerreiro solta uma flatulencia que atinge todos os inimigos", 2, 8, AlvoCarta.GLOBAL, Artes.FLATULENCIA);
            
                CartaEscudo cartaEscudoGrnd = new CartaEscudo("A Fuga do Panda (10 de defesa)", "O Dragão Guerreiro sairá correndo da batalha fugindo dos danos do ataque", 3, 10, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoMed = new CartaEscudo("Absorção de dano na Barriga (5 de defesa)", "A barriga do Dragão Guerreiro será usada para absorver o ataque", 2, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoPeq = new CartaEscudo("Cambalhota do Panda (2 de defesa)", "O Dragão Guerreiro dará uma cambalhota e esquivará do dano do ataque", 1, 2, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
            
                CartaEfeito cartaBuffPeq = new CartaEfeito("Sorte no Ataque (+1 de ataque por 2 rounds)", "A sorte do Dragão Guerreiro aumentará o ataque do Dragão Guerreiro por 2 rounds", 1, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano1);
                CartaEfeito cartaBuffMed = new CartaEfeito("Canalizar o Chi (+2 de ataque por 3 rounds)", "O uso do Chi no ataque do Dragão Guerreiro aumentará o ataque por 3 rounds", 2, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano2);
            
                CartaEfeito cartaVenenoPeq = new CartaEfeito("Macarrão Envenenado (Veneno por +3 rounds)", "Uma comida special que aplica veneno no inimigo", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito cartaVulneravelPeq = new CartaEfeito("Golpe Certeiro (+25% dano recebido por 2 rounds)", "O golpe certeiro deixa o inimigo mais vulnerável a ataques", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito cartaEnfraquecidoPeq = new CartaEfeito("Ameaça do Dragão Guerreiro (-25% dano causado por 2 rounds)", "O medo sobre o Dragão Guerreiro deixa o inimigo enfraquecido e ataca com menos dano", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);
            
                CartaCura cartaCuraPeq = new CartaCura("Cura do Biscoito Chinês (3 de cura)", "O Biscoito Chinês dará mais vida para curar-se", 2, 3, AlvoCarta.USO_PROPRIO, Artes.CURA);
                CartaCura cartaCuraMed = new CartaCura("Cura do Lámen (5 de cura)", "O Lámen do Papai Ping dará mais vida para curar-se", 3, 5, AlvoCarta.USO_PROPRIO, Artes.CURA);
                CartaCura cartaCuraGrnd = new CartaCura("Cura do Bao (7 de cura)", "O Pãozinho Bao do Papai Ping dará mais vida para curar-se", 4, 7, AlvoCarta.USO_PROPRIO, Artes.CURA);

                // Adicionando as cartas ao baralho do herói

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
            }

            case 1 -> {
                // Efeitos

                EfeitoBonusDano efeitoBonusDano1 = new EfeitoBonusDano(2, 2, TipoEfeito.BONUS_DANO);
                EfeitoBonusDano efeitoBonusDano2 = new EfeitoBonusDano(4, 3, TipoEfeito.BONUS_DANO);
            
                EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(4, TipoEfeito.VENENO);
                EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
                EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);
            
                // Baralho Po 1
            
                CartaDano cartaSkidoosh = new CartaDano("Skidoosh (20 de ataque)", "O Ataque Espiritual mais forte do Dragão Guerreiro", 4, 20, AlvoCarta.UM_ALVO, Artes.SKIDOOSH);
                CartaDano cartaDanoMed = new CartaDano("Barrigada do Panda (8 de ataque)", "Uma forte investida com a barriga do Dragão Guerreiro", 2, 8, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoPeq = new CartaDano("Soco do Panda (4 de ataque)", "Um soco levemente carinhoso do Dragão Guerreiro", 1, 4, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoGlobalMed = new CartaDano("Flatulencia do Dragão Guerreiro (8 de ataque para todos os inimigos)", "O Dragão Guerreiro solta uma flatulencia que atinge todos os inimigos", 2, 8, AlvoCarta.GLOBAL, Artes.FLATULENCIA);
            
                CartaEscudo cartaEscudoGrnd = new CartaEscudo("A Fuga do Panda (16 de defesa)", "O Dragão Guerreiro sairá correndo da batalha fugindo dos danos do ataque", 3, 16, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoMed = new CartaEscudo("Absorção de dano na Barriga (10 de defesa)", "A barriga do Dragão Guerreiro será usada para absorver o ataque", 2, 10, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoPeq = new CartaEscudo("Cambalhota do Panda (5 de defesa)", "O Dragão Guerreiro dará uma cambalhota e esquivará do dano do ataque", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
            
                CartaEfeito cartaBuffPeq = new CartaEfeito("Sorte no Ataque (+2 de ataque por 2 rounds)", "A sorte do Dragão Guerreiro aumentará o ataque do Dragão Guerreiro por 2 rounds", 1, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano1);
                CartaEfeito cartaBuffMed = new CartaEfeito("Canalizar o Chi (+4 de ataque por 3 rounds)", "O uso do Chi no ataque do Dragão Guerreiro aumentará o ataque por 3 rounds", 2, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano2);
            
                CartaEfeito cartaVenenoPeq = new CartaEfeito("Macarrão Envenenado (Veneno por +4 rounds)", "Uma comida special que aplica veneno no inimigo", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito cartaVulneravelPeq = new CartaEfeito("Golpe Certeiro (+25% dano recebido por 2 rounds)", "O golpe certeiro deixa o inimigo mais vulnerável a ataques", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito cartaEnfraquecidoPeq = new CartaEfeito("Ameaça do Dragão Guerreiro (-25% dano causado por 2 rounds)", "O medo sobre o Dragão Guerreiro deixa o inimigo enfraquecido e ataca com menos dano", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);
            
                CartaCura cartaCuraPeq = new CartaCura("Cura do Biscoito Chinês (5 de cura)", "O Biscoito Chinês dará mais vida para curar-se", 2, 5, AlvoCarta.USO_PROPRIO, Artes.CURA);
                CartaCura cartaCuraMed = new CartaCura("Cura do Lámen (8 de cura)", "O Lámen do Papai Ping dará mais vida para curar-se", 3, 8, AlvoCarta.USO_PROPRIO, Artes.CURA);
                CartaCura cartaCuraGrnd = new CartaCura("Cura do Bao (12 de cura)", "O Pãozinho Bao do Papai Ping dará mais vida para curar-se", 4, 12, AlvoCarta.USO_PROPRIO, Artes.CURA);

                // Adicionando as cartas ao baralho do herói

                heroi.adicionarCartaBaralho(cartaDanoMed, 3);
                heroi.adicionarCartaBaralho(cartaDanoPeq, 1);
                heroi.adicionarCartaBaralho(cartaSkidoosh, 2);
                heroi.adicionarCartaBaralho(cartaDanoGlobalMed, 1);

                heroi.adicionarCartaBaralho(cartaEscudoPeq, 1);
                heroi.adicionarCartaBaralho(cartaEscudoMed, 1);
                heroi.adicionarCartaBaralho(cartaEscudoGrnd, 2);

                heroi.adicionarCartaBaralho(cartaBuffPeq, 0);
                heroi.adicionarCartaBaralho(cartaBuffMed, 2);

                heroi.adicionarCartaBaralho(cartaVenenoPeq, 2);
                heroi.adicionarCartaBaralho(cartaVulneravelPeq, 1);
                heroi.adicionarCartaBaralho(cartaEnfraquecidoPeq, 1);

                heroi.adicionarCartaBaralho(cartaCuraPeq, 1);
                heroi.adicionarCartaBaralho(cartaCuraMed, 1);
                heroi.adicionarCartaBaralho(cartaCuraGrnd, 1);
            }
        }
    }
}
