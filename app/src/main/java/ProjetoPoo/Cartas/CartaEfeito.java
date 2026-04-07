package ProjetoPoo.Cartas;

import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Entidades.Entidade;

public class CartaEfeito extends Carta {

    // Atributos

    protected Efeito efeito;

    // Getters

    public Efeito getEfeito() {
        return efeito;
    }

    // Constructor

    public CartaEfeito(String nome, String descricao, int custo, AlvoCarta tipo, Efeito efeito) {
        super(nome, descricao, custo, tipo);
        this.efeito = efeito;
    }

    public CartaEfeito(CartaEfeito copia) {
        super(copia);
        this.efeito = copia.efeito.copiaEfeito();
    }

    // Metodos

    @Override
    public void usar(Entidade heroi, Entidade... alvos) {
        if (tipo == AlvoCarta.USO_PROPRIO) {
            heroi.ganharEfeito(efeito.copiaEfeito());
            return;
        }

        else {
            for (Entidade alvo : alvos) {
                if (alvo != null) {
                    alvo.ganharEfeito(efeito.copiaEfeito());
                }
            }
        }
    }

    @Override

    public Carta copiaCarta() {
        return new CartaEfeito(this);
    }
}
