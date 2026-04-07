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

    public void adicionarDuracao(int tempo) {
        duracao += tempo;
    }

    public Efeito(TipoEfeito tipo, int valor, int duracao) {
        this.tipo = tipo;
        this.valor = valor;
        this.duracao = duracao;
    }

    public Efeito(Efeito copia) {
        this.tipo = copia.tipo;
        this.valor = copia.valor;
        this.duracao = copia.duracao;
    }

    public abstract Efeito copiaEfeito();

    public abstract void atualizar(String evento, Object objeto);
}
