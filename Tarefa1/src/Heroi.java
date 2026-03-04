public class Heroi {

    // Atributos

    private String nome;

    private int vidaMax;
    private int vida;
    private int escudo;

    private int buffDano;

    // Getters

    public String getNome() {
        return nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }


    // Constructor

    public Heroi(String nome, int vida, int escudo) {
        this.nome = nome;
        this.vida = vidaMax = vida;
        this.escudo = escudo;
    }

    // Metodos

    public int receberDano(int dano) {
        if (dano <= escudo) {
            return vida;
        }
        else {
            vida -= (dano - escudo);
            return vida;
        }
    }

    public int curarVida(int valor) {
        if (vida + valor > vidaMax) {
            vida = vidaMax;
        }
        else {
            vida += valor;
        }
        return vida;
    }

    public int buffarDano(int valor) {
        buffDano += valor;
        return buffDano;
    }

    public int ganharEscudo(int valor) {
        escudo += valor;
        return escudo;
    }

    public int perderEscudo(int valor) {
        if (escudo - valor < 0) {
            escudo = 0;
        }
        else {
            escudo -= valor;
        }
        return escudo;
    }

    public boolean estaVivo() {
        if (vida > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
