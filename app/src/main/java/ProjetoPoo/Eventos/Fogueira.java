package ProjetoPoo.Eventos;

import java.util.ArrayList;

import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;

public class Fogueira extends Evento {

    @Override
    public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Curar Vida"));
        opcoes.add(Cor.formataCor(Cor.AMARELO, "Ganhar 50 Moedas"));

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
            ctx.heroi.setMoedas(ctx.heroi.getMoedas() + 50);
            InputHandler.imprimirBonito("Voce ganhou 50 moedas! Voce possui " + Cor.formataCor(Cor.AZUL, String.valueOf(ctx.heroi.getMoedas())) + " moedas.", 0.2);
            inputHandler.pressEnter(true, "Pressione Enter para continuar.");
            inputHandler.clear();
            return true;
        }

        return true;
    }

}
