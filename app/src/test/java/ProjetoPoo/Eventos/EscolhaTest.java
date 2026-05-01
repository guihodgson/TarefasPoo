package ProjetoPoo.Eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.InputHandler;

class EscolhaTest {

    @Test
    void ganharMoedasAumentaSaldo() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.setMoedas(10);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Escolha escolha = new Escolha();
        InputHandlerAutomatico input = new InputHandlerAutomatico(0);

        boolean resultado = escolha.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(60, heroi.getMoedas());
    }

    @Test
    void ganharCartaAdicionaSkidooshNoBaralho() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());

        Escolha escolha = new Escolha();
        InputHandlerAutomatico input = new InputHandlerAutomatico(2);

        boolean resultado = escolha.iniciar(input, ctx);

        assertTrue(resultado);
        ArrayList<String> baralho = heroi.mostrarBaralho();
        assertEquals(1, baralho.size());
        String carta = baralho.get(0);
        assertTrue(
            carta.contains("Skidoosh")
                || carta.contains("Golpe do Mestre")
                || carta.contains("Guarda do Mestre")
                || carta.contains("Chi Intenso")
                || carta.contains("Macarrão Ultra Envenenado")
                || carta.contains("Ponto Fraco Revelado")
                || carta.contains("Intimidação do Dragão"));
    }

        @Test
        void curaGastaMoedasECuraVida() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.receberDano(15);
        heroi.setMoedas(100);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Escolha escolha = new Escolha();
        InputHandlerAutomatico input = new InputHandlerAutomatico(
            1, // Curar Vida
            0 // 10 de vida por 50 moedas
        );

        boolean resultado = escolha.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(15, heroi.getVida());
        assertEquals(50, heroi.getMoedas());
        }

    @Test
    void sairNaoAlteraHeroi() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        heroi.setMoedas(7);

        ContextoHeroi ctx = new ContextoHeroi(heroi, new ArrayList<>());
        Escolha escolha = new Escolha();
        InputHandlerAutomatico input = new InputHandlerAutomatico(3);

        boolean resultado = escolha.iniciar(input, ctx);

        assertTrue(resultado);
        assertEquals(7, heroi.getMoedas());
        assertTrue(heroi.mostrarBaralho().isEmpty());
    }

    private static class InputHandlerAutomatico extends InputHandler {
        private final Queue<Integer> selecoes = new ArrayDeque<>();

        InputHandlerAutomatico(int... respostas) {
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
