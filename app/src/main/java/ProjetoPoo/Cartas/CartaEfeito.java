package ProjetoPoo.Cartas;

import java.util.ArrayList;

import ProjetoPoo.Batalhas.Artes;
import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;

public class CartaEfeito extends Carta {

    // Atributos

    protected Efeito efeito;

    // Getters

    public Efeito getEfeito() {
        return efeito;
    }

    // Constructor

    public CartaEfeito(String nome, String descricao, int custo, AlvoCarta alvo, Artes arte, Efeito efeito) {
        super(nome, descricao, custo, alvo, arte);
        this.efeito = efeito;
    }

    public CartaEfeito(CartaEfeito copia) {
        super(copia);
        this.efeito = copia.efeito.copiaEfeito();
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade... alvos) {
        for (Entidade target : alvos) {
            if (target != null) {
                target.ganharEfeito(efeito.copiaEfeito());
            }
        }
    }

    @Override
    public void usar(Entidade heroi, ArrayList<Inimigo> alvos) {
        for (Entidade target : alvos) {
            if (target != null) {
                target.ganharEfeito(efeito.copiaEfeito());
            }
        }
    }


    @Override

    public Carta copiaCarta() {
        return new CartaEfeito(this);
    }
}
