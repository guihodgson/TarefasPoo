package ProjetoPoo.Efeitos;

public interface Efeito {
    public int getDuracao();
    public abstract void atualizar(String evento, Object objeto);
}
