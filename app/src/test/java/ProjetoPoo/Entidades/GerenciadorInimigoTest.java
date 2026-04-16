package ProjetoPoo.Entidades;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ProjetoPoo.Eventos.ContextoHeroi;

public class GerenciadorInimigoTest {

    @Test
    void criarInimigos() {
        GerenciadorInimigo gerenciadorInimigo = new GerenciadorInimigo();
        Heroi heroi = new Heroi("Ronaldo", 10, 0, 10, 0);
        Inimigo inimigo = new Inimigo("Mcdonaldo", 10, 10, 10, TipoInimigo.COMUM);
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(inimigo);
        ContextoHeroi ctx = new ContextoHeroi(heroi, inimigos);
        ctx.setArea(2);
        Inimigo boss = gerenciadorInimigo.criarBoss(ctx);

        Inimigo inimigoComum = gerenciadorInimigo.criarInimigoComum(ctx);

    }
}
