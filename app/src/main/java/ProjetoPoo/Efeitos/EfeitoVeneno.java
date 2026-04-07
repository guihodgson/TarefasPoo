package ProjetoPoo.Efeitos;

import ProjetoPoo.Entidades.Entidade;

public class EfeitoVeneno extends Efeito{

    // Constructor

    public EfeitoVeneno(int valor, int duracao, TipoEfeito tipo) {
        super(tipo, valor, duracao);
    }

    public EfeitoVeneno(EfeitoVeneno copia) {
        super(copia);
    }

    // Metodo

    @Override
    public void atualizar(String evento, Object objeto) {
        if(objeto instanceof Entidade alvo) {
            if (evento.equals("fimRound")) {
                if (duracao > 0) {
                    alvo.receberDano(valor);
                    System.out.println(alvo.getNome() + " tomou " + valor + " de dano de Veneno.");
                    duracao--;
                }
            }
        }
    }

    @Override
    public Efeito copiaEfeito() {
        return new EfeitoVeneno(this);
    }
}
