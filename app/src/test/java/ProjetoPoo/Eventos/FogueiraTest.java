package ProjetoPoo.Eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.InputHandler;

class FogueiraTest {

    @Test
    void curarVidaRecuperaUmQuarto() {
        Heroi heroi = new Heroi("Hodgson", 20, 0, 3, 1);
        heroi.receberDano(8);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Fogueira fogueira = new Fogueira();
        InputHandlerAutomático input = new InputHandlerAutomático(0);

        boolean resultado = fogueira.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(17, heroi.getVida());
    }

    @Test
    void sairDaFogueira() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.receberDano(5);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Fogueira fogueira = new Fogueira();
        InputHandlerAutomático input = new InputHandlerAutomático(2);

        boolean resultado = fogueira.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(15, heroi.getVida());
    }

    private static class InputHandlerAutomático extends InputHandler {
        private final Queue<Integer> selecoes = new ArrayDeque<>();

        InputHandlerAutomático(int... respostas) {
            for (int resposta : respostas) {
                selecoes.add(resposta);
            }
        }

        @Override
        public int selecionar(ArrayList<String> listaOpcoes, double tempo, boolean opcaoVoltar, String textoVoltar) {
            return selecoes.remove();
        }

        @Override
        public void pressEnter(boolean temTexto, String texto) {
        }

        @Override
        public void clear() {
        }

        @Override
        public void clearLines(int n) {
        }
    }
}
