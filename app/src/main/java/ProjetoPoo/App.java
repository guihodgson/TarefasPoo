package ProjetoPoo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.Entidades.GerenciadorHeroi;
import ProjetoPoo.Entidades.GerenciadorInimigo;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.Eventos.Batalha;
import ProjetoPoo.Eventos.ContextoHeroi;
import ProjetoPoo.Eventos.Evento;
import ProjetoPoo.Eventos.GeradorArvore;
import ProjetoPoo.Eventos.GerenciadorEventos;
import ProjetoPoo.Eventos.NoEvento;
import ProjetoPoo.Eventos.TipoEvento;

/**
 * Classe de entrada da aplicação.
 *
 * <p>Responsável por inicializar a interface de texto, permitir a escolha do
 * filme e coordenar a batalha principal ou o desafio final.</p>
 */
public class App {

    private static Random random = new Random();

    /**
     * Inicializa o jogo, solicita a escolha do cenário e executa a batalha
     * correspondente.
     *
     * @param args argumentos de linha de comando, não utilizados
     * @throws Exception caso ocorra erro durante a execução da interface de
     *         texto ou da batalha
     */
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = new InputHandler();
        Heroi heroi = GerenciadorHeroi.criarHeroi(34, 5, 0);
        ContextoHeroi ctx = new ContextoHeroi(heroi);
        GeradorArvore geradorArvore = new GeradorArvore();
        GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();

        inputHandler.clear();
        inputHandler.pressEnter(true, "Pressione Enter para Iniciar!!!");
        GerenciadorTitulo.criarTitulo();
        inputHandler.pressEnter(true, "Pressione Enter para continuar.");
        inputHandler.clear();

        NoEvento raiz = geradorArvore.criarArvore();

        for (int i = 0; i < 3; i++) {
            ctx.setArea(i);
            raiz = geradorArvore.criarArvore();
            while(raiz.getFilhos() != null && raiz.getFilhos().size() > 0) {
                ArrayList<String> opcoesEventos = raiz.getOpcoesFilhos();

                InputHandler.imprimirBonito(Cor.formataCor(Cor.AMARELO,"ESCOLHA SUA PROXIMA BATALHA\n"), 0.5);
                int opcaoEvento = inputHandler.selecionar(opcoesEventos, 0.2);
                inputHandler.clear();

                if (opcaoEvento < 0 || opcaoEvento >= opcoesEventos.size()) {
                    System.out.println("Opcao invalida, tente novamente.");
                    continue;
                }

                TipoEvento tipoEventoEscolhido = raiz.getFilhos().get(opcaoEvento).getTipo();
                // Evento eventoAtual = gerenciadorEventos.criarEvento(tipoEventoEscolhido, ctx);
                Evento eventoAtual = gerenciadorEventos.criarEvento(TipoEvento.ALEATORIO, ctx);

                if (!eventoAtual.iniciar(inputHandler, ctx)) {
                    System.out.println("Você MORREU, o mundo continua em trevas.");  
                    InputHandler.sleep(0.4);
                    GerenciadorFinal.criarPoTriste();
                    System.exit(0);
                }
                heroi.resetarRound();
                raiz = raiz.getFilhos().get(opcaoEvento);
            }
        }
        System.out.println("Voce VENCEU o DESAFIO SUPREMO!!!");
        InputHandler.sleep(0.4);
        System.out.println("Agora, voce é conhecido como o Dragao Guerreiro Mestre do Chi.");
        InputHandler.sleep(0.4);
        GerenciadorFinal.criarPoFeliz();
    }
    
}