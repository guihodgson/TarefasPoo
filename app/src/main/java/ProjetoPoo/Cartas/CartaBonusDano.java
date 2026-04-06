package ProjetoPoo.Cartas;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.TipoEfeito;

public class CartaBonusDano extends CartaEfeito {

    // Atributos

    protected int bonus;
    protected int tempo;

    // Getters

    public int getBonus() {
        return bonus;
    }

    // Constructor

    public CartaBonusDano(String nome, String descricao, int custo, int bonus, int tempo) {
        super(nome, descricao, custo);
        this.bonus = bonus;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        heroi.ganharEfeito(new EfeitoBonusDano(bonus, tempo, TipoEfeito.BONUS_DANO), bonus, tempo);
    }
}
