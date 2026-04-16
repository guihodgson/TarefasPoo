package ProjetoPoo.Cartas;

import java.util.ArrayList;

import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.Eventos.Artes;


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
    public void usar(Entidade heroi, Entidade alvo) {
        ArrayList<Inimigo> alvos = new ArrayList<>();
        alvos.add((Inimigo) alvo);
        usar(heroi, alvos);
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

