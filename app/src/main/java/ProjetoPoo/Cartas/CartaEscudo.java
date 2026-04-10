package ProjetoPoo.Cartas;
import java.util.ArrayList;

import ProjetoPoo.Batalhas.Artes;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;

public class CartaEscudo extends Carta{

    // Atributos

    protected int defesa;

    // Getters

    public int getDefesa() {
        return defesa;
    }

    // Constructor

    public CartaEscudo(String nome, String descricao, int custo, int defesa, AlvoCarta alvo, Artes arte) {
        super(nome, descricao, custo, alvo, arte);
        this.defesa = defesa;
    }

    public CartaEscudo(CartaEscudo copia) {
        super(copia);
        this.defesa = copia.defesa;
    }

    // Metodos

    @Override
    public void usar(Entidade atacante, Entidade... alvos) {
        atacante.ganharEscudo(defesa);
    }

    @Override
    public void usar(Entidade atacante, ArrayList<Inimigo> alvos) {
        atacante.ganharEscudo(defesa);
    }

    @Override
    public Carta copiaCarta() {
        return new CartaEscudo(this);
    }
}
