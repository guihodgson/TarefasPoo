package ProjetoPoo.Efeitos;

public class EfeitoBonusDano extends Efeito{

    // Constructor

    public EfeitoBonusDano(int valor, int duracao, TipoEfeito tipo) {
        super(tipo, valor, duracao);
    }

    public EfeitoBonusDano(EfeitoBonusDano copia) {
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
        return new EfeitoBonusDano(this);
    }
}
