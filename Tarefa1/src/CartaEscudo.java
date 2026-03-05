public class CartaEscudo {

    // Atributos

    private String nome;
    private int custo;
    private int defesa;

    // Getters

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    public int getDefesa() {
        return defesa;
    }

    // Constructor

    public CartaEscudo(String nome, int custo, int defesa) {
        this.nome = nome;
        this.custo = custo;
        this.defesa = defesa;
    }

    // Metodos

    public void usarEscudo(Heroi heroi) {
        heroi.ganharEscudo(defesa);
    }
}
