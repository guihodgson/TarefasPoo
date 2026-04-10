    package ProjetoPoo.Eventos;

import java.util.ArrayList;

public class NoEvento {
    private int id;
    private int camada;
    private TipoEvento tipo;
    private Evento evento;
    private ArrayList<NoEvento> filhos;

    public NoEvento(int id, int camada, TipoEvento tipo, Evento evento, ArrayList<NoEvento> filhos) {
        this.id = id;
        this.camada = camada;
        this.tipo = tipo;
        this.evento = evento;
        this.filhos = filhos;
    }

    public int getId() {
        return id;
    }

    public int getCamada() {
        return camada;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public ArrayList<NoEvento> getFilhos() {
        return filhos;
    }
}
