public class Heroi {

    // Atributos

    private String nome;

    private int vidaMax;
    private int vida;
    private int escudo;

    private int energiaMax;
    private int energia;

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

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getEnergia() {
        return energia;
    }

    public int getBuffDano() {
        return buffDano;
    }

    // Constructor

    public Heroi(String nome, int vida, int escudo, int energia) {
        this.nome = nome;

        this.vida = vidaMax = vida;
        this.escudo = escudo;
        this.energia = energiaMax = energia;

        this.buffDano = 0;
    }

    // Metodos

    public int receberDano(int dano) {
        if (dano <= escudo) {
            escudo -= dano;
            return vida;
        }
        else {
            dano -= escudo;
            escudo = 0;
            vida -= dano;
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

    public int ganharBuffDano(int valor) {
        buffDano += valor;
        return buffDano;
    }

    public void resetarBuff() {
        buffDano = 0;
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

    public void resetarEscudo() {
        escudo = 0;
    }

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

    public boolean estaVivo() {
        if (vida > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
