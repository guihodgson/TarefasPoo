import Entidades.GerenciadorHeroi;
import Entidades.GerenciadorInimigo;
import Entidades.Heroi;
import Entidades.Inimigo;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        InputHandler inputHandler = new InputHandler();

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

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
            System.out.println("Voce MORREU, o mundo continua em trevas.");  
            System.exit(0);
        }
        if (desafio == false) {
            System.out.println("Voce GANHOU de " + inimigo.getNome() + "!!\nO mundo esta mais seguro agora.");
            System.exit(0);
        }

        System.out.println("\nBATALHA 2");

        heroi.curarVida(10);
        heroi.resetarRound();

        System.out.println("Voce curou 10 de vida.\n");
        
        inputHandler.pressEnter();

        inimigo = GerenciadorInimigo.criarInimigo(1);

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
            System.out.println("Voce MORREU, o mundo continua em trevas.");  
            System.exit(0);
        }

        System.out.println("\nBATALHA 3");

        heroi.curarVida(16);
        heroi.resetarRound();
        System.out.println("Voce curou 16 de vida.\n");
        
        inputHandler.pressEnter();

        inimigo = GerenciadorInimigo.criarInimigo(2);

        if (!Batalha.batalhar(heroi, inimigo, inputHandler)) {
            System.out.println("Voce MORREU, o mundo continua em trevas.");  
            System.exit(0);
        }

        System.out.println("Voce VENCEU o DESAFIO SUPREMO!!!");
        System.out.println("Agora, voce é conhecido como o Dragao Guerreiro Mestre do Chi.");
    }
}