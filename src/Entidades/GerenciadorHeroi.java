package Entidades;

import Cartas.CartaBuffDano;
import Cartas.CartaCura;
import Cartas.CartaDano;
import Cartas.CartaEscudo;

public class GerenciadorHeroi {

    public static Heroi criarHeroi() {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 32, 0, 5);

        // Baralho Po

        CartaDano cartaSkidoosh = new CartaDano("Skidoosh (15)", "", 5, 15);
        CartaDano cartaDanoMed = new CartaDano("Ataque Medio (5)", "MuchoDano", 2, 5);
        CartaDano cartaDanoPeq = new CartaDano("Ataque Leve (2)", "lala", 1, 2);

        CartaEscudo cartaEscudoGrnd = new CartaEscudo("Escudo Grande (10)", "Aiaiai", 3, 10);
        CartaEscudo cartaEscudoMed = new CartaEscudo("Escudo Medio (5)", "Aiaiai", 2, 5);
        CartaEscudo cartaEscudoPeq = new CartaEscudo("Escudo Pequeno (2)", "Aiaiai", 1, 2);

        CartaBuffDano cartaBuffPeq = new CartaBuffDano("Bonus de Ataque Pequeno (1 por 2 rounds)", "danodano", 1, 1, 2);
        CartaBuffDano cartaBuffMed = new CartaBuffDano("Bonus de Ataque Medio (2 por 3 rounds)", "danodano", 2, 2, 3);

        CartaCura cartaCuraPeq = new CartaCura("Cura Pequena (3)", null, 2, 2);
        CartaCura cartaCuraMed = new CartaCura("Cura Media (5)", null, 3, 3);
        CartaCura cartaCuraGrnd = new CartaCura("Cura Grande (4)", null, 4, 4);

        heroi.adicionarCartaBaralho(cartaDanoMed, 3);
        heroi.adicionarCartaBaralho(cartaDanoPeq, 2);
        heroi.adicionarCartaBaralho(cartaSkidoosh, 1);

        heroi.adicionarCartaBaralho(cartaEscudoPeq, 1);
        heroi.adicionarCartaBaralho(cartaEscudoMed, 2);
        heroi.adicionarCartaBaralho(cartaEscudoGrnd, 1);

        heroi.adicionarCartaBaralho(cartaBuffPeq, 2);
        heroi.adicionarCartaBaralho(cartaBuffMed, 2);

        heroi.adicionarCartaBaralho(cartaCuraPeq, 1);
        heroi.adicionarCartaBaralho(cartaCuraMed, 1);

        heroi.deckInicial();
        return heroi;
    }
}
