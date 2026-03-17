package Entidades;
import Cartas.Baralho;
import Cartas.Carta;
import java.util.ArrayList;

public class Heroi extends Entidade {

    // Atributos

    private int nCartasDeck = 5;
    private Baralho baralho;
    private Baralho deck;
    private Baralho descarte;
    

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

    public Heroi(String nome, int vida, int escudo, int energia) {
        super(nome, vida, escudo);
        this.energia = energiaMax = energia;
        baralho = new Baralho();
        deck = new Baralho();
        descarte = new Baralho();
    }

    // Metodos

    public void adicionarCartaBaralho(Carta carta) {
        baralho.adicionarCarta(carta);
    }

    public int tamDeck() {
        return deck.tamanho();
    }

    public ArrayList<String> mostrarDeck() {
        return deck.mostrarBaralho();
    }

    public void usarCartaNDeck(int n, Entidade alvo) {
        Carta atual = deck.retirarCartaN(n);
        atual.usar(this, alvo);
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
        this.resetarBuff();
        this.resetarEnergia();
        this.resetarEscudo();
        this.resetarBaralho();
    }
}