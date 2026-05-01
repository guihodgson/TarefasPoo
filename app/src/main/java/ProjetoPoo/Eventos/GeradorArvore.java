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
                numFilhos = 4; // Garante 3 opções na primeira camada
            }
            if (camada == 4 && i == 0) {
                NoEvento filho = new NoEvento(i, camada, TipoEvento.FOGUEIRA, null, new ArrayList<>());
                pai.getFilhos().add(filho);
                gerarNoRecursivo(filho, camada + 1, boss);
                continue;
            }
            TipoEvento tipoEvento = gerarTipoEventoAleatorio();
            NoEvento filho = new NoEvento(i, camada, tipoEvento, null, new ArrayList<>());
            pai.getFilhos().add(filho);
            gerarNoRecursivo(filho, camada + 1, boss);
        }
    }

    private TipoEvento gerarTipoEventoAleatorio() {
        int pick = random.nextInt(100) + 1;
        if (pick <= 70) {
            return TipoEvento.BATALHA_COMUM;
        }
        else if (pick <= 93) {
            return TipoEvento.BATALHA_ELITE;
        }
        else if (pick <= 96) {
            return TipoEvento.ALEATORIO;
        }
        else if (pick <= 98) {
            return TipoEvento.ESCOLHA;
        }
        else {
            return TipoEvento.FOGUEIRA;
        }
    }
}
