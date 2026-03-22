import Entidades.GerenciadorHeroi;
import Entidades.GerenciadorInimigo;
import Entidades.Heroi;
import Entidades.Inimigo;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = new InputHandler();

        inputHandler.clear();
        GerenciadorTitulo.criarTitulo();

        Heroi heroi = GerenciadorHeroi.criarHeroi();

        ArrayList<String> opcoesFilme = new ArrayList<>();
        opcoesFilme.add("Filme 1");
        opcoesFilme.add("Filme 2");
        opcoesFilme.add("Filme 3");
        opcoesFilme.add("DESAFIO");

        int filmeEscolhido;

        do {
            System.out.println("Selecione o filme que você quer jogar:");
            filmeEscolhido = inputHandler.selecionar(opcoesFilme);
        } while (filmeEscolhido > 3 || filmeEscolhido < 0);

        Boolean desafio = false;

        if (filmeEscolhido == 3) {
            desafio = true;
            filmeEscolhido = 0;
        }

        Inimigo inimigo = GerenciadorInimigo.criarInimigo(filmeEscolhido);

        inimigo.embaralharMao();

        inputHandler.clear();

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
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

        System.out.println("\nBATALHA 2");

        heroi.curarVida(10);
        heroi.resetarRound();

        System.out.println("Você curou 10 de vida.\n");
        
        inputHandler.pressEnter();
        inputHandler.clear();

        inimigo = GerenciadorInimigo.criarInimigo(1);

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
            System.out.println("Você MORREU, o mundo continua em trevas.");  
            inputHandler.sleep(0.4);
            GerenciadorFinal.criarPoTriste();
            System.exit(0);
        }

        System.out.println("\nBATALHA 3");

        heroi.curarVida(16);
        heroi.resetarRound();
        System.out.println("Você curou 16 de vida.\n");
        
        inputHandler.pressEnter();
        inputHandler.clear();

        inimigo = GerenciadorInimigo.criarInimigo(2);

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
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