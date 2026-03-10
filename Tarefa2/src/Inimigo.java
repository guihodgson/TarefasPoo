public class Inimigo extends Entidade {

    // Atributos

    private int danoBase;

    // Constructor

    public Inimigo(String nome, int vida, int escudo) {
        super(nome, vida, escudo);
    }

    // Metodos

    public void atacar(Heroi heroi) {
        heroi.receberDano(danoBase + getBuffDano());
    }

}