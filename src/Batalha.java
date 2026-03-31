
import java.util.ArrayList;

import Cartas.Carta;
import Cartas.CartaDano;
import Cartas.CartaEnfraquecido;
import Cartas.CartaVeneno;
import Cartas.CartaVulneravel;
import Entidades.Entidade;
import Entidades.Heroi;
import Entidades.Inimigo;

public class Batalha {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static String montarStatus(Entidade entidade) {
        double statusVida = ((double) entidade.getVida()) / ((double) entidade.getVidaMax());

        String barraVida = "";

        if (statusVida > 0.7) {
            for (int i = 0; i < (int) (statusVida * 10); i++) {
                barraVida += "█";
            }
            barraVida = String.format("%-10s", barraVida);
            barraVida = ANSI_GREEN + "█" + barraVida;
            barraVida += ANSI_RESET;
        }
        else if (statusVida > 0.4) {
            for (int i = 0; i < (int) (statusVida * 10); i++) {
                barraVida += "█";
            }
            barraVida = String.format("%-10s", barraVida);
            barraVida = ANSI_YELLOW + "█" + barraVida;
            barraVida += ANSI_RESET;
        }
        else {
            for (int i = 0; i < (int) (statusVida * 10); i++) {
                barraVida += "█";
            }
            barraVida = String.format("%-10s", barraVida);
            barraVida = ANSI_RED + "█" + barraVida;
            barraVida += ANSI_RESET;
        }


        String status = "HP: " + barraVida + " " + entidade.getVida() + "/" + entidade.getVidaMax() + " \nEscudo: " + entidade.getEscudo();

        int bonus = entidade.calcularBonusDano();
        if (bonus > 0) {
            status += " | Bonus: " + bonus + " por " + entidade.calcularTempoBonusDano(bonus) + " round(s)";
        }

        int veneno = entidade.calcularVeneno();
        if (veneno > 0) {
            status += " | Veneno: " + veneno + " por " + entidade.calcularTempoVeneno(veneno) + " round(s)";
        }

        int vulneravel = entidade.calcularVulneravel();
        if (vulneravel > 0) {
            status += " | Vulneravel: +" + vulneravel + "% de dano por " + entidade.calcularTempoVulneravel(vulneravel) + " round(s)";
        }

        int enfraquecido = entidade.calcularEnfraquecido();
        if (enfraquecido > 0) {
            status += " | Enfraquecido: -" + enfraquecido + "% de dano por " + entidade.calcularTempoEnfraquecido(enfraquecido) + " round(s)";
        }

        return status;
    }

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


            System.out.println(ANSI_YELLOW + "===================================8===================================" + ANSI_RESET);
            inputHandler.sleep(0.4);
            System.out.println("HEROI: " + heroi.getNome());
            System.out.println(montarStatus(heroi));
            inputHandler.sleep(0.4);
            for (Inimigo vilao : listaInimigos) {
                System.out.println(ANSI_YELLOW + "------------------------------------------------------------" + ANSI_RESET);
                inputHandler.sleep(0.4);
                System.out.println("INIMIGO " + (listaInimigos.indexOf(vilao) + 1) + ": " + vilao.getNome());
                System.out.println(montarStatus(vilao));
                
                vilao.printarProxAcao();
                inputHandler.sleep(0.4);
            }
            System.out.println(ANSI_YELLOW + "===================================8===================================" + ANSI_RESET);
            System.out.println();
            

            inputHandler.sleep(0.4);

            double statusEnergia = ((double) heroi.getEnergia()) / ((double) heroi.getEnergiaMax());
            if (statusEnergia >= 0.8) {
                System.out.println(ANSI_GREEN + heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes." + ANSI_RESET );
            }
            else if (statusEnergia >= 0.4) {
                System.out.println(ANSI_YELLOW + heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes." + ANSI_RESET );
            }
            else {
                System.out.println(ANSI_RED + heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes." + ANSI_RESET );
            }

            System.out.println();

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), true);

            if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                    int alvo = 0;
                    boolean temAlvo = false;
                    if (escolhida instanceof CartaDano || escolhida instanceof CartaVeneno || escolhida instanceof CartaVulneravel || escolhida instanceof CartaEnfraquecido) {
                        System.out.println("Escolha o alvo do ataque:\n");
                        alvo = inputHandler.selecionar(listaNomeInimigos, false);
                        temAlvo = true;
                    }

                    if (!temAlvo || (alvo < listaInimigos.size() && alvo >= 0)) {  // Alvo valido
                        heroi.gastarEnergia(escolhida.getCusto());
                        heroi.atualizarEfeito("ataque");
                        heroi.usarCartaNDeck(opcao, listaInimigos.get(alvo));
                        inputHandler.clear();
                    }
                    else {  // Alvo invalido
                        System.out.println("Opcao invalida, tente novamente\n");
                        inputHandler.pressEnter();
                        inputHandler.clear();
                    }
                }
                else {
                    System.out.println("Energia insuficiente.");
                    inputHandler.pressEnter();
                    inputHandler.clear();
                }

            }
            else if (opcao == heroi.tamDeck()){
                for (Inimigo inimigo : listaInimigos) {
                    inimigo.resetarRound();
                    inimigo.atualizarEfeito("fimRound");
                }

                listaInimigos.removeIf(inimigo -> !inimigo.estaVivo());
                
                heroi.atualizarEfeito("fimRound");
                
                System.out.printf(ANSI_RED);
                for (Inimigo inimigo : listaInimigos) {
                    inimigo.usarCartas(heroi);
                    inputHandler.sleep(0.4);
                    System.out.println();
                }
                System.out.printf(ANSI_RESET);
                
                inputHandler.pressEnter();
                inputHandler.clear();
                
                heroi.resetarRound();
            }
            else {
                System.out.println("Opcao invalida, tente novamente\n");
                inputHandler.pressEnter();
                inputHandler.clear();
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
