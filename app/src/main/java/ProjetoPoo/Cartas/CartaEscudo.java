package ProjetoPoo.Cartas;
import java.util.ArrayList;

import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.Eventos.Artes;

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
    public void usar(Entidade heroi, Entidade alvo) {
        ArrayList<Inimigo> alvos = new ArrayList<>();
        alvos.add((Inimigo) alvo);
        usar(heroi, alvos);
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
