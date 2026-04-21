package ProjetoPoo.Efeitos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class EfeitoEnfraquecidoTest {
    @Test
    void deveInstanciarEfeitoEnfraquecido() {
        EfeitoEnfraquecido efeito = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);
        
        assertNotNull(efeito);
        assertEquals(25, efeito.getValor());
        assertEquals(2, efeito.getDuracao());
        assertEquals(TipoEfeito.ENFRAQUECIDO, efeito.getTipo());
    }

    @Test
    void deveCopiarEfeitoEnfraquecido() {
        EfeitoEnfraquecido original = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);
        EfeitoEnfraquecido copia = new EfeitoEnfraquecido(original);
        
        assertEquals(original.getValor(), copia.getValor());
        assertEquals(original.getDuracao(), copia.getDuracao());
    }

    @Test
    void deveAtualizarDuracao() {
        EfeitoEnfraquecido efeito = new EfeitoEnfraquecido(25, 2, TipoEfeito.ENFRAQUECIDO);
        efeito.atualizar("fimRound", null);
        assertEquals(1, efeito.getDuracao());
    }
}
