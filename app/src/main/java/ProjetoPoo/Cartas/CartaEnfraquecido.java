package ProjetoPoo.Cartas;
import ProjetoPoo.Entidades.Entidade;

public class CartaEnfraquecido extends CartaEfeito {

    // Atributos

    protected int porcentagem;
    protected int tempo;

    // Getters

    public int getPorcentagem() {
        return porcentagem;
    }

    // Constructor

    public CartaEnfraquecido(String nome, String descricao, int custo, int porcentagem, int tempo) {
        super(nome, descricao, custo);
        this.porcentagem = porcentagem;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        alvo.ganharEnfraquecido(porcentagem, tempo);
    }
}