public class Heroi extends Entidade {

    // Atributos

    private int energiaMax;
    private int energia;
    private Baralho baralho;
    private Baralho deck;
    private Baralho descarte;
    

    // Getters

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getEnergia() {
        return energia;
    }

    // Constructor

    public Heroi(String nome, int vida, int escudo) {
        super(nome, vida, escudo);
        baralho = new Baralho();
        descarte = new Baralho();
    }

    // Metodos

    public boolean podeGastarEnergia(int valor) {
        if (valor <= energia) {
            energia -= valor;
            return true;
        }
        else {
            return false;
        }
    }

    public void resetarEnergia() {
        energia = energiaMax;
    }

    public void resetRound() {
        this.resetarBuff();
        this.resetarEnergia();
        this.resetarEscudo();
    }
}