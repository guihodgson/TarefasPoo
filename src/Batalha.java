
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

    private static String montarStatus(Entidade entidade) {
        String status = "HP: " + entidade.getVida() + "/" + entidade.getVidaMax() + " | Escudo: " + entidade.getEscudo();

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


            System.out.println("===================================8===================================");
            System.out.println("HEROI: " + heroi.getNome());
            System.out.println(montarStatus(heroi));
            for (Inimigo vilao : listaInimigos) {
                System.out.println("------------------------------------------------------------");
                System.out.println("INIMIGO " + (listaInimigos.indexOf(vilao) + 1) + ": " + vilao.getNome());
                System.out.println(montarStatus(vilao));
                
                inputHandler.sleep(0.6);
                vilao.printarProxAcao();
            }
            System.out.println("===================================8===================================");
            System.out.println();
            

            inputHandler.sleep(0.6);

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

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
                    inimigo.usarCartas(heroi);
                    inputHandler.sleep(0.2);
                    
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
