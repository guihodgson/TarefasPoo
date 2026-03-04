public class Inimigo {
    
    // Atributos

    private String nome;

    private int vidaMax;
    private int vida;
    private int escudo;

    private int danoBase;
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

    public Inimigo(String nome, int vida, int escudo, int danoBase) {
        this.nome = nome;
        this.vida = vidaMax = vida;
        this.escudo = escudo;
        this.danoBase = danoBase;
        this.buffDano = 0;
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

    public int ganharBuffDano(int valor) {
        buffDano += valor;
        return buffDano;
    }

    public int atacar(Heroi heroi) {
        heroi.receberDano(danoBase + buffDano);
        return danoBase + buffDano;
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
