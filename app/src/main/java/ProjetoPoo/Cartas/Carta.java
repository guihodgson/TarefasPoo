package ProjetoPoo.Cartas;

import ProjetoPoo.Entidades.Entidade;

public abstract class Carta {

    // Atributos

    protected String nome;
    protected String descricao;
    protected int custo;
    protected AlvoCarta tipo;

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

    public AlvoCarta getTipo() {
        return tipo;
    }

    // Constructor

    public Carta(String nome, String descricao, int custo, AlvoCarta tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.tipo = tipo;
    }

    public Carta(Carta copia) {
        this.nome = copia.nome;
        this.descricao = copia.descricao;
        this.custo = copia.custo;
        this.tipo = copia.tipo;
    }

    // Metodos

    public abstract void usar(Entidade atacante, Entidade... alvos);

    public abstract Carta copiaCarta();

}
