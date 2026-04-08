package ProjetoPoo;

import java.util.ArrayList;

import ProjetoPoo.Cartas.AlvoCarta;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Entidades.Heroi;
import ProjetoPoo.Entidades.Inimigo;

public class Batalha {

    /**
     * Cria a batalha entre um heroi e um ou mais inimigos.
     * @param heroi Heroi que vai batalhar
     * @param inputHandler Pega os inputs
     * @param inimigos Lista de inimigos
     * @return Retorna True se ganhar e False se perder
     */
    public static boolean batalhar(Heroi heroi, InputHandler inputHandler, Inimigo... inimigos) {
        ArrayList<Inimigo> listaInimigos;

        do {
            listaInimigos = new ArrayList<>();
            for (Inimigo inimigo : inimigos) {
                if (inimigo.estaVivo()) {
                    listaInimigos.add(inimigo);
                }
            }
            ArrayList<String> listaNomeInimigos = listarInimigos(listaInimigos);

            BatalhaVisual.exibirPainelBatalha(heroi, listaInimigos, inputHandler, 0.5);
            inputHandler.sleep(0.25);
            BatalhaVisual.exibirEnergiaHeroi(heroi, inputHandler);

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), 0.4, true, "Encerrar Turno");

            if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (heroi.podeGastarEnergia(escolhida.getCusto())) {

                    if (escolhida.getTipo() == AlvoCarta.UM_ALVO) {  // Caso de um alvo
                        int alvo;
                        System.out.println("Escolha o alvo do ataque:\n");
                        alvo = inputHandler.selecionar(listaNomeInimigos, 0.2, true, "Voltar");

                        if (alvo < listaInimigos.size() && alvo >= 0) {  // Inimigo valido
                            heroi.gastarEnergia(escolhida.getCusto());
                            heroi.atualizarEfeito("ataque");
                            heroi.usarCartaNDeck(opcao, listaInimigos.get(alvo));
                            inputHandler.clear();
                        }

                        else if (alvo == listaInimigos.size()) {  // Voltar
                            inputHandler.clear();
                        }

                        else {
                            BatalhaVisual.exibirErro("Opcao invalida, tente novamente", inputHandler);
                        }
                    }

                    if (escolhida.getTipo() == AlvoCarta.GLOBAL) {  // Caso de global
                        heroi.gastarEnergia(escolhida.getCusto());
                        heroi.atualizarEfeito("ataque");
                        heroi.usarCartaNDeck(opcao, inimigos);
                        inputHandler.clear();
                    }

                    if (escolhida.getTipo() == AlvoCarta.USO_PROPRIO) {  // Caso de uso próprio
                        heroi.gastarEnergia(escolhida.getCusto());
                        heroi.atualizarEfeito("ataque");
                        heroi.usarCartaNDeck(opcao, heroi);
                        inputHandler.clear();
                    }
                }

                else {
                    BatalhaVisual.exibirErro("Energia insuficiente.", inputHandler);
                }
            }

            else if (opcao == heroi.tamDeck()){  // Passar de turno
                for (Inimigo inimigo : listaInimigos) {
                    inimigo.resetarRound();
                    inimigo.atualizarEfeito("fimRound");
                }

                listaInimigos.removeIf(inimigo -> !inimigo.estaVivo());

                heroi.atualizarEfeito("fimRound");

                for (Inimigo inimigo : listaInimigos) {
                    System.out.printf(Cor.VERMELHO.getCodigo());
                    inimigo.usarCartas(heroi);
                    System.out.printf(Cor.RESET.getCodigo());

                    inputHandler.sleep(0.4);
                    System.out.println();
                }

                inputHandler.pressEnter();
                inputHandler.clear();

                heroi.resetarRound();
            }
            else {
                BatalhaVisual.exibirErro("Opcao invalida, tente novamente", inputHandler);
            }
            listaInimigos.removeIf(inimigo -> !inimigo.estaVivo());
        } while (heroi.estaVivo() && !listaInimigos.isEmpty());

        return heroi.estaVivo();
    }

    private static ArrayList<String> listarInimigos(ArrayList<Inimigo> inimigos) {
        ArrayList<String> listaInimigos = new ArrayList<>();
        for (Inimigo vilao : inimigos) {
            listaInimigos.add(vilao.getNome());
        }
        return listaInimigos;
    }
}
