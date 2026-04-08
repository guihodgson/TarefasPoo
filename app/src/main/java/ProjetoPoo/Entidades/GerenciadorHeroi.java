package ProjetoPoo.Entidades;

import ProjetoPoo.Cartas.GerenciadorDeck;

public class GerenciadorHeroi {

    public static Heroi criarHeroi(int vida, int energia, int opcao) {
        Heroi heroi;

        if (opcao == 0) {
            heroi = new Heroi("Po, o Dragao Guerreiro", vida, 0, energia, 5);
        } 
        else {
            heroi = new Heroi("Po, o Dragao Guerreiro", vida, 0, energia, 6);
        }

        GerenciadorDeck.criarDeckHeroi(heroi, opcao);

        heroi.deckInicial();
        return heroi;
    }
}
