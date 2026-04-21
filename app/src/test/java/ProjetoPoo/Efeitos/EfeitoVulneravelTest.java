package ProjetoPoo.Efeitos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class EfeitoVulneravelTest {
    @Test
    void deveInstanciarEfeitoVulneravel() {
        EfeitoVulneravel efeito = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        
        assertNotNull(efeito);
        assertEquals(25, efeito.getValor());
        assertEquals(2, efeito.getDuracao());
        assertEquals(TipoEfeito.VULNERAVEL, efeito.getTipo());
    }

    @Test
    void deveCopiarEfeitoVulneravel() {
        EfeitoVulneravel original = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        EfeitoVulneravel copia = new EfeitoVulneravel(original);
        
        assertEquals(original.getValor(), copia.getValor());
        assertEquals(original.getDuracao(), copia.getDuracao());
    }

    @Test
    void deveAtualizarDuracao() {
        EfeitoVulneravel efeito = new EfeitoVulneravel(25, 2, TipoEfeito.VULNERAVEL);
        efeito.atualizar("fimRound", null);
        assertEquals(1, efeito.getDuracao());
    }
}
