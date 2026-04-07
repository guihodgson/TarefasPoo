package ProjetoPoo.Cartas;

import ProjetoPoo.Entidades.Entidade;


public class CartaDano extends Carta{

    // Atributos

    protected int ataque;

    // Getters

    public int getAtaque() {
        return ataque;
    }

    // Constructor

    public CartaDano(String nome, String descricao, int custo, int ataque, AlvoCarta tipo) {
        super(nome, descricao, custo, tipo);
        this.ataque = ataque;
    }

    public CartaDano(CartaDano copia) {
        super(copia);
        this.ataque = copia.ataque;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade... alvos) {
        for (Entidade alvo : alvos) {
            int danoFinal = heroi.calcularDanoFinalAtaque(ataque, alvo);
            alvo.receberDano(danoFinal);
        }
    }

    @Override
    public Carta copiaCarta() {
        return new CartaDano(this);
    }
}

