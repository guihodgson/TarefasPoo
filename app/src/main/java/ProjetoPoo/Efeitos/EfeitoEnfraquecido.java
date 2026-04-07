package ProjetoPoo.Efeitos;

public class EfeitoEnfraquecido extends Efeito {

    // Constructor

    public EfeitoEnfraquecido(int valor, int duracao, TipoEfeito tipo) {
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