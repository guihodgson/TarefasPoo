package Cartas;

import Entidades.Entidade;

public class CartaBonusDano extends Carta {

    // Atributos

    protected int bonus;
    protected int tempo;

    // Getters

    public int getBonus() {
        return bonus;
    }

    // Constructor

    public CartaBonusDano(String nome, String descricao, int custo, int bonus, int tempo) {
        super(nome, descricao, custo);
        this.bonus = bonus;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        heroi.ganharBonusDano(bonus, tempo);
    }
}
