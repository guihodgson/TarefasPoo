package ProjetoPoo.Efeitos;

public class EfeitoVulneravel extends Efeito {

    // Constructor

    public EfeitoVulneravel(int valor, int duracao, TipoEfeito tipo) {
        this.tipo = tipo;
        this.valor = valor;
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
}