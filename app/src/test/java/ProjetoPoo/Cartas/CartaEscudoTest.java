package ProjetoPoo.Cartas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Eventos.Artes;

public class CartaEscudoTest {
    @Test
    void deveInstanciarCartaEscudo() {
        CartaEscudo carta = new CartaEscudo("Defesa", "Descrição", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
        assertNotNull(carta);
        assertEquals("Defesa", carta.getNome());
        assertEquals(5, carta.getDefesa());
    }

    @Test
    void deveCopiarCartaEscudo() {
        CartaEscudo original = new CartaEscudo("Defesa", "Descrição", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
        CartaEscudo copia = new CartaEscudo(original);
        
        assertEquals(original.getNome(), copia.getNome());
        assertEquals(original.getDefesa(), copia.getDefesa());
    }

    @Test
    void deveAplicarEscudoAoUsarCarta() {
        CartaEscudo carta = new CartaEscudo("Defesa", "Descrição", 1, 5, AlvoCarta.USO_PROPRIO, Artes.ESCUDO);
        Heroi heroi = new Heroi("Hero", 50, 0, 10, 10);
        
        int escudoAntes = heroi.getEscudo();
        carta.usar(heroi);
        
        assertTrue(heroi.getEscudo() > escudoAntes);
    }
}
