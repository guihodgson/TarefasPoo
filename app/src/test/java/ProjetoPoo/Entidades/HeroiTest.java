package ProjetoPoo.Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Eventos.Artes;

class HeroiTest {

    @Test
    void moedasRespeitamAsRegras() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);

        heroi.aumentarMoedas(10);
        assertEquals(10, heroi.getMoedas());
        assertEquals(true, heroi.podeGastarMoedas(8));

        heroi.gastarMoedas(8);
        assertEquals(2, heroi.getMoedas());

        heroi.perderMoedas(10);
        assertEquals(0, heroi.getMoedas());
    }

    @Test
    void usarCartaDoDeck() {
        Heroi heroi = new Heroi("Po", 20, 0, 3, 1);
        Entidade alvo = new Entidade("Bernardo", 20, 0);
        CartaDano ataque = new CartaDano("Ataque", "Resenha", 1, 5, AlvoCarta.UM_ALVO, Artes.BANG1);

        heroi.adicionarCartaBaralho(ataque);
        heroi.deckInicial();

        heroi.usarCartaNDeck(0, alvo);
        assertEquals(15, alvo.getVida());
        assertEquals(0, heroi.tamDeck());

        heroi.resetarBaralho();
        assertEquals(1, heroi.tamDeck());

        heroi.gastarEnergia(2);
        heroi.ganharEscudo(67);
        heroi.resetarRound();

        assertEquals(3, heroi.getEnergia());
        assertEquals(0, heroi.getEscudo());
    }
}
