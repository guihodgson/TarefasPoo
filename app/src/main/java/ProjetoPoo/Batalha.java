package ProjetoPoo;

import java.util.ArrayList;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

public class Batalha {

    // /**
    //  * Cria a batalha entre um heroi e um ou mais inimigos.
    //  * @param heroi Heroi que vai batalhar
    //  * @param inputHandler Pega os inputs
    //  * @param inimigos Lista de inimigos
    //  * @return Retorna True se ganhar e False se perder
    //  */
    // public static boolean batalhar(Heroi heroi, InputHandler inputHandler, Inimigo... inimigos) {
    //     ArrayList<Inimigo> listaInimigos;
    //     boolean primeiraAcao = true;

    //     do {
    //         listaInimigos = new ArrayList<>();
    //         for (Inimigo inimigo : inimigos) {
    //             if (inimigo.estaVivo()) {
    //                 listaInimigos.add(inimigo);
    //             }
    //         }
    //         ArrayList<String> listaNomeInimigos = listarInimigos(listaInimigos);

    //         double tempo;
    //         if (primeiraAcao) {
    //             tempo = 0.5;
    //         }
    //         else {
    //             tempo = 0;
    //         }

    //         primeiraAcao = false;

    //         BatalhaVisual.exibirPainelBatalha(heroi, listaInimigos, inputHandler, tempo);
    //         InputHandler.sleep(0.25);
    //         BatalhaVisual.exibirEnergiaHeroi(heroi, inputHandler);

    //         int opcao = inputHandler.selecionar(heroi.mostrarDeck(), tempo * 0.7, true, "Encerrar Turno");

    //         if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
    //             Carta escolhida = heroi.getCartaNDeck(opcao);

    //             if (heroi.podeGastarEnergia(escolhida.getCusto())) {

    //                 if (escolhida.getAlvo() == AlvoCarta.UM_ALVO) {  // Caso de um alvo
    //                     int alvo;
    //                     System.out.println("Escolha o alvo do ataque:\n");
    //                     alvo = inputHandler.selecionar(listaNomeInimigos, 0.2, true, "Voltar");

    //                     if (alvo < listaInimigos.size() && alvo >= 0) {  // Inimigo valido
    //                         heroi.gastarEnergia(escolhida.getCusto());
    //                         heroi.atualizarEfeito("ataque");
    //                         heroi.usarCartaNDeck(opcao, listaInimigos.get(alvo));
    //                         inputHandler.clear();
    //                         escolhida.getArte().imprimirBonito(0.2);
    //                         inputHandler.pressEnter();
    //                         inputHandler.clear();
    //                     }

    //                     else if (alvo == listaInimigos.size()) {  // Voltar
    //                         inputHandler.clear();
    //                     }

    //                     else {
    //                         BatalhaVisual.exibirErro("Opcao invalida, tente novamente", inputHandler);
    //                     }
    //                 }

    //                 if (escolhida.getAlvo() == AlvoCarta.GLOBAL) {  // Caso de global
    //                     heroi.gastarEnergia(escolhida.getCusto());
    //                     heroi.atualizarEfeito("ataque");
    //                     heroi.usarCartaNDeck(opcao, inimigos);
    //                     inputHandler.clear();
    //                     escolhida.getArte().imprimirBonito(0.2);
    //                     inputHandler.pressEnter();
    //                     inputHandler.clear();
    //                 }

    //                 if (escolhida.getAlvo() == AlvoCarta.USO_PROPRIO) {  // Caso de uso próprio
    //                     heroi.gastarEnergia(escolhida.getCusto());
    //                     heroi.atualizarEfeito("ataque");
    //                     heroi.usarCartaNDeck(opcao, heroi);
    //                     inputHandler.clear();
    //                     escolhida.getArte().imprimirBonito(0.2);
    //                     inputHandler.pressEnter();
    //                     inputHandler.clear();
    //                 }
    //             }

    //             else {
    //                 BatalhaVisual.exibirErro("Energia insuficiente.", inputHandler);
    //             }
    //         }

    //         else if (opcao == heroi.tamDeck()){  // Passar de turno
    //             for (Inimigo inimigo : listaInimigos) {
    //                 inimigo.resetarRound();
    //                 inimigo.atualizarEfeito("fimRound");
    //                 primeiraAcao = true;
    //             }

    //             listaInimigos.removeIf(inimigo -> !inimigo.estaVivo());

    //             heroi.atualizarEfeito("fimRound");

    //             for (Inimigo inimigo : listaInimigos) {
    //                 System.out.printf(Cor.VERMELHO.getCodigo());
    //                 inimigo.usarCartas(heroi);
    //                 System.out.printf(Cor.RESET.getCodigo());

    //                 InputHandler.sleep(0.4);
    //                 System.out.println();
    //             }

    //             inputHandler.pressEnter();
    //             inputHandler.clear();

    //             heroi.resetarRound();
    //         }
    //         else {
    //             BatalhaVisual.exibirErro("Opcao invalida, tente novamente", inputHandler);
    //         }
    //         listaInimigos.removeIf(inimigo -> !inimigo.estaVivo());
    //     } while (heroi.estaVivo() && !listaInimigos.isEmpty());

    //     return heroi.estaVivo();
    // }

    private static ArrayList<String> listarInimigos(ArrayList<Inimigo> inimigos) {
        ArrayList<String> listaInimigos = new ArrayList<>();
        for (Inimigo vilao : inimigos) {
            listaInimigos.add(vilao.getNome());
        }
        return listaInimigos;
    }

    public static boolean iniciar(InputHandler inputHandler, Heroi heroi, ArrayList<Inimigo> inimigos) {
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
                tempoPainel = 0.2;
                tempoPadrao = 0.1;
                tempoImagem = 0.1;
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
