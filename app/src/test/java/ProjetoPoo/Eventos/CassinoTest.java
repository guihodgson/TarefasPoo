package ProjetoPoo.Eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.InputHandler;

class CassinoTest {

    @Test
    void sairMantemMoedas() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.setMoedas(10);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Cassino cassino = new Cassino();
        InputHandlerAutomático input = new InputHandlerAutomático(3);

        boolean resultado = cassino.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(10, heroi.getMoedas());
    }

    @Test
    void opcaoInvalidaNoCassino() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.setMoedas(7);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Cassino cassino = new Cassino();
        InputHandlerAutomático input = new InputHandlerAutomático(-1, 3);

        boolean resultado = cassino.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(7, heroi.getMoedas());
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
        public int getInt(String mensagem, double tempo) {
            return -1;
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
