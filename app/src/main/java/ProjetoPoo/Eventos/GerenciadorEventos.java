package ProjetoPoo.Eventos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.InputHandler;
import ProjetoPoo.Entidades.GerenciadorInimigo;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.Entidades.TipoInimigo;

public class GerenciadorEventos {

    Random random = new Random();
    InputHandler inputHandler = new InputHandler();
    
    public Evento criarEvento(TipoEvento tipo, ContextoHeroi ctx) {
        switch (tipo) {
            case BATALHA_COMUM -> {
                return criarBatalha(ctx, TipoEvento.BATALHA_COMUM, 3);
            }
            case BATALHA_ELITE -> {
                return criarBatalha(ctx, TipoEvento.BATALHA_ELITE, 2);
            }
            case BOSS -> {
                return criarBatalha(ctx, TipoEvento.BOSS, 1);
            }
            case ALEATORIO -> {
                return criarCasino(ctx, TipoEvento.ALEATORIO);
            }
            default -> {
                return null;
            }

        }
    }

    public Evento criarBatalha(ContextoHeroi ctx, TipoEvento tipoEvento, int qtdMaxInim) {
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        GerenciadorInimigo gerenciadorInimigo = new GerenciadorInimigo();
        Evento batalha = new Batalha();

        int qtdInim = random.nextInt(qtdMaxInim) + 1;

        for (int i = 0; i < qtdInim; i++) {
            inimigos.add(gerenciadorInimigo.criarInimigoAleatorio(tipoEvento, ctx));
        }
        ctx.inimigos = inimigos;
        ctx.setTipoEvento(tipoEvento);

        return batalha;
    }

    public Evento criarCasino(ContextoHeroi ctx, TipoEvento tipoEvento) {
        ctx.setTipoEvento(tipoEvento);
        return new Casino();
    }
}

/*
Vou usar aqui como um jeito de me organizar:
Primeiro vou terminar aqui o gerenciador de eventos, dai no geradr de arvore, eu gero eventos e vou colocando na arvore ou so gero na hora de entrar nao decidi ainda
Depois tenho que fazer esse sistema de fazer toda a arvore e gerar batalhas com os niveis certos de inimigo

Resumindo, acho que o gerador arvore vai me fazer uma estrutura, dai dependendo de qual opcao o jogador escolher, ele gera no gerador ed eventos o certo e coloca o jogador la
dai tenho so que fazer um jeito de navegar bem pela arvore e fechou.

posso fazer funcao montar inimigos pra batalha e depois ja adicionar na batalha qnd for batalha
eu ja to gerando no gerenciador de inimigo, dai é so um forloop

tenho que ver tambem como que arrumo o contexto heroi, pq os inimigos mudam toda vez que entramos em uma nova batalha
*/
