package ProjetoPoo.Cartas;
import java.util.ArrayList;

import ProjetoPoo.Batalhas.Artes;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;


public class CartaCura extends Carta{

    // Atributos

    protected int cura;

    // Getters

    public int getCura() {
        return cura;
    }

    // Constructor

    public CartaCura(String nome, String descricao, int custo, int cura, AlvoCarta alvo, Artes arte) {
        super(nome, descricao, custo, alvo, arte);
        this.cura = cura;
    }

    public CartaCura(CartaCura copia) {
        super(copia);
        this.cura = copia.cura;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade... alvo) {
        heroi.curarVida(cura);
    }

    @Override
    public void usar(Entidade heroi, ArrayList<Inimigo> alvos) {
        heroi.curarVida(cura);
    }

    @Override
    public Carta copiaCarta() {
        return new CartaCura(this);
    }
}

