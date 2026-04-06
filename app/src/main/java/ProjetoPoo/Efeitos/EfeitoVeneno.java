package ProjetoPoo.Efeitos;

import ProjetoPoo.Entidades.Entidade;

public class EfeitoVeneno extends Efeito{

    // Atributos

    protected int dano;
    protected int duracao;

    // Getters

    public int getDano() {
        return dano;
    }

    @Override
    public int getDuracao() {
        return duracao;
    }

    // Constructor

    public EfeitoVeneno(int dano, int duracao, TipoEfeito tipo) {
        this.dano = dano;
        this.duracao = duracao;
        this.tipo = tipo;
    }

    // Metodo

    @Override
    public void atualizar(String evento, Object objeto) {
        if(objeto instanceof Entidade alvo) {
            if (evento.equals("fimRound")) {
                if (duracao > 0) {
                    alvo.receberDano(dano);
                    System.out.println(alvo.getNome() + " tomou " + dano + " de dano de Veneno.");
                    duracao--;
                }
            }
        }
    }

    public void adicionarDuracao(int valor) {
        duracao += valor;
    }
}
