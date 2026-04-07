package ProjetoPoo.Efeitos;

import ProjetoPoo.Entidades.Entidade;

public class EfeitoVeneno extends Efeito{

    // Constructor

    public EfeitoVeneno(int valor, int duracao, TipoEfeito tipo) {
        this.tipo = tipo;
        this.valor = valor;
        this.duracao = duracao;
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
}
