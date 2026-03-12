

public class CartaEscudo extends Carta{

    // Atributos

    protected int defesa;

    // Getters

    public int getDefesa() {
        return defesa;
    }

    // Constructor

    public CartaEscudo(String nome, String descricao, int custo, int defesa) {
        super(nome, descricao, custo);
        this.defesa = defesa;
    }

    // Metodos

    @Override
    public void usar(Entidade atacante, Entidade ) {
        entidade.ganharEscudo(defesa);
    }
}
