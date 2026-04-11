package ProjetoPoo.Batalhas;

import java.util.ArrayList;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Cor;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;
import ProjetoPoo.InputHandler;

public class Batalha extends Evento {

    /**
     * Lista os nomes dos inimigos.
     * @param inimigos A lista de inimigos.
     * @return Uma lista de strings contendo os nomes dos inimigos.
     */
    private static ArrayList<String> listarInimigos(ArrayList<Inimigo> inimigos) {
        ArrayList<String> listaInimigos = new ArrayList<>();
        for (Inimigo vilao : inimigos) {
            listaInimigos.add(vilao.getNome());
        }
        return listaInimigos;
    }

    /**
     * Inicia a batalha.
     * @param inputHandler O objeto que lida com as entradas do usuário.
     * @param ctx O contexto do herói.
     * @return true se o herói vencer, false caso contrário.
     */
    public boolean iniciar(InputHandler inputHandler, ContextoHeroi ctx) {
        Heroi heroi = ctx.heroi;
        ArrayList<Inimigo> inimigos = ctx.inimigos;

        double tempoPainel;
        double tempoPadrao;
        double tempoImagem;
        int acoesRound = 0;

        while(heroi.estaVivo() && !inimigos.isEmpty()) {
            if (acoesRound  == 0) {
                tempoPainel = 0.6;
                tempoPadrao = 0.25;
                tempoImagem = 0.2;
            }
            else {
                tempoPainel = 0.1;
                tempoPadrao = 0.05;
                tempoImagem = 0.2;
            }

            BatalhaVisual.exibirPainelBatalha(heroi, inimigos, inputHandler, tempoPainel);
            InputHandler.sleep(tempoPadrao);
            BatalhaVisual.exibirEnergiaHeroi(heroi, inputHandler);
            
            int nCartaSelecionada = inputHandler.selecionar(heroi.mostrarDeck(), tempoPadrao, true, Cor.formataCor(Cor.CINZA_ESCURO, "Encerrar turno."));
            
            acoesRound++;
            
            if (!nValidoEntre(nCartaSelecionada, 0, heroi.mostrarDeck().size())) {  // Verifica se a carta selecionada é valida
                BatalhaVisual.exibirErro("Valor Invalido.", inputHandler);
                continue;
            }
            
            if (nCartaSelecionada == heroi.mostrarDeck().size()) {  // Passar de turno
                encerrarTurno(heroi, inimigos, tempoPadrao, inputHandler);
                acoesRound = 0;
                continue;
            }
            
            Carta cartaSelecionada = heroi.getCartaNDeck(nCartaSelecionada);
            
            if (!heroi.podeGastarEnergia(cartaSelecionada.getCusto())) {   // Verifica se o heroi tem energia suficiente para usar a carta
                BatalhaVisual.exibirErro("Energia Insuficiente.", inputHandler);
                continue;
            }
            
            if (cartaSelecionada.getAlvo() == AlvoCarta.UM_ALVO) {  // Caso de um alvo
                int nInimSelecionado = inputHandler.selecionar(listarInimigos(inimigos), tempoPadrao, true, "Voltar.");
                
                if (!nValidoEntre(nInimSelecionado, 0, listarInimigos(inimigos).size())) {  // Verifica se o inimigo selecionado é valido
                    BatalhaVisual.exibirErro("Valor Invalido.", inputHandler);
                    continue;
                }
                
                if (nInimSelecionado == listarInimigos(inimigos).size()) {  // Voltar
                    inputHandler.clear();
                    continue;
                }
                
                heroi.usarCartaNDeck(nCartaSelecionada, inimigos.get(nInimSelecionado));
            }
            
            if (cartaSelecionada.getAlvo() == AlvoCarta.GLOBAL) {  // Caso de global
                heroi.usarCartaNDeck(nCartaSelecionada, inimigos);
            }
            
            if (cartaSelecionada.getAlvo() == AlvoCarta.USO_PROPRIO) {  // Caso de uso próprio
                heroi.usarCartaNDeck(nCartaSelecionada, heroi);
            }

            heroi.gastarEnergia(cartaSelecionada.getCusto());
            heroi.atualizarEfeito("ataque");
            inputHandler.clear();
            InputHandler.imprimirBonito(cartaSelecionada.getArte().getArte(), tempoImagem);
            inputHandler.pressEnter(true, Cor.formataCor(Cor.CINZA_ESCURO, "Pressione Enter para prosseguir."));
            inputHandler.clear();

            inimigos.removeIf(inimigo -> !inimigo.estaVivo());
        }
        heroi.limparEfeitos();
        return heroi.estaVivo();
    }
    
    private static boolean nValidoEntre(int val, int a, int b) {
        return (val <= b && val >= a);
    }

    private static void encerrarTurno(Heroi heroi, ArrayList<Inimigo> inimigos, double tempoPadrao, InputHandler inputHandler) {
        for (Inimigo inimigo : inimigos) {
            inimigo.resetarRound();
            inimigo.atualizarEfeito("fimRound");
        }

        inimigos.removeIf(inimigo -> !inimigo.estaVivo());

        heroi.atualizarEfeito("fimRound");

        for (Inimigo inimigo : inimigos) {
            System.out.printf(Cor.VERMELHO.getCodigo());
            inimigo.usarCartas(heroi);
            System.out.printf(Cor.RESET.getCodigo());

            InputHandler.sleep(tempoPadrao);
            System.out.println();
        }

        inputHandler.pressEnter();
        inputHandler.clear();

        heroi.resetarRound();
    }
}
