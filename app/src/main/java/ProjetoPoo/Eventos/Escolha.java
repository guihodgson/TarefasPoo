package ProjetoPoo.Eventos;

import java.util.ArrayList;
import java.util.Random;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Cor;
import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.InputHandler;

public class Escolha extends Evento {

	private static final int MOEDAS_GANHAS = 50;
	private static final int SKIDOOSH_CUSTO = 5;
	private static final int SKIDOOSH_DANO = 12;

	private static final int CURA_10_VIDA = 10;
	private static final int CURA_20_VIDA = 20;
	private static final int CURA_30_VIDA = 30;
	private static final int CURA_10_CUSTO = 50;
	private static final int CURA_20_CUSTO = 100;
	private static final int CURA_30_CUSTO = 150;

	private final Random random = new Random();

	@Override
	public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
		ArrayList<String> opcoes = new ArrayList<>();
		opcoes.add(Cor.formataCor(Cor.AMARELO, "Ganhar " + MOEDAS_GANHAS + " Moedas"));
		opcoes.add(Cor.formataCor(Cor.AMARELO, "Curar Vida"));
		opcoes.add(Cor.formataCor(Cor.AMARELO, "Ganhar Carta Especial"));

		Artes.imprimir(Artes.ESCOLHA);
		System.out.println();

