package ProjetoPoo;

import java.util.ArrayList;

import ProjetoPoo.Entidades.GerenciadorHeroi;
import ProjetoPoo.Entidades.GerenciadorInimigo;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

/**
 * Classe de entrada da aplicação.
 *
 * <p>Responsável por inicializar a interface de texto, permitir a escolha do
 * filme e coordenar a batalha principal ou o desafio final.</p>
 */
public class App {
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

        inputHandler.clear();
        GerenciadorTitulo.criarTitulo();

        
        ArrayList<String> opcoesFilme = new ArrayList<>();
        opcoesFilme.add("Filme 1");
        opcoesFilme.add("Filme 2");
        opcoesFilme.add("Filme 3");
        opcoesFilme.add("DESAFIO");
        
        int filmeEscolhido;
        
        do {
            System.out.println("Selecione o filme que você quer jogar:");
            filmeEscolhido = inputHandler.selecionar(opcoesFilme, 0.8);
        } while (filmeEscolhido > 3 || filmeEscolhido < 0);
        
        Boolean desafio = false;
        
        if (filmeEscolhido == 3) {
            desafio = true;
            filmeEscolhido = 0;
        }
        
        Inimigo inimigo = GerenciadorInimigo.criarInimigo(filmeEscolhido);
        
        inimigo.embaralharMao();
        
        inputHandler.clear();
        
        if (!desafio) {
            Heroi heroi = GerenciadorHeroi.criarHeroi(34, 5, 0);
            if (!Batalha.batalhar(heroi, inputHandler, inimigo)) {
                System.out.println("Você MORREU, o mundo continua em trevas.");  
                inputHandler.sleep(0.4);
                GerenciadorFinal.criarPoTriste();
                System.exit(0);
            }
            if (desafio == false) {
                System.out.println("Você GANHOU de " + inimigo.getNome() + "!!\nO mundo está mais seguro agora.");
                inputHandler.sleep(0.4);
                GerenciadorFinal.criarPoFeliz();
                System.exit(0);
            }
        }

        Inimigo inimigo2 = GerenciadorInimigo.criarInimigo(1);
        Inimigo inimigo3 = GerenciadorInimigo.criarInimigo(2);
        Heroi heroi = GerenciadorHeroi.criarHeroi(50, 8, 1);

        if (!Batalha.batalhar(heroi, inputHandler, inimigo, inimigo2, inimigo3)) {
            System.out.println("Você MORREU, o mundo continua em trevas.");  
            inputHandler.sleep(0.4);
            GerenciadorFinal.criarPoTriste();
            System.exit(0);
        }

        System.out.println("Voce VENCEU o DESAFIO SUPREMO!!!");
        inputHandler.sleep(0.4);
        System.out.println("Agora, voce é conhecido como o Dragao Guerreiro Mestre do Chi.");
        inputHandler.sleep(0.4);
        GerenciadorFinal.criarPoFeliz();
    }
}