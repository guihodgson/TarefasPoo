package ProjetoPoo.Entidades;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Eventos.ContextoHeroi;

public class InimigoTest {
    @Test
    void ataqueInimigo() {
        GerenciadorInimigo gerenciador = new GerenciadorInimigo();
        Heroi heroi = new Heroi("Ronaldo", 10, 0, 10, 0);
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        ContextoHeroi ctx = new ContextoHeroi(heroi, inimigos);
        Inimigo inimigo = gerenciador.criarBoss(ctx);
        inimigos.add(inimigo); 

        for (int i = 0; i < 20; i++) {
            String msg = inimigo.stringProxAcao();
            assertNotNull(msg);
            Carta cartaUsada = inimigo.getBaralho().mostrarPrimeiraCarta();
            inimigo.usarCartas(heroi);
            assertNotEquals(cartaUsada, inimigo.getBaralho().mostrarPrimeiraCarta());
        }
    }
}
