package ProjetoPoo.Entidades;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        
        ctx.setArea(0);
        Inimigo boss1 = gerenciadorInimigo.criarBoss(ctx);
        assertEquals("Tai Lung", boss1.getNome());

        Inimigo inimigoComum1 = gerenciadorInimigo.criarInimigoComum(ctx, true, 0);
        assertEquals("Javali Salteador", inimigoComum1.getNome());
        
        Inimigo inimigoComum2 = gerenciadorInimigo.criarInimigoComum(ctx, true, 1);
        assertEquals("Lince", inimigoComum2.getNome());
        
        Inimigo inimigoComum3 = gerenciadorInimigo.criarInimigoComum(ctx, true, 2);
        assertEquals("Abutre", inimigoComum3.getNome());

        ctx.setArea(1);
        Inimigo boss2 = gerenciadorInimigo.criarBoss(ctx);
        assertEquals("Lord Shen", boss2.getNome());

        Inimigo inimigoComum4 = gerenciadorInimigo.criarInimigoComum(ctx, true, 0);
        assertEquals("Lobo Simples", inimigoComum4.getNome());
        
        Inimigo inimigoComum5 = gerenciadorInimigo.criarInimigoComum(ctx, true, 1);
        assertEquals("Gorila Bruto", inimigoComum5.getNome());
        
        Inimigo inimigoComum6 = gerenciadorInimigo.criarInimigoComum(ctx, true, 2);
        assertEquals("Cobra Venenosa", inimigoComum6.getNome());

        ctx.setArea(2);
        Inimigo boss3 = gerenciadorInimigo.criarBoss(ctx);
        assertEquals("Kai", boss3.getNome());

        Inimigo inimigoComum7 = gerenciadorInimigo.criarInimigoComum(ctx, true, 0);
        assertEquals("Lobo de Jade", inimigoComum7.getNome());
        
        Inimigo inimigoComum8 = gerenciadorInimigo.criarInimigoComum(ctx, true, 1);
        assertEquals("Gorila de Jade", inimigoComum8.getNome());
        
        Inimigo inimigoComum9 = gerenciadorInimigo.criarInimigoComum(ctx, true, 2);
        assertEquals("Porco de Jade", inimigoComum9.getNome());
    }
}
