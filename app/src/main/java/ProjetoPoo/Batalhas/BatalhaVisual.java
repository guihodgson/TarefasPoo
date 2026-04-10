package ProjetoPoo.Batalhas;

import java.util.ArrayList;

import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;
import ProjetoPoo.Efeitos.TipoEfeito;
import ProjetoPoo.Entidades.Entidade;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

public final class BatalhaVisual {

    private static final String SEPARADOR_BATALHA = "===================================8===================================";
    private static final String SEPARADOR_INIMIGO = "------------------------------------------------------------";
    private static final int TAMANHO_BARRA = 10;


    /**
     * Exibe o painel de batalha, mostrando o status do heroi e dos inimigos, e a proxima acao de cada inimigo.
     * @param heroi Heroi que esta batalhando.
     * @param inimigos Lista de inimigos da batalha.
     * @param inputHandler Lica com inputs.
     * @param tempo Quanto tempo dura a animação.
     */
    public static void exibirPainelBatalha(Heroi heroi, ArrayList<Inimigo> inimigos, InputHandler inputHandler, double tempo) {
        double tempoOpcao = tempo / (inimigos.size() + 1);
        
        Cor.imprimeAnsi(Cor.AMARELO, SEPARADOR_BATALHA);
        InputHandler.sleep(tempoOpcao);

        System.out.println("HEROI: " + Cor.formataCor(Cor.AMARELO, heroi.getNome()));
        InputHandler.sleep(tempoOpcao / 2);
        System.out.println(montarStatus(heroi));
        InputHandler.sleep(tempoOpcao);

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);

            Cor.imprimeAnsi(Cor.AMARELO, SEPARADOR_INIMIGO);
            InputHandler.sleep(tempoOpcao);

            System.out.println("INIMIGO " + (i + 1) + ": " + Cor.formataCor(Cor.VERMELHO, inimigo.getNome()));
            InputHandler.sleep(tempoOpcao / 2);
            System.out.println(montarStatus(inimigo));
            InputHandler.sleep(tempoOpcao / 2);
            inimigo.printarProxAcao();
            InputHandler.sleep(tempoOpcao);
        }

        Cor.imprimeAnsi(Cor.AMARELO, SEPARADOR_BATALHA);
        System.out.println();
    }

    /**
     * Mostra a energia com a cor correta dependendo de quanto que ainda resta.
     * @param heroi
     * @param inputHandler
     */
    public static void exibirEnergiaHeroi(Heroi heroi, InputHandler inputHandler) {
        double statusEnergia = calcularStatus(heroi.getEnergia(), heroi.getEnergiaMax());
        String energiaTexto = heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.";

        if (statusEnergia >= 0.8) {
            Cor.imprimeAnsi(Cor.VERDE, energiaTexto);
        }
        else if (statusEnergia >= 0.4) {
            Cor.imprimeAnsi(Cor.AMARELO, energiaTexto);
        }
        else {
            Cor.imprimeAnsi(Cor.VERMELHO, energiaTexto);
        }

        InputHandler.sleep(0.1);
        System.out.println();
    }

    public static void exibirErro(String mensagem, InputHandler inputHandler) {
        Cor.imprimeAnsi(Cor.VERMELHO, mensagem);
        inputHandler.pressEnter();
        inputHandler.clear();
    }

    /**
     * Monta os Status de efeitos para a entidade e retorna uma string.
     * @param entidade
     * @return
     */
    private static String montarStatus(Entidade entidade) {
        String barraVida = montarBarraVida(entidade.getVida(), entidade.getVidaMax());

        String status = "HP: " + barraVida + " " + entidade.getVida() + "/" + entidade.getVidaMax() + Cor.formataCor(Cor.AZUL, " \nEscudo: ") + entidade.getEscudo();

        status = adicionarEfeitoComDuracao(status, entidade, TipoEfeito.BONUS_DANO, Cor.AMARELO, " Bonus: ");
        status = adicionarEfeitoComDuracao(status, entidade, TipoEfeito.VENENO, Cor.VERDE, " Veneno: ");
        status = adicionarEfeitoComDuracao(status, entidade, TipoEfeito.VULNERAVEL, Cor.AMARELO, " Vulneravel: ", "+", "% de dano");
        status = adicionarEfeitoComDuracao(status, entidade, TipoEfeito.ENFRAQUECIDO, Cor.AMARELO, " Enfraquecido: ", "-", "% de dano");

        return status;
    }

    private static String adicionarEfeitoComDuracao(String status, Entidade entidade, TipoEfeito tipo, Cor cor, String titulo) {
        return adicionarEfeitoComDuracao(status, entidade, tipo, cor, titulo, "", "");
    }

    private static String adicionarEfeitoComDuracao(String status, Entidade entidade, TipoEfeito tipo, Cor cor, String titulo, String prefixoValor, String sufixoValor) {
        int valor = entidade.getValorEfeito(tipo);
        int tempo = entidade.getTempoEfeito(tipo);

        if (tempo <= 0) {
            return status;
        }

        if (tipo == TipoEfeito.VENENO) {
            valor = tempo;
        }
        return status + " |" + Cor.formataCor(cor, titulo) + prefixoValor + valor + sufixoValor + " por " + tempo + " round(s)";
    }

    private static String montarBarraVida(int vidaAtual, int vidaMaxima) {
        double statusVida = calcularStatus(vidaAtual, vidaMaxima);
        int blocosCheios = (int) Math.round(statusVida * TAMANHO_BARRA);
        if (blocosCheios < 0) {
            blocosCheios = 0;
        }
        else if (blocosCheios > TAMANHO_BARRA) {
            blocosCheios = TAMANHO_BARRA;
        }

        int blocosVazios = TAMANHO_BARRA - blocosCheios;

        String barraCheia = repetir("█", blocosCheios);
        String barraVazia = repetir("█", blocosVazios);

        if (statusVida > 0.7) {
            return Cor.formataCor(Cor.VERDE, barraCheia) + Cor.formataCor(Cor.VERDE_ESCURO, barraVazia);
        }
        if (statusVida > 0.4) {
            return Cor.formataCor(Cor.AMARELO, barraCheia) + Cor.formataCor(Cor.AMARELO_ESCURO, barraVazia);
        }
        return Cor.formataCor(Cor.VERMELHO, barraCheia) + Cor.formataCor(Cor.VERMELHO_ESCURO, barraVazia);
    }

    private static double calcularStatus(int atual, int maximo) {
        if (maximo <= 0) {
            return 0.0;
        }
        return Math.max(0.0, Math.min(1.0, ((double) atual) / ((double) maximo)));
    }

    private static String repetir(String texto, int quantidade) {
        String resultado = "";
        for (int i = 0; i < quantidade; i++) {
            resultado += texto;
        }
        return resultado;
    }
}
