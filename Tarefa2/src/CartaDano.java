public class CartaDano {

    // Atributos

    private String nome;
    private int custo;
    private int ataque;

    // Getters

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    public int getAtaque() {
        return ataque;
    }

    // Constructor

    public CartaDano(String nome, int custo, int ataque) {
        this.nome = nome;
        this.custo = custo;
        this.ataque = ataque;
    }

    // Metodos

    public void usarAtaque(Inimigo inimigo) {
        inimigo.receberDano(ataque);
    }
}

