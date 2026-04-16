package ProjetoPoo.Cartas;

import java.util.ArrayList;

import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.Eventos.Artes;

public class CartaDanoComEfeito extends CartaDano {

    // Atributos

    protected Efeito efeito;

    // Getters

    public Efeito getEfeito() {
        return efeito;
    }

    // Constructor

    public CartaDanoComEfeito(String nome, String descricao, int custo, int ataque, Efeito efeito, AlvoCarta alvo, Artes arte) {
        super(nome, descricao, custo, ataque, alvo, arte);
        this.efeito = efeito;
    }

    public CartaDanoComEfeito(CartaDanoComEfeito copia) {
        super(copia);
        this.efeito = copia.efeito;
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade alvo) {
        ArrayList<Inimigo> alvos = new ArrayList<>();
        alvos.add((Inimigo) alvo);
        usar(heroi, alvos);
    }

    @Override
    public void usar(Entidade heroi, ArrayList<Inimigo> alvos) {
        for (Entidade target : alvos) {
            int danoFinal = heroi.calcularDanoFinalAtaque(ataque, target);
            target.receberDano(danoFinal);

            if (alvo == AlvoCarta.USO_PROPRIO) {
                heroi.ganharEfeito(efeito.copiaEfeito());
            } 

            else {
                target.ganharEfeito(efeito.copiaEfeito());
            }
        }
    }

    @Override
    public Carta copiaCarta() {
        return new CartaDanoComEfeito(this);
    }


}
