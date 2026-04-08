package ProjetoPoo.Entidades;
import java.util.ArrayList;

import ProjetoPoo.Cartas.Baralho;
import ProjetoPoo.Cartas.Carta;

public class Heroi extends Entidade {

    // Atributos

    private final int nCartasDeck;
    private final Baralho baralho;
    private final Baralho deck;
    private final Baralho descarte;
    

    // Getters

    public int getNCartasDeck() {
        return nCartasDeck;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getEnergia() {
        return energia;
    }

    // Constructor

    public Heroi(String nome, int vida, int escudo, int energia, int nCartasDeck) {
        super(nome, vida, escudo);
        this.energia = energiaMax = energia;
        this.nCartasDeck = nCartasDeck;
        baralho = new Baralho();
        deck = new Baralho();
        descarte = new Baralho();
    }

    // Metodos

    public void adicionarCartaBaralho(Carta carta) {
        baralho.adicionarCarta(carta);
    }

    public void adicionarCartaBaralho(Carta carta, int n) {
        for (int i = 0; i < n; i++) {
            baralho.adicionarCarta(carta.copiaCarta());  
        }
    }

    public int tamDeck() {
        return deck.tamanho();
    }

    public ArrayList<String> mostrarDeck() {
        return deck.mostrarBaralho();
    }

    public void usarCartaNDeck(int n, Entidade... alvos) {
        Carta atual = deck.retirarCartaN(n);
        atual.usar(this, alvos);
        descarte.adicionarCarta(atual);
    }

    public Carta getCartaNDeck(int n) {
        return deck.mostrarCartaN(n);
    }

    public void deckInicial() {
        baralho.embaralhar();
        baralho.transferirNCartas(deck, nCartasDeck);
    }

    public void resetarBaralho() {
        deck.transferirCartas(descarte);
        int cartasRestantes = baralho.cartasRestantes();
        int cartasComprar = nCartasDeck;
        if (cartasRestantes < nCartasDeck) {
            baralho.transferirNCartas(deck, cartasRestantes);
            cartasComprar -= cartasRestantes;
            descarte.transferirCartas(baralho);
            baralho.embaralhar();
        }
        baralho.transferirNCartas(deck, cartasComprar);
    }

    public void resetarRound() {
        this.resetarEnergia();
        this.resetarEscudo();
        this.resetarBaralho();
    }
}