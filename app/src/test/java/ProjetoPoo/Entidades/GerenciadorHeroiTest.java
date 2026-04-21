package ProjetoPoo.Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GerenciadorHeroiTest {

    @Test
    void criaHeroiOpcao0() {
        Heroi heroi = GerenciadorHeroi.criarHeroi(34, 5, 0);

        assertEquals(34, heroi.getVida());
        assertEquals(5, heroi.getEnergiaMax());
        assertEquals(5, heroi.getNCartasDeck());
        assertEquals(5, heroi.tamDeck());
    }

    @Test
    void criaHeroiOpcao1() {
        Heroi heroi = GerenciadorHeroi.criarHeroi(50, 8, 1);

        assertEquals(50, heroi.getVida());
        assertEquals(8, heroi.getEnergiaMax());
        assertEquals(6, heroi.getNCartasDeck());
        assertEquals(6, heroi.tamDeck());
    }
}
