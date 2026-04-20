package ProjetoPoo.Efeitos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ProjetoPoo.Entidades.Heroi;

public class EfeitoVenenoTest {
    @Test
    void deveInstanciarEfeitoVeneno() {
        EfeitoVeneno efeito = new EfeitoVeneno(3, TipoEfeito.VENENO);
        
        assertNotNull(efeito);
        assertEquals(0, efeito.getValor());
        assertEquals(3, efeito.getDuracao());
        assertEquals(TipoEfeito.VENENO, efeito.getTipo());
    }

    @Test
    void deveCopiarEfeitoVeneno() {
        EfeitoVeneno original = new EfeitoVeneno(3, TipoEfeito.VENENO);
        EfeitoVeneno copia = new EfeitoVeneno(original);
        
        assertEquals(original.getValor(), copia.getValor());
        assertEquals(original.getDuracao(), copia.getDuracao());
        assertEquals(original.getTipo(), copia.getTipo());
    }

    @Test
    void deveAtualizarDuracao() {
        EfeitoVeneno efeito = new EfeitoVeneno(3, TipoEfeito.VENENO);
        Heroi alvo = new Heroi("Heroi", 50, 0, 10, 10);
        int duracao1 = efeito.getDuracao();
        efeito.atualizar("fimRound", alvo);
        int duracao2 = efeito.getDuracao();
        
        assertTrue(duracao2 < duracao1);
    }
}
