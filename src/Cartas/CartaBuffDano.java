package Cartas;

import Entidades.Entidade;

public class CartaBuffDano extends Carta {

    // Atributos

    protected int buff;
    protected int tempo;

    // Getters

    public int getBuff() {
        return buff;
    }

    // Constructor

    public CartaBuffDano(String nome, String descricao, int custo, int buff, int tempo) {
        super(nome, descricao, custo);
        this.buff = buff;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        heroi.ganharBuffDano(buff, tempo);
    }
}
