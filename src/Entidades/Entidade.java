package Entidades;

public class Entidade {
    
    // Atributos

    protected String nome;

    protected int vidaMax;
    protected int vida;
    protected int escudo;

    protected int energia;
    protected int energiaMax;

    protected int tempoBuff;
    protected int buffDano;

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

    public int getTempoBuff() {
        return tempoBuff;
    }

    public int getBuffDano() {
        return buffDano;
    }

    // Constructor

    public Entidade(String nome, int vida, int escudo) {
        this.nome = nome;

        this.vida = vidaMax = vida;
        this.escudo = escudo;

        this.buffDano = 0;
    }


    // Metodos

    public void receberDano(int dano) {
        if (dano <= escudo) {
            escudo -= dano;
        }
        else {
            vida -= (dano - escudo);
            escudo = 0;
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

    public void resetarEscudo() {
        escudo = 0;
    }

    public boolean estaVivo() {
        return vida > 0 ? true : false;
    }

    public int ganharBuffDano(int valor, int tempo) {
        // if (buffDano < valor) {
        //     buffDano = valor;
        // }  Logica defasada
        buffDano = valor;
        tempoBuff += tempo;
        return buffDano;
    }

    public void resetarBuff() {
        if (tempoBuff > 0) {
            tempoBuff--;
        }
        if (tempoBuff == 0) {
            buffDano = 0;
        }
    }

    public void resetarEnergia() {
        energia = energiaMax;
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
}