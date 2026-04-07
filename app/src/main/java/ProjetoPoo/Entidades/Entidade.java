package ProjetoPoo.Entidades;

import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Efeitos.GerenciadorEfeitos;
import ProjetoPoo.Efeitos.TipoEfeito;

public class Entidade {
    
    // Atributos

    protected String nome;

    protected int vidaMax;
    protected int vida;
    protected int escudo;

    protected int energia;
    protected int energiaMax;

    protected int buffDano;

    protected GerenciadorEfeitos gerenciadorEfeitos = new GerenciadorEfeitos();

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

    public GerenciadorEfeitos getGerenciadorEfeitos() {
        return gerenciadorEfeitos;
    }

    // Constructor

    public Entidade(String nome, int vida, int escudo) {
        this.nome = nome;

        this.vida = vidaMax = vida;
        this.escudo = escudo;
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
        return vida > 0;
    }

    public void ganharEfeito(Efeito efeito, int valor, int tempo) {
        gerenciadorEfeitos.ganharEfeito(efeito, valor, tempo);
    }

    public void perderEfeito(Efeito efeito) {
        gerenciadorEfeitos.perderEfeito(efeito);
    }

    public int getValorEfeito(TipoEfeito tipo) {
        return gerenciadorEfeitos.getValorEfeito(tipo);
    }

    public int getTempoEfeito(TipoEfeito tipo) {
        return gerenciadorEfeitos.getTempoEfeito(tipo);
    }

    public int calcularDanoFinalAtaque(int danoBase, Entidade alvo) {
        return gerenciadorEfeitos.calcularDanoFinalAtaque(danoBase, this, alvo);
    }

    public void resetarEnergia() {
        energia = energiaMax;
    }

    public boolean podeGastarEnergia(int valor) {
        return (valor <= energia);
    }

    public void gastarEnergia(int valor) {
        energia -= valor;
    }

    public void atualizarEfeito(String evento) {
        gerenciadorEfeitos.atualizarEfeito(evento, this);
    }

    public void limparEfeitosExpirados() {
        gerenciadorEfeitos.limparEfeitosExpirados();
    }
}