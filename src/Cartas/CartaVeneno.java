package Cartas;

import Entidades.Entidade;

public class CartaVeneno extends Carta {

    // Atributos

    protected int veneno;
    protected int tempo;

    // Getters

    public int getVeneno() {
        return veneno;
    }

    // Constructor

    public CartaVeneno(String nome, String descricao, int custo, int veneno, int tempo) {
        super(nome, descricao, custo);
        this.veneno = veneno;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        alvo.ganharVeneno(veneno, tempo);
    }
}
