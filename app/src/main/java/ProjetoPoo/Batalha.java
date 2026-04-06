package ProjetoPoo;

import java.util.ArrayList;

import ProjetoPoo.Cartas.*;
import ProjetoPoo.Entidades.*;

public class Batalha {

    private static String montarStatus(Entidade entidade) {
        double statusVida = ((double) entidade.getVida()) / ((double) entidade.getVidaMax());

        String barraVida = "█";
        String barraSemVida = "";

        for (int i = 0; i < (int) (statusVida * 10); i++) {
            barraVida += "█";
        }

        for (int i = 0; i < 10 - (int) (statusVida * 10); i++) {
            barraSemVida += "█";
        }

        if (statusVida > 0.7) {
            barraVida = Cor.formataCor(Cor.VERDE, barraVida);
            barraSemVida = Cor.formataCor(Cor.VERDE_ESCURO, barraSemVida);
            barraVida += barraSemVida;
        }
        else if (statusVida > 0.4) {
            barraVida = Cor.formataCor(Cor.AMARELO, barraVida);
            barraSemVida = Cor.formataCor(Cor.AMARELO_ESCURO, barraSemVida);
            barraVida += barraSemVida;
        }
        else {
            barraVida = Cor.formataCor(Cor.VERMELHO, barraVida);
            barraSemVida = Cor.formataCor(Cor.VERMELHO_ESCURO, barraSemVida);
            barraVida += barraSemVida;
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


            Cor.imprimeAnsi(Cor.AMARELO, "===================================8===================================");
            inputHandler.sleep(0.4);
            System.out.println("HEROI: " + Cor.formataCor(Cor.AMARELO, heroi.getNome()));
            System.out.println(montarStatus(heroi));
            inputHandler.sleep(0.4);
            for (Inimigo vilao : listaInimigos) {
                Cor.imprimeAnsi(Cor.AMARELO, "------------------------------------------------------------");
                inputHandler.sleep(0.4);
                System.out.println("INIMIGO " + (listaInimigos.indexOf(vilao) + 1) + ": " + Cor.formataCor(Cor.VERMELHO, vilao.getNome()));
                System.out.println(montarStatus(vilao));
                
                vilao.printarProxAcao();
                inputHandler.sleep(0.4);
            }
            Cor.imprimeAnsi(Cor.AMARELO, "===================================8===================================");
            System.out.println();
            

            inputHandler.sleep(0.4);

            double statusEnergia = ((double) heroi.getEnergia()) / ((double) heroi.getEnergiaMax());
            if (statusEnergia >= 0.8) {
                Cor.imprimeAnsi(Cor.VERDE, heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");
            }
            else if (statusEnergia >= 0.4) {
                Cor.imprimeAnsi(Cor.AMARELO, heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");
            }
            else {
                Cor.imprimeAnsi(Cor.VERMELHO, heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");
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
