package ProjetoPoo.Efeitos;

public class EfeitoEnfraquecido extends Efeito {

    // Constructor

    public EfeitoEnfraquecido(int valor, int duracao, TipoEfeito tipo) {
        super(tipo, valor, duracao);
    }

    public EfeitoEnfraquecido(EfeitoEnfraquecido copia) {
        super(copia);
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

    @Override
    public Efeito copiaEfeito() {
        return new EfeitoEnfraquecido(this);
    }
}