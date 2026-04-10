package ProjetoPoo.Cartas;

import java.util.ArrayList;

import ProjetoPoo.Artes;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;


public class CartaDano extends Carta{

    // Atributos

    protected int ataque;

    // Getters

    public int getAtaque() {
        return ataque;
    }

    // Constructor

    public CartaDano(String nome, String descricao, int custo, int ataque, AlvoCarta alvo, Artes arte) {
        super(nome, descricao, custo, alvo, arte);
        this.ataque = ataque;
    }

    public CartaDano(CartaDano copia) {
        super(copia);
        this.ataque = copia.ataque;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade... alvos) {
        for (Entidade target : alvos) {
            int danoFinal = heroi.calcularDanoFinalAtaque(ataque, target);
            target.receberDano(danoFinal);
        }
    }

    @Override
    public void usar(Entidade heroi, ArrayList<Inimigo> alvos) {
        for (Entidade target : alvos) {
            int danoFinal = heroi.calcularDanoFinalAtaque(ataque, target);
            target.receberDano(danoFinal);
        }
    }

    @Override
    public Carta copiaCarta() {
        return new CartaDano(this);
    }
}

