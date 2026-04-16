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
    private int moedas;
    

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
        moedas = 0;
    }

    // Metodos

    public void aumentarMoedas(int valor) {
        moedas += valor;
    }

    public boolean podeGastarMoedas(int valor) {
        return moedas >= valor;
    }

    public void gastarMoedas(int valor) {
        if (podeGastarMoedas(valor)) {
            moedas -= valor;
        } else {
            throw new IllegalArgumentException("Moedas insuficientes.");
        }
    }

    public void perderMoedas(int valor) {
        moedas -= valor;
        if (moedas < 0) {
            moedas = 0;
        }
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

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

    public void usarCartaNDeck(int n, ArrayList<Inimigo> alvos) {
        Carta atual = deck.retirarCartaN(n);
        atual.usar(this, alvos);
        descarte.adicionarCarta(atual);
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

    public ArrayList<String> listarOpcoesSubstituicaoMesmoTipo(Carta novaCarta) {
        ArrayList<String> opcoes = new ArrayList<>();
        ArrayList<CartaSlot> slots = coletarCartasMesmoTipo(novaCarta);

        for (CartaSlot slot : slots) {
            Carta carta = slot.carta;
            String linha = String.format("%s | Custo: %d | %s", carta.getNome(), carta.getCusto(), slot.origem);
            opcoes.add(linha);
        }

        return opcoes;
    }

    public String substituirCartaMesmoTipo(Carta novaCarta, int indiceOpcao) {
        ArrayList<CartaSlot> slots = coletarCartasMesmoTipo(novaCarta);
        if (indiceOpcao < 0 || indiceOpcao >= slots.size()) {
            return null;
        }

        CartaSlot slotEscolhido = slots.get(indiceOpcao);
        Carta removida = slotEscolhido.baralhoOrigem.retirarCartaN(slotEscolhido.indiceNoBaralho);
        adicionarCartaBaralho(novaCarta.copiaCarta());
        return removida.getNome();
    }

    private ArrayList<CartaSlot> coletarCartasMesmoTipo(Carta referencia) {
        ArrayList<CartaSlot> slots = new ArrayList<>();
        Class<?> tipo = referencia.getClass();

        coletarDeBaralho(slots, baralho, "Pilha de compra", tipo);
        coletarDeBaralho(slots, deck, "Mao atual", tipo);
        coletarDeBaralho(slots, descarte, "Descarte", tipo);

        return slots;
    }

    private void coletarDeBaralho(ArrayList<CartaSlot> slots, Baralho origem, String nomeOrigem, Class<?> tipo) {
        for (int i = 0; i < origem.tamanho(); i++) {
            Carta carta = origem.mostrarCartaN(i);
            if (carta.getClass() == tipo) {
                slots.add(new CartaSlot(origem, i, carta, nomeOrigem));
            }
        }
    }

    private static class CartaSlot {
        private final Baralho baralhoOrigem;
        private final int indiceNoBaralho;
        private final Carta carta;
        private final String origem;

        private CartaSlot(Baralho baralhoOrigem, int indiceNoBaralho, Carta carta, String origem) {
            this.baralhoOrigem = baralhoOrigem;
            this.indiceNoBaralho = indiceNoBaralho;
            this.carta = carta;
            this.origem = origem;
        }
    }
}