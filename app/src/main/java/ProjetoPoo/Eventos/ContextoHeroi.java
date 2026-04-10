package ProjetoPoo.Eventos;

import java.util.ArrayList;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

public class ContextoHeroi {
    public Heroi heroi;
    public ArrayList<Inimigo> inimigos;
    private int area;

    public ContextoHeroi(Heroi heroi) {
        this.heroi = heroi;
        area = 0;
    }

    public ContextoHeroi(Heroi heroi, ArrayList<Inimigo> inimigos) {
        this.heroi = heroi;
        this.inimigos = inimigos;
        area = 0;
    }

    public int getArea() {
        return area;
    }
}
