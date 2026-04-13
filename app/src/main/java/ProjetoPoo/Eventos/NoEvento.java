package ProjetoPoo.Eventos;

import java.util.ArrayList;

public class NoEvento {
    private String nomeTipo;
    private int id;
    private int camada;
    private TipoEvento tipo;
    private Evento evento;
    private ArrayList<NoEvento> filhos;

    public NoEvento(int id, int camada, TipoEvento tipo, Evento evento, ArrayList<NoEvento> filhos) {
        if (tipo == TipoEvento.BATALHA_COMUM) {
            nomeTipo = "Batalha Comum";
        }
        else if (tipo == TipoEvento.BATALHA_ELITE) {
            nomeTipo = "Batalha Elite";
        }
        else if (tipo == TipoEvento.ALEATORIO) {
            nomeTipo = "Evento Aleatório";
        }
        else if (tipo == TipoEvento.BOSS) {
            nomeTipo = "Boss";
        }
        else {
            nomeTipo = "Raiz";
        }
        this.id = id;
        this.camada = camada;
        this.tipo = tipo;
        this.evento = evento;
        this.filhos = filhos;
    }

    public NoEvento(TipoEvento tipo) {
        this.tipo = tipo;
        if (tipo == TipoEvento.BATALHA_COMUM) {
            nomeTipo = "Batalha Comum";
        }
        else if (tipo == TipoEvento.BATALHA_ELITE) {
            nomeTipo = "Batalha Elite";
        }
        else if (tipo == TipoEvento.ALEATORIO) {
            nomeTipo = "Evento Aleatório";
        }
        else if (tipo == TipoEvento.BOSS) {
            nomeTipo = "Boss";
        }
        else {
            nomeTipo = "Raiz";
        }
    }

    public String getNomeTipo() {
        return nomeTipo;
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

    public ArrayList<String> getOpcoesFilhos() {
        ArrayList<String> opcoes = new ArrayList<>();
        for (NoEvento filho : filhos) {
            opcoes.add(filho.getNomeTipo());
        }
        return opcoes;
    }
}
