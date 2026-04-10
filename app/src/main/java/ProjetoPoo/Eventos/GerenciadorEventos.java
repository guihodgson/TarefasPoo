package ProjetoPoo.Eventos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.Entidades.TipoInimigo;

public class GerenciadorEventos {

    Random random = new Random();
    
    public Evento criarEvento(TipoEvento tipo, ContextoHeroi ctx) {
        switch (tipo) {
            case BATALHA -> {
                
            }
        }
    }

    public Evento criarBatalha(ContextoHeroi ctx, TipoInimigo tipoInimigo, int qtdMaxInim) {
        ArrayList<NoEvento> filhos = new ArrayList<>();
        Evento batalha = new Batalha();

        int qtdInim = random.nextInt(qtdMaxInim) + 1;

        for (int i = 0; i < qtdInim; i++) {

        }
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
