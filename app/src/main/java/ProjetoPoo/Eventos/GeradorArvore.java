package ProjetoPoo.Eventos;

import java.util.ArrayList;
import java.util.Random;

public class GeradorArvore {
    private Random random = new Random();
    private final int MAX_CAMADAS = 4;

    public NoEvento criarArvore() {
        NoEvento raiz = new NoEvento(0, 0, TipoEvento.RAIZ, null, new ArrayList<>());
        NoEvento boss = new NoEvento(TipoEvento.BOSS);

        gerarNoRecursivo(raiz, 1, boss);
        return raiz;
    }

    private void gerarNoRecursivo(NoEvento pai, int camada, NoEvento boss) {
        if (camada > MAX_CAMADAS) {
            pai.getFilhos().add(boss);
            return;
        }

        int numFilhos = random.nextInt(3) + 1; // 1 a 3 filhos

        for (int i = 0; i < numFilhos; i++) {
            if (camada == 1) {
                numFilhos = 3; // Garante 3 opções na primeira camada
            }
            TipoEvento tipoEvento = gerarTipoEventoAleatorio();
            NoEvento filho = new NoEvento(i, camada, tipoEvento, null, new ArrayList<>());
            pai.getFilhos().add(filho);
            gerarNoRecursivo(filho, camada + 1, boss);
        }
    }

    private TipoEvento gerarTipoEventoAleatorio() {
        int pick = random.nextInt(100) + 1; // Ignora RAIZ
        if (pick <= 75) {
            return TipoEvento.BATALHA_COMUM;
        }
        else if (pick <= 85) {
            return TipoEvento.BATALHA_ELITE;
        }
        else {
            return TipoEvento.BATALHA_ELITE; // DEBUGGGGG
        }
    }
}
