package ProjetoPoo.Efeitos;

import ProjetoPoo.Entidades.Entidade;

public class EfeitoCura extends Efeito {

    // Constructor

    public EfeitoCura(int valor) {
        super(TipoEfeito.CURA, valor, 1);
    }

    public EfeitoCura(EfeitoCura copia) {
        super(copia);
    }

    // Metodos

    @Override
    public void atualizar(String evento, Object objeto) {
        if (evento.equals("acao")) {
            if (objeto instanceof Entidade alvo) {
                if (duracao > 0) {
                    alvo.curarVida(valor);
                    duracao = 0;
                }
            }
        }
    }

    @Override
    public Efeito copiaEfeito() {
        return new EfeitoCura(this);
    }
}
