package ProjetoPoo.Efeitos;

public class EfeitoEscudo extends Efeito {

    // Constructor

    public EfeitoEscudo(int valor) {
        super(TipoEfeito.ESCUDO, valor, 1);
    }

    public EfeitoEscudo(EfeitoEscudo copia) {
        super(copia);
    }

    // Metodos

    @Override
    public void atualizar(String evento, Object objeto) {
        if (evento.equals("inicioRound")) {
            duracao = 0;
        }
    }

    @Override
    public Efeito copiaEfeito() {
        return new EfeitoEscudo(this);
    }

}
