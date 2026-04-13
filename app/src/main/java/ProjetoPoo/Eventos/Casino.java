package ProjetoPoo.Eventos;

import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;

public class Casino extends Evento {

    private final Random random = new Random();

    public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Apostar Dinheiro"));
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Apostar Cartas"));
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Apostar Vida"));

        while (true) {
            InputHandler.imprimirBonito(Cor.formataCor(Cor.CIANO, "Bem-vindo ao Casino! Escolha uma opcao para apostar:"), 0.5);
            int opcao = inputHandler.selecionar(opcoes, 0.4, true, Cor.formataCor(Cor.CINZA_ESCURO, "Sair do Casino"));
            inputHandler.clear();

            if (opcao < 0 || opcao >= opcoes.size()) {
                InputHandler.imprimirBonito("Opcao invalida, tente novamente.", 0.5);
                inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                inputHandler.clear();
                return iniciar(inputHandler, ctx);
            }

            if (opcao == 3) {
                InputHandler.imprimirBonito("Voce decidiu sair do casino. Ate a proxima!", 0.5);
                System.out.println();
                inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                inputHandler.clear();
                return true;
            }

            if (opcao == 0) {
                int nMoedas = inputHandler.getInt("Voce escolheu apostar dinheiro. Escolha um numero de moedas para apostar. | Moedas:" + ctx.heroi.getMoedas(), 0.5);

                if (nMoedas <= 0 || nMoedas > ctx.heroi.getMoedas()) {
                    InputHandler.imprimirBonito("Valor invalido, tente novamente.", 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                    return iniciar(inputHandler, ctx);
                }

                int numeroSorteado = random.nextInt(1, nMoedas + 1);

                InputHandler.imprimirBonito("Tire um numero maior que" + nMoedas / 2, 0.4);
                for (int i = 1; i <= 20; i++) {
                    inputHandler.clear();
                    int numeroAleatorio = random.nextInt(1, nMoedas + 1);
                    System.out.println("Tire um numero maior que" + nMoedas / 2);
                    System.out.println(numeroAleatorio);
                    InputHandler.sleep(1 / i);
                }
                System.out.println("Tire um numero maior que" + nMoedas / 2);
                System.out.println(numeroSorteado);

                if (numeroSorteado > nMoedas / 2) {
                    ctx.heroi.aumentarMoedas(nMoedas);
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERDE, "Parabens! Voce ganhou " + nMoedas + " moedas!"), 0.5);
                }
                else {
                    ctx.heroi.perderMoedas(nMoedas);
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "Que pena! Voce perdeu " + nMoedas + " moedas!"), 0.5);
                }
            }
        }
    }
}
