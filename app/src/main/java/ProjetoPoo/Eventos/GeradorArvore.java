package ProjetoPoo.Eventos;

import java.util.ArrayList;
import java.util.Random;

public class GeradorArvore {
    private Random random = new Random();
    private final int MAX_CAMADAS = 4;

    public NoEvento criarArvore() {
        NoEvento raiz = new NoEvento(0, 0, TipoEvento.RAIZ, null, new ArrayList<>());


        gerarNoRecursivo(raiz, 1);
        return raiz;
    }

    private void gerarNoRecursivo(NoEvento pai, int camada) {
        //
    }
}
