package ProjetoPoo.Cartas;

import java.util.ArrayList;

import ProjetoPoo.InputHandler;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Eventos.ContextoHeroi;

public class SeletorCarta {

    public static void selecionarCarta(ContextoHeroi ctx, InputHandler inputHandler) {
        Heroi heroi = ctx.heroi;
        ArrayList<String> baralhoString = heroi.mostrarBaralho();

        int cartaSelecionada = inputHandler.selecionarCarta(baralhoString, 5, 1);
    }
}
