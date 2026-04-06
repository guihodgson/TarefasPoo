package ProjetoPoo.Efeitos;

public class EfeitoBonusDano extends Efeito{

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

    public EfeitoBonusDano(int dano, int duracao, TipoEfeito tipo) {
        this.dano = dano;
        this.duracao = duracao;
        this.tipo = tipo;
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
