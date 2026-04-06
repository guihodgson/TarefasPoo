package ProjetoPoo.Cartas;

import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Efeitos.EfeitoVeneno;

public class CartaVeneno extends CartaEfeito {

    // Atributos

    protected int veneno;
    protected int tempo;

    // Getters

    public int getVeneno() {
        return veneno;
    }

    // Constructor

    public CartaVeneno(String nome, String descricao, int custo, int veneno, int tempo) {
        super(nome, descricao, custo);
        this.veneno = veneno;
        this.tempo = tempo;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        alvo.ganharEfeito(new EfeitoVeneno(veneno, tempo, TipoEfeito.VENENO), veneno, tempo);
    }
}
