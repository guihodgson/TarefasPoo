package ProjetoPoo.Eventos;

import java.util.ArrayList;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;

public class Escolha extends Evento {

	private static final int MOEDAS_GANHAS = 50;
	private static final int SKIDOOSH_CUSTO = 5;
	private static final int SKIDOOSH_DANO = 18;

	@Override
	public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
		ArrayList<String> opcoes = new ArrayList<>();
		opcoes.add(Cor.formataCor(Cor.AMARELO, "Ganhar " + MOEDAS_GANHAS + " Moedas"));
		opcoes.add(Cor.formataCor(Cor.AMARELO, "Ganhar Carta Especial"));

		Artes.imprimir(Artes.ESCOLHA);
		System.out.println();

		InputHandler.imprimirBonito("Você encontrou um caminho com duas recompensas." + "\nEscolha entre " + Cor.formataCor(Cor.AZUL, "moedas") + " ou uma " + Cor.formataCor(Cor.VERMELHO, "carta especial") + ".", 0.35);

		int opcao = inputHandler.selecionar(opcoes, 0.35, true, Cor.formataCor(Cor.CINZA_ESCURO, "Sair"));
		inputHandler.clear();

		if (opcao < 0 || opcao > opcoes.size()) {
			InputHandler.imprimirBonito("Opcao invalida, tente novamente.", 0.3);
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return iniciar(inputHandler, ctx);
		}

		if (opcao == opcoes.size()) {
			InputHandler.imprimirBonito("Você decidiu seguir em frente.", 0.25);
			System.out.println();
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return true;
		}

		if (opcao == 0) {
			ctx.heroi.aumentarMoedas(MOEDAS_GANHAS);
			InputHandler.imprimirBonito(
					"Você ganhou " + MOEDAS_GANHAS + " moedas! Agora você possui " + Cor.formataCor(Cor.AZUL, String.valueOf(ctx.heroi.getMoedas())) + " moedas.", 0.25);
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return true;
		}

		if (opcao == 1) {
            CartaDano cartaSkidoosh = criarSkidooshArea();
			ctx.heroi.adicionarCartaBaralho(cartaSkidoosh, 1);

			InputHandler.imprimirBonito("Você recebeu a carta " + Cor.formataCor(Cor.VERMELHO, "Skidoosh") + " (dano em área)! Ela foi adicionada ao seu baralho.", 0.3);
			System.out.println();
			InputHandler.imprimirBonito(cartaSkidoosh.getArte().getArte(), 0.15);
			inputHandler.pressEnter(true, Cor.formataCor(Cor.CINZA_ESCURO, "Pressione Enter para continuar."));
			inputHandler.clear();
			return true;
		}

		return true;
	}

	private static CartaDano criarSkidooshArea() {
		return new CartaDano(
				"Skidoosh (" + SKIDOOSH_DANO + " de ataque em área)",
				"O Ataque Espiritual mais forte do Dragão Guerreiro, atingindo todos os inimigos",
				SKIDOOSH_CUSTO,
				SKIDOOSH_DANO,
				AlvoCarta.GLOBAL,
				Artes.SKIDOOSH);
	}
}
