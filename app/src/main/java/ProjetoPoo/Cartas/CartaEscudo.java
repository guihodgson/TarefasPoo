package ProjetoPoo.Cartas;
import ProjetoPoo.Entidades.Entidade;

public class CartaEscudo extends Carta{

    // Atributos

    protected int defesa;

    // Getters

    public int getDefesa() {
        return defesa;
    }

    // Constructor

    public CartaEscudo(String nome, String descricao, int custo, int defesa, AlvoCarta tipo) {
        super(nome, descricao, custo, tipo);
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
    public Carta copiaCarta() {
        return new CartaEscudo(this);
    }
}
