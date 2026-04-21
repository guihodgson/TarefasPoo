package ProjetoPoo.Cartas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Eventos.Artes;

public class CartaEfeitoTest {
    @Test
    void deveInstanciarCartaEfeito() {
        EfeitoVeneno efeito = new EfeitoVeneno(3, TipoEfeito.VENENO);
        CartaEfeito carta = new CartaEfeito("Veneno", "Aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeito);
        
        assertNotNull(carta);
        assertEquals("Veneno", carta.getNome());
        assertEquals(efeito, carta.getEfeito());
    }

    @Test
    void deveCopiarCartaEfeito() {
        EfeitoVeneno efeito = new EfeitoVeneno(3, TipoEfeito.VENENO);
        CartaEfeito original = new CartaEfeito("Veneno", "Aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeito);
        CartaEfeito copia = new CartaEfeito(original);
        
        assertEquals(original.getNome(), copia.getNome());
    }

    @Test
    void deveAplicarEfeitoAoUsarCarta() {
        EfeitoVeneno efeito = new EfeitoVeneno(3, TipoEfeito.VENENO);
        CartaEfeito carta = new CartaEfeito("Veneno", "Aplica veneno", 1, AlvoCarta.UM_ALVO, Artes.VENENO, efeito);
        Heroi heroi = new Heroi("Hero", 50, 0, 10, 10);
        Heroi alvo = new Heroi("Alvo", 50, 0, 10, 10);
        
        int efeitoAntesVal = alvo.getValorEfeito(TipoEfeito.VENENO);
        carta.usar(heroi, alvo);
        
        assertTrue(alvo.getValorEfeito(TipoEfeito.VENENO) >= efeitoAntesVal);
    }
}
