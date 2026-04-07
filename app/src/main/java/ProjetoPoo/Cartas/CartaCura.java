package ProjetoPoo.Cartas;
import ProjetoPoo.Entidades.Entidade;


public class CartaCura extends Carta{

    // Atributos

    protected int cura;

    // Getters

    public int getCura() {
        return cura;
    }

    // Constructor

    public CartaCura(String nome, String descricao, int custo, int cura, AlvoCarta tipo) {
        super(nome, descricao, custo, tipo);
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
    public Carta copiaCarta() {
        return new CartaCura(this);
    }
}

