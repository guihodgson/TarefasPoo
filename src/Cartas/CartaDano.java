package Cartas;
import Entidades.Entidade;


public class CartaDano extends Carta{

    // Atributos

    protected int ataque;

    // Getters

    public int getAtaque() {
        return ataque;
    }

    // Constructor

    public CartaDano(String nome, String descricao, int custo, int ataque) {
        super(nome, descricao, custo);
        this.ataque = ataque;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        if (heroi.getTempoBuff() > 0) {
            alvo.receberDano(ataque + heroi.getBuffDano());
        }
        else {
            alvo.receberDano(ataque);
        }
    }
}

