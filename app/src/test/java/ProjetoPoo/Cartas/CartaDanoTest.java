package ProjetoPoo.Cartas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Eventos.Artes;

public class CartaDanoTest {
    @Test
    void deveInstanciarCartaDano() {
        CartaDano carta = new CartaDano("Ataque", "Descrição", 1, 10, AlvoCarta.UM_ALVO, Artes.BANG1);
        assertNotNull(carta);
        assertEquals("Ataque", carta.getNome());
        assertEquals(10, carta.getAtaque());
        assertEquals(1, carta.getCusto());
    }

    @Test
    void deveCopiarCartaDano() {
        CartaDano original = new CartaDano("Ataque", "Descrição", 1, 10, AlvoCarta.UM_ALVO, Artes.BANG1);
        CartaDano copia = new CartaDano(original);
        
        assertEquals(original.getNome(), copia.getNome());
        assertEquals(original.getAtaque(), copia.getAtaque());
    }

    @Test
    void deveAplicarDanoAoUsarCarta() {
        CartaDano carta = new CartaDano("Ataque", "Descrição", 1, 10, AlvoCarta.UM_ALVO, Artes.BANG1);
        Heroi heroi = new Heroi("Hero", 50, 0, 10, 10);
        Heroi alvo = new Heroi("Alvo", 50, 0, 10, 10);
        
        int vidaAntes = alvo.getVida();
        carta.usar(heroi, alvo);
        
        assertTrue(alvo.getVida() < vidaAntes);
    }
}
