package ProjetoPoo.Efeitos;

public abstract class Efeito {

    protected TipoEfeito tipo;
    protected int valor;
    protected int duracao;

    public TipoEfeito getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public abstract void adicionarDuracao(int tempo);

    public abstract void atualizar(String evento, Object objeto);
}
