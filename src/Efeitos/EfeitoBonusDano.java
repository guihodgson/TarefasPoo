package Efeitos;

public class EfeitoBonusDano implements Efeito{

    // Atributos

    protected int dano;
    protected int duracao;

    // Getters

    public int getDano() {
        return dano;
    }

    @Override
    public int getDuracao() {
        return duracao;
    }

    // Constructor

    public EfeitoBonusDano(int dano, int duracao) {
        this.dano = dano;
        this.duracao = duracao;
    }

    // Metodo

    @Override
    public void atualizar(String evento, Object objeto) {
        if (evento.equals("fimRound")) {
            if (duracao > 0) {
                duracao--;
            }
        }
    }

    public void adicionarDuracao(int valor) {
        duracao += valor;
    }
}
