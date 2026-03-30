package Efeitos;

public class EfeitoVulneravel implements Efeito {

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

    public EfeitoVulneravel(int porcentagem, int duracao) {
        this.porcentagem = porcentagem;
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