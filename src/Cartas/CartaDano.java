package Cartas;
import Entidades.Entidade;


public class CartaDano extends Carta{

    // Atributos

    protected int ataque;

    // Getters

    public int getAtaque() {
        return ataque;
    }

    // Constructor

    public CartaDano(String nome, String descricao, int custo, int ataque) {
        super(nome, descricao, custo);
        this.ataque = ataque;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        int danoBase = ataque + heroi.calcularBonusDano();
        int danoCausado = heroi.calcularDanoAtaqueCausado(danoBase);
        int danoFinal = alvo.calcularDanoAtaqueRecebido(danoCausado);
        alvo.receberDano(danoFinal);
    }
}

