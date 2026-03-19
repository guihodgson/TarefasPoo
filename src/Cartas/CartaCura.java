package Cartas;
import Entidades.Entidade;


public class CartaCura extends Carta{

    // Atributos

    protected int cura;

    // Getters

    public int getCura() {
        return cura;
    }

    // Constructor

    public CartaCura(String nome, String descricao, int custo, int cura) {
        super(nome, descricao, custo);
        this.cura = cura;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        heroi.curarVida(cura);
    }
}

