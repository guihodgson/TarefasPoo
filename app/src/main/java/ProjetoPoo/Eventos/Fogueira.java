package ProjetoPoo.Eventos;

import java.util.ArrayList;

import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;

public class Fogueira extends Evento {

    @Override
    public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Curar Vida"));
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Melhorar Cartas"));

        Artes.imprimir(Artes.FOGUEIRA);
        System.out.println();

        InputHandler.imprimirBonito("Você encontrou uma " + Cor.formataCor(Cor.AMARELO, "fogueira!") + " Hora de descansar e se preparar para os próximos desafios.", 0.5);
        int opcao = inputHandler.selecionar(opcoes, 0.4, true, Cor.formataCor(Cor.CINZA_ESCURO, "Sair da Fogueira"));

        if (opcao < 0 || opcao > opcoes.size()) {
            InputHandler.imprimirBonito("Opcao invalida, tente novamente.", 0.5);
            inputHandler.pressEnter(true, "Pressione Enter para continuar.");
            inputHandler.clear();
            return iniciar(inputHandler, ctx);
        }

        if (opcao == opcoes.size()) {
            InputHandler.imprimirBonito("Voce decidiu sair da fogueira. Ate a proxima!", 0.5);
            System.out.println();
            inputHandler.pressEnter(true, "Pressione Enter para continuar.");
            inputHandler.clear();
            return true;
        }

        if (opcao == 0) {
            ctx.heroi.curarVida(ctx.heroi.getVidaMax() / 4);
            InputHandler.imprimirBonito("Voce escolheu curar sua vida. Sua vida foi restaurada para " + Cor.formataCor(Cor.VERDE, String.valueOf(ctx.heroi.getVida())) + " HP.", 0.5);
            inputHandler.pressEnter(true, "Pressione Enter para continuar.");
            inputHandler.clear();
        } 

        else if (opcao == 1) {
            InputHandler.imprimirBonito("Manutencao em andamento", 0.2);
            InputHandler.imprimirBonito("Em breve voce podera melhorar suas cartas aqui!", 0.5);
            inputHandler.pressEnter(true, "Pressione Enter para continuar.");
            inputHandler.clear();
        }

        return true;
    }

}
