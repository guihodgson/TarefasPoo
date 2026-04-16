package ProjetoPoo.Save;

import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Efeitos.TipoEfeito;

public class SaveEfeito {
    public TipoEfeito tipo;
    public int valor;
    public int duracao;

    public SaveEfeito() {}

    public SaveEfeito(Efeito efeito) {
        this.tipo = efeito.getTipo();
        this.valor = efeito.getValor();
        this.duracao = efeito.getDuracao();
    }
}
