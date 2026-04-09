package ProjetoPoo.Efeitos;

public abstract class Efeito {

    // Atributos

    protected TipoEfeito tipo;
    protected int valor;
    protected int duracao;

    // Getters

    public TipoEfeito getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public int getDuracao() {
        return duracao;
    }

    // Constructor

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

    // Metodos

    public abstract Efeito copiaEfeito();

    public abstract void atualizar(String evento, Object objeto);

        public void adicionarDuracao(int tempo) {
        duracao += tempo;
    }
}
