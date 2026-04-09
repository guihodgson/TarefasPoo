package ProjetoPoo.Cartas;

import ProjetoPoo.Artes;
import ProjetoPoo.Entidades.Entidade;

public abstract class Carta {

    // Atributos

    protected String nome;
    protected String descricao;
    protected int custo;
    protected AlvoCarta alvo;
    protected Artes arte;

    // Getters

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCusto() {
        return custo;
    }

    public AlvoCarta getAlvo() {
        return alvo;
    }

    public Artes getArte() {
        return arte;
    }

    // Constructor

    public Carta(String nome, String descricao, int custo, AlvoCarta alvo, Artes arte) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.alvo = alvo;
        this.arte = arte;
    }

    public Carta(Carta copia) {
        this.nome = copia.nome;
        this.descricao = copia.descricao;
        this.custo = copia.custo;
        this.alvo = copia.alvo;
        this.arte = copia.arte;
    }

    // Metodos

    public abstract void usar(Entidade atacante, Entidade... alvos);

    public abstract Carta copiaCarta();

    public void imprimirArte() {
        System.out.println(arte.getArte());
    }

}
