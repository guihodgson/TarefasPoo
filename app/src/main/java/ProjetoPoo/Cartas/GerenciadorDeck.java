package ProjetoPoo.Cartas;

import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.EfeitoCura;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Eventos.Artes;

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
            
                EfeitoVeneno efeitoVeneno2 = new EfeitoVeneno(2, TipoEfeito.VENENO);
                EfeitoVeneno efeitoVeneno3 = new EfeitoVeneno(3, TipoEfeito.VENENO);
                EfeitoVulneravel efeitoVulneravel25 = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
                EfeitoEnfraquecido efeitoEnfraquecido25 = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);

                EfeitoCura efeitoCura3 = new EfeitoCura(3);
            
                // Baralho Po 1
            
                CartaDano cartaSkidoosh = new CartaDano("Skidoosh (18 de ataque)", "O Ataque Espiritual mais forte do Dragão Guerreiro", 5, 18, AlvoCarta.UM_ALVO, Artes.SKIDOOSH);
                CartaDano cartaDanoMed = new CartaDano("Barrigada do Panda (8 de ataque)", "Uma forte investida com a barriga do Dragão Guerreiro", 2, 8, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoPeq = new CartaDano("Soco do Panda (4 de ataque)", "Um soco levemente carinhoso do Dragão Guerreiro", 1, 4, AlvoCarta.UM_ALVO, Artes.BANG1);
                CartaDano cartaDanoGlobalMed = new CartaDano("Flatulencia do Dragão Guerreiro (8 de ataque para todos os inimigos)", "O Dragão Guerreiro solta uma flatulencia que atinge todos os inimigos", 2, 8, AlvoCarta.GLOBAL, Artes.FLATULENCIA);
                CartaDanoComEfeito cartaDanoComVeneno = new CartaDanoComEfeito("Soco Envenenado do Panda (6 de ataque + veneno por 2 rounds)", "O soco do Dragão Guerreiro é tão forte que aplica veneno no inimigo", 2, 6, efeitoVeneno2, AlvoCarta.UM_ALVO, Artes.BANG1);
            
                CartaEscudo cartaEscudoGrnd = new CartaEscudo("A Fuga do Panda (10 de defesa)", "O Dragão Guerreiro sairá correndo da batalha fugindo dos danos do ataque", 3, 10, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoMed = new CartaEscudo("Absorção de dano na Barriga (5 de defesa)", "A barriga do Dragão Guerreiro será usada para absorver o ataque", 2, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
                CartaEscudo cartaEscudoPeq = new CartaEscudo("Cambalhota do Panda (2 de defesa)", "O Dragão Guerreiro dará uma cambalhota e esquivará do dano do ataque", 1, 2, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
            
                CartaEfeito cartaBuffPeq = new CartaEfeito("Sorte no Ataque (+1 de ataque por 2 rounds)", "A sorte do Dragão Guerreiro aumentará o ataque do Dragão Guerreiro por 2 rounds", 1, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano1);
                CartaEfeito cartaBuffMed = new CartaEfeito("Canalizar o Chi (+2 de ataque por 3 rounds)", "O uso do Chi no ataque do Dragão Guerreiro aumentará o ataque por 3 rounds", 2, AlvoCarta.USO_PROPRIO, Artes.BONUS, efeitoBonusDano2);
            
                CartaEfeito cartaVenenoPeq = new CartaEfeito("Macarrão Envenenado (Veneno por +3 rounds)", "Uma comida special que aplica veneno no inimigo", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeitoVeneno3);
                CartaEfeito cartaVulneravelPeq = new CartaEfeito("Golpe Certeiro (+25% dano recebido por 2 rounds)", "O golpe certeiro deixa o inimigo mais vulnerável a ataques", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoVulneravel25);
                CartaEfeito cartaEnfraquecidoPeq = new CartaEfeito("Ameaça do Dragão Guerreiro (-25% dano causado por 2 rounds)", "O medo sobre o Dragão Guerreiro deixa o inimigo enfraquecido e ataca com menos dano", 1, AlvoCarta.UM_ALVO, Artes.BONUS, efeitoEnfraquecido25);
            
                CartaEfeito cartaCuraPeq = new CartaEfeito("Cura do Biscoito Chinês (3 de cura)", "O Biscoito Chinês dará mais vida para curar-se", 2, AlvoCarta.USO_PROPRIO, Artes.CURA, efeitoCura3);

                // Adicionando as cartas ao baralho do herói

                heroi.adicionarCartaBaralho(cartaDanoMed, 3);
                heroi.adicionarCartaBaralho(cartaDanoPeq, 2);
                heroi.adicionarCartaBaralho(cartaSkidoosh, 1);
                heroi.adicionarCartaBaralho(cartaDanoGlobalMed, 2);
                heroi.adicionarCartaBaralho(cartaDanoComVeneno, 2);

                heroi.adicionarCartaBaralho(cartaEscudoPeq, 1);
                heroi.adicionarCartaBaralho(cartaEscudoMed, 2);
                heroi.adicionarCartaBaralho(cartaEscudoGrnd, 1);

                heroi.adicionarCartaBaralho(cartaBuffPeq, 2);
                heroi.adicionarCartaBaralho(cartaBuffMed, 2);

                heroi.adicionarCartaBaralho(cartaVenenoPeq, 2);
                heroi.adicionarCartaBaralho(cartaVulneravelPeq, 2);
                heroi.adicionarCartaBaralho(cartaEnfraquecidoPeq, 2);

                heroi.adicionarCartaBaralho(cartaCuraPeq, 1);
            }
        }
    }
}
