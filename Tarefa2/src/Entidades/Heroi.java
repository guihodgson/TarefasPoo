package Entidades;
import Cartas.Baralho;
import Cartas.Carta;
import java.util.ArrayList;

public class Heroi extends Entidade {

    // Atributos

    private int energiaMax;
    private int energia;
    private int nCartasDeck = 5;
    private Baralho baralho;
    private Baralho deck;
    private Baralho descarte;
    

    // Getters

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getEnergia() {
        return energia;
    }

    // Constructor

    public Heroi(String nome, int vida, int escudo) {
        super(nome, vida, escudo);
        baralho = new Baralho();
        deck = new Baralho();
        descarte = new Baralho();
    }

    // Metodos

    public boolean podeGastarEnergia(int valor) {
        if (valor <= energia) {
            energia -= valor;
            return true;
        }
        else {
            return false;
        }
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

    public void resetarEnergia() {
        energia = energiaMax;
    }

    public void resetarRound() {
        this.resetarBuff();
        this.resetarEnergia();
        this.resetarEscudo();
        this.resetarBaralho();
    }
}