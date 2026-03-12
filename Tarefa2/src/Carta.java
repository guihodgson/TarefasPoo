
public abstract class Carta {

    // Atributos

    protected String nome;
    protected String descricao;
    protected int custo;

    // Getters

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    // Constructor

    public Carta(String nome, String descricao, int custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    // Metodos

    public abstract void usar(Entidade entidade);   

}