		InputHandler.imprimirBonito(
				"Você encontrou um caminho com três recompensas."
						+ "\nEscolha entre " + Cor.formataCor(Cor.AZUL, "moedas")
						+ ", " + Cor.formataCor(Cor.VERDE, "cura")
						+ " ou uma " + Cor.formataCor(Cor.VERMELHO, "carta especial") + ".",
				0.35);

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
			InputHandler.imprimirBonito("Você ganhou " + MOEDAS_GANHAS + " moedas! Agora você possui " + Cor.formataCor(Cor.AZUL, String.valueOf(ctx.heroi.getMoedas())) + " moedas.", 0.25);
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return true;
		}

		if (opcao == 1) {
			return iniciarCura(inputHandler, ctx);
		}

		if (opcao == 2) {
			Carta cartaRecebida = sortearCartaEspecial();
			ctx.heroi.adicionarCartaBaralho(cartaRecebida, 1);

			InputHandler.imprimirBonito("Você recebeu a carta " + Cor.formataCor(Cor.AMARELO, cartaRecebida.getNome()) + "! Ela foi adicionada ao seu baralho.", 0.3);
			System.out.println();
			InputHandler.imprimirBonito(cartaRecebida.getArte().getArte(), 0.15);
			inputHandler.pressEnter(true, Cor.formataCor(Cor.CINZA_ESCURO, "Pressione Enter para continuar."));
			inputHandler.clear();
			return true;
		}

		return true;
	}

	private boolean iniciarCura(InputHandler inputHandler, ContextoHeroi ctx) {
		ArrayList<String> opcoesCura = new ArrayList<>();
		opcoesCura.add(Cor.formataCor(Cor.AMARELO, CURA_10_VIDA + " de vida por " + CURA_10_CUSTO + " moedas"));
		opcoesCura.add(Cor.formataCor(Cor.AMARELO, CURA_20_VIDA + " de vida por " + CURA_20_CUSTO + " moedas"));
		opcoesCura.add(Cor.formataCor(Cor.AMARELO, CURA_30_VIDA + " de vida por " + CURA_30_CUSTO + " moedas"));

		InputHandler.imprimirBonito("Você escolheu curar vida." + "\n" + Cor.formataCor(Cor.AZUL, "Moedas: ") + ctx.heroi.getMoedas() + " | " + Cor.formataCor(Cor.VERDE, "Vida: ") + ctx.heroi.getVida() + "/" + ctx.heroi.getVidaMax(), 0.25);
		int opcaoCura = inputHandler.selecionar(opcoesCura, 0.35, true, Cor.formataCor(Cor.CINZA_ESCURO, "Voltar"));
		inputHandler.clear();

		if (opcaoCura < 0 || opcaoCura > opcoesCura.size()) {
			InputHandler.imprimirBonito("Opcao invalida, tente novamente.", 0.3);
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return iniciarCura(inputHandler, ctx);
		}

		if (opcaoCura == opcoesCura.size()) {
			return iniciar(inputHandler, ctx);
		}

		int cura;
		int custo;
		if (opcaoCura == 0) {
			cura = CURA_10_VIDA;
			custo = CURA_10_CUSTO;
		}
		else if (opcaoCura == 1) {
			cura = CURA_20_VIDA;
			custo = CURA_20_CUSTO;
		}
		else {
			cura = CURA_30_VIDA;
			custo = CURA_30_CUSTO;
		}

		if (!ctx.heroi.podeGastarMoedas(custo)) {
			InputHandler.imprimirBonito(Cor.formataCor(Cor.VERMELHO, "Moedas insuficientes."), 0.25);
			inputHandler.pressEnter(true, "Pressione Enter para continuar.");
			inputHandler.clear();
			return iniciarCura(inputHandler, ctx);
		}

		ctx.heroi.gastarMoedas(custo);
		int vidaAnterior = ctx.heroi.getVida();
		ctx.heroi.curarVida(cura);
		InputHandler.imprimirBonito("Você curou " + (ctx.heroi.getVida() - vidaAnterior) + " de vida e gastou " + custo + " moedas." + "\n" + Cor.formataCor(Cor.VERDE, "Vida: ") + ctx.heroi.getVida() + "/" + ctx.heroi.getVidaMax() + " | " + Cor.formataCor(Cor.AZUL, "Moedas: ") + ctx.heroi.getMoedas(), 0.25);
		inputHandler.pressEnter(true, "Pressione Enter para continuar.");
		inputHandler.clear();
		return true;
	}

	private Carta sortearCartaEspecial() {
		ArrayList<Carta> pool = criarPoolCartasEspeciais();
		return pool.get(random.nextInt(pool.size()));
	}

	private static ArrayList<Carta> criarPoolCartasEspeciais() {
		ArrayList<Carta> pool = new ArrayList<>();

		pool.add(new CartaDano(
				"Skidoosh (" + SKIDOOSH_DANO + " de ataque em área)",
				"O Ataque Espiritual mais forte do Dragão Guerreiro, atingindo todos os inimigos",
				SKIDOOSH_CUSTO,
				SKIDOOSH_DANO,
				AlvoCarta.GLOBAL,
				Artes.SKIDOOSH)
	);

		pool.add(new CartaDano(
				"Golpe do Mestre (6 de ataque)",
				"Um golpe preciso e eficiente do Dragão Guerreiro",
				1,
				6,
				AlvoCarta.UM_ALVO,
				Artes.BANG1));

		pool.add(new CartaEscudo(
				"Guarda do Mestre (7 de defesa)",
				"Uma postura defensiva que bloqueia bem, com pouco esforço",
				1,
				7,
				AlvoCarta.USO_PROPRIO,
				Artes.ESCUDO));

		pool.add(new CartaEfeito(
				"Chi Intenso (+3 de ataque por 2 rounds)",
				"Canaliza o Chi para aumentar o dano por um curto período",
				1,
				AlvoCarta.USO_PROPRIO,
				Artes.BONUS,
				new EfeitoBonusDano(3, 2, TipoEfeito.BONUS_DANO)));

		pool.add(new CartaEfeito(
				"Macarrão Ultra Envenenado (Veneno por +5 rounds)",
				"Uma comida especial que aplica um veneno mais duradouro",
				1,
				AlvoCarta.UM_ALVO,
				Artes.VENENO,
				new EfeitoVeneno(5, TipoEfeito.VENENO)));

		pool.add(new CartaEfeito(
				"Ponto Fraco Revelado (+35% dano recebido por 2 rounds)",
				"Um golpe certeiro que deixa o inimigo mais vulnerável",
				1,
				AlvoCarta.UM_ALVO,
				Artes.BONUS,
				new EfeitoVulneravel(35, 2, TipoEfeito.VULNERAVEL)));

		pool.add(new CartaEfeito(
				"Intimidação do Dragão (-35% dano causado por 2 rounds)",
				"A pressão do Dragão Guerreiro enfraquece o inimigo",
				1,
				AlvoCarta.UM_ALVO,
				Artes.BONUS,
				new EfeitoEnfraquecido(35, 2, TipoEfeito.ENFRAQUECIDO)));

		return pool;
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
