package ProjetoPoo.Efeitos;

public class EfeitoVulneravel extends Efeito {

    // Constructor

    public EfeitoVulneravel(int valor, int duracao, TipoEfeito tipo) {
        super(tipo, valor, duracao);
    }

    public EfeitoVulneravel(EfeitoVulneravel copia) {
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
        return new EfeitoVulneravel(this);
    }
}