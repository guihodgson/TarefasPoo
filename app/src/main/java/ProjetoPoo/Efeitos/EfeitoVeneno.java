package ProjetoPoo.Efeitos;

import ProjetoPoo.Cor;
import ProjetoPoo.Entidades.Entidade;

public class EfeitoVeneno extends Efeito{

    // Constructor

    public EfeitoVeneno(int duracao, TipoEfeito tipo) {
        super(tipo, 0, duracao);
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
                    alvo.receberDano(duracao);
                    System.out.println(alvo.getNome() + " tomou " + duracao + " de dano de " +  Cor.formataCor(Cor.VERDE, "Veneno."));
                    System.out.println();
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
