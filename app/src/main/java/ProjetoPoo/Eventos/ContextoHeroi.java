package ProjetoPoo.Eventos;

import java.util.ArrayList;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

public class ContextoHeroi {
    public Heroi heroi;
    public ArrayList<Inimigo> inimigos;

    public ContextoHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public ContextoHeroi(Heroi heroi, ArrayList<Inimigo> inimigos) {
        this.heroi = heroi;
        this.inimigos = inimigos;
    }
}
