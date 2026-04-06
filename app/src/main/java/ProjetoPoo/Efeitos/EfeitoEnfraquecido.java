package ProjetoPoo.Efeitos;

public class EfeitoEnfraquecido extends Efeito {

    // Atributos

    protected int porcentagem;
    protected int duracao;

    // Getters

    public int getPorcentagem() {
        return porcentagem;
    }

    @Override
    public int getDuracao() {
        return duracao;
    }

    // Constructor

    public EfeitoEnfraquecido(int porcentagem, int duracao, TipoEfeito tipo) {
        this.porcentagem = porcentagem;
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