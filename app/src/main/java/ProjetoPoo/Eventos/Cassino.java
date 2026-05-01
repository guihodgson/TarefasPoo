package ProjetoPoo.Eventos;

import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;

public class Cassino extends Evento {

    private final Random random = new Random();

    @Override
    public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Apostar Dinheiro"));
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Apostar Vida"));

        while (true) {
            Artes.imprimir(Artes.CASSINO);
            System.out.println();
            InputHandler.imprimirBonito(Cor.formataCor(Cor.CIANO, "Bem-vindo ao Cassino! Escolha uma opcao para apostar:\n"), 0.5);
            int opcao = inputHandler.selecionar(opcoes, 0.4, true, Cor.formataCor(Cor.CINZA_ESCURO, "Sair do Cassino"));
            inputHandler.clear();

            if (opcao < 0 || opcao > opcoes.size()) {
                InputHandler.imprimirBonito("Opcao invalida, tente novamente.", 0.5);
                inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                inputHandler.clear();
                return iniciar(inputHandler, ctx);
            }

            if (opcao == opcoes.size()) {
                InputHandler.imprimirBonito("Voce decidiu sair do cassino. Ate a proxima!", 0.5);
                System.out.println();
                inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                inputHandler.clear();
                return true;
            }

            if (opcao == 0) {
                InputHandler.imprimirBonito("Voce escolheu apostar " + Cor.formataCor(Cor.VERDE, "dinheiro") + ". Escolha um numero de moedas para apostar. " + Cor.formataCor(Cor.VERDE, " Moedas: " + ctx.heroi.getMoedas()), 0.5);
                InputHandler.imprimirBonito(Cor.formataCor(Cor.AMARELO, "-------------------------------------------------"), 0.2);
                int nMoedas = inputHandler.getInt("", 0.001);
                System.out.println();

                if (nMoedas <= 1 || nMoedas > ctx.heroi.getMoedas()) {
                    InputHandler.imprimirBonito("Valor invalido, tente novamente.", 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                    return iniciar(inputHandler, ctx);
                }

                int numeroSorteado = random.nextInt(1, nMoedas + 1);

                InputHandler.imprimirBonito("Tire um numero maior que " + nMoedas / 2, 0.4);
                for (int i = 1; i <= 25; i++) {
                    int numeroAleatorio = random.nextInt(1, nMoedas + 1);
                    System.out.println(Cor.formataCor(Cor.AZUL_CLARO, String.valueOf(numeroAleatorio)));
                    InputHandler.sleep(0.01 * i);
                    inputHandler.clearLines(1);
                }
                System.out.println(Cor.formataCor(Cor.AZUL_CLARO, String.valueOf(numeroSorteado)));

                if (numeroSorteado > nMoedas / 2) {
                    ctx.heroi.aumentarMoedas(nMoedas);
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERDE, "Parabens! Voce ganhou " + nMoedas + " moedas!"), 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                }
                else {
                    ctx.heroi.perderMoedas(nMoedas);
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "Que pena! Voce perdeu " + nMoedas + " moedas!"), 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                }
            }

            else if (opcao == 1) {
                int nVida = inputHandler.getInt("Voce escolheu apostar " + Cor.formataCor(Cor.VERMELHO, "vida") + ". Escolha um numero de vidas para apostar. " + Cor.formataCor(Cor.VERMELHO, " Vidas: " + ctx.heroi.getVida()), 0.5);
                InputHandler.imprimirBonito(Cor.formataCor(Cor.AMARELO, "-------------------------------------------------"), 0.2);
                System.out.println();

                if (nVida <= 1 || nVida > ctx.heroi.getVida()) {
                    InputHandler.imprimirBonito("Valor invalido, tente novamente.", 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                    return iniciar(inputHandler, ctx);
                }

                int numeroSorteado = random.nextInt(1, nVida + 1);

                InputHandler.imprimirBonito("Tire um numero maior que " + nVida / 2, 0.4);
                for (int i = 1; i <= 25; i++) {
                    int numeroAleatorio = random.nextInt(1, nVida + 1);
                    System.out.println(Cor.formataCor(Cor.AZUL_CLARO, String.valueOf(numeroAleatorio)));
                    InputHandler.sleep(0.01 * i);
                    inputHandler.clearLines(1);
                }
                System.out.println(Cor.formataCor(Cor.AZUL_CLARO, String.valueOf(numeroSorteado)));

                if (numeroSorteado > nVida / 2) {
                    ctx.heroi.curarVida(nVida);
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERDE, "Parabens! Voce ganhou " + nVida + " vidas!"), 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                }
                else {
                    ctx.heroi.receberDano(nVida);
                    if (!ctx.heroi.estaVivo()) {
                        InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "Que pena! Voce perdeu todas as suas vidas!"), 0.5);
                        InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA\n HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA\n  HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA HA\n").repeat(50), 2);
                        inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                        inputHandler.clear();
                        return false;
                    }
                    InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "Que pena! Voce perdeu " + nVida + " vidas!"), 0.5);
                    inputHandler.pressEnter(true, "Pressione Enter para continuar.");
                    inputHandler.clear();
                }
            }
        }
    }
}
