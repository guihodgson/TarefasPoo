package ProjetoPoo.Save;

import java.util.List;

import ProjetoPoo.Cartas.Baralho;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Efeitos.Efeito;
import ProjetoPoo.Entidades.Heroi;

public class GerenciadorSave {

    public static SaveHeroi heroiParaSave (Heroi heroi) {
        SaveHeroi saveHeroi = new SaveHeroi(heroi);

        salvarCartasPorID(heroi.getBaralho(), saveHeroi.cardasNoBaralho);
        salvarCartasPorID(heroi.getDeck(), saveHeroi.cardasNoDeck);
        salvarCartasPorID(heroi.getDescarte(), saveHeroi.cardasNoDescarte);


        for (Efeito efeito : heroi.getGerenciadorEfeitos().getEfeitos()) {
            if (efeito.getDuracao() > 0) {
                saveHeroi.efeitos.add(new SaveEfeito(efeito));
            }
        }

        return saveHeroi;
    }

    public static void salvarCartasPorID(Baralho baralho, List<String> listaID) {
        for (int i = 0; i < baralho.tamanho(); i++) {
            Carta carta = baralho.mostrarCartaN(i);
            listaID.add(carta.getNome());
        }
    }

    public static Heroi saveParaHeroi(SaveHeroi saveHeroi) {
        Heroi heroi = new Heroi(saveHeroi.nome, saveHeroi.vidaMaxima, saveHeroi.escudo, saveHeroi.energiaMaxima, 0);
        heroi.setVida(saveHeroi.vidaAtual);
        heroi.setEnergia(saveHeroi.energiaAtual);
        heroi.aumentarMoedas(saveHeroi.moedas);

        // Adiciona cartas por fabrica cartas

        // Adiciona efeitos

        return heroi;
    }
}
