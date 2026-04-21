package ProjetoPoo.Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EntidadeTest {

    @Test
    void danoAbsorvidoPeloEscudo() {
        Entidade e = new Entidade("Teste", 10, 5);

        e.receberDano(3);

        assertEquals(10, e.getVida());
        assertEquals(2, e.getEscudo());
    }

    @Test
    void danoUltrapassaEscudo() {
        Entidade e = new Entidade("Teste", 10, 3);

        e.receberDano(5);

        assertEquals(8, e.getVida());
        assertEquals(0, e.getEscudo());
    }

    @Test
    void curaNaoPassaDaVidaMaxima() {
        Entidade e = new Entidade("Teste", 10, 0);
        e.receberDano(4);

        int vidaFinal = e.curarVida(10);

        assertEquals(10, vidaFinal);
        assertEquals(10, e.getVida());
    }

    @Test
    void perderEscudoNaoDeixaNegativo() {
        Entidade e = new Entidade("Teste", 10, 2);

        int escudoFinal = e.perderEscudo(10);

        assertEquals(0, escudoFinal);
        assertEquals(0, e.getEscudo());
    }

    @Test
    void estaVivoRefleteVidaAtual() {
        Entidade e = new Entidade("Teste", 5, 0);

        assertTrue(e.estaVivo());
        e.receberDano(5);
        assertFalse(e.estaVivo());
    }
}
