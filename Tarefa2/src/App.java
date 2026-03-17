import Cartas.Carta;
import Cartas.CartaDano;
import Cartas.CartaEscudo;
import Entidades.Heroi;
import Entidades.Inimigo;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 40, 0, 5);

        CartaDano cartaSkidoosh = new CartaDano("Skidoosh (12)", "MuchoDano", 5, 12);
        CartaDano cartaDanoMed = new CartaDano("Ataque medio (5)", "MuchoDano", 2, 4);
        CartaDano cartaDanoPeq = new CartaDano("Ataque leve (2)", "lala", 1, 6);

        CartaEscudo cartaEscudoGrnd = new CartaEscudo("Escudo Grande (9)", "Aiaiai", 4, 9);
        CartaEscudo cartaEscudoMed = new CartaEscudo("Escudo Medio (4)", "Aiaiai", 2, 4);
        CartaEscudo cartaEscudoPeq = new CartaEscudo("Escudo Pequeno (2)", "Aiaiai", 1, 2);

        InputHandler inputHandler = new InputHandler();
        Random gerador = new Random();

        heroi.adicionarCartaBaralho(cartaDanoMed);
        heroi.adicionarCartaBaralho(cartaDanoPeq);
        heroi.adicionarCartaBaralho(cartaDanoPeq);
        heroi.adicionarCartaBaralho(cartaSkidoosh);
        heroi.adicionarCartaBaralho(cartaEscudoPeq);
        heroi.adicionarCartaBaralho(cartaEscudoPeq);
        heroi.adicionarCartaBaralho(cartaEscudoMed);
        heroi.adicionarCartaBaralho(cartaEscudoMed);
        heroi.adicionarCartaBaralho(cartaEscudoGrnd);
        heroi.adicionarCartaBaralho(cartaEscudoGrnd);

        heroi.deckInicial();

        ArrayList<String> titulo = new ArrayList<>();
        
        titulo.add("""
                                                                                                                                    
▄▄▄▄▄▄   ▄▄▄▄▄▄▄     ▄▄▄▄    ▄▄▄▄▄▄▄    ▄▄▄▄▄   ▄▄▄    ▄▄▄   ▄▄▄▄  ▄▄▄  ▄▄▄▄   ▄▄▄▄   ▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄   ▄▄▄▄▄   ▄▄▄▄▄   ▄▄▄▄▄▄▄   
███▀▀██▄ ███▀▀███▄ ▄██▀▀██▄ ███▀▀▀▀▀  ▄███████▄ ████▄  ███   ▀███  ███  ███▀ ▄██▀▀██▄ ███▀▀███▄ ███▀▀███▄  ███  ▄███████▄ ███▀▀███▄ 
███  ███ ███▄▄███▀ ███  ███ ███       ███   ███ ███▀██▄███    ███  ███  ███  ███  ███ ███▄▄███▀ ███▄▄███▀  ███  ███   ███ ███▄▄███▀ 
███  ███ ███▀▀██▄  ███▀▀███ ███  ███▀ ███▄▄▄███ ███  ▀████    ███▄▄███▄▄███  ███▀▀███ ███▀▀██▄  ███▀▀██▄   ███  ███▄▄▄███ ███▀▀██▄  
██████▀  ███  ▀███ ███  ███ ▀██████▀   ▀█████▀  ███    ███     ▀████▀████▀   ███  ███ ███  ▀███ ███  ▀███ ▄███▄  ▀█████▀  ███  ▀███ 
                                                                                                                                    
                                                                                                                                    
        """); 

        titulo.add("""
                                                                                                                                                
  ▄▄▄▄▄▄     ▄▄▄▄▄▄        ▄▄    ▄   ▄▄▄▄    ▄▄▄▄     ▄▄     ▄▄▄     ▄▄▄              ▄▄      ▄▄▄▄▄▄     ▄▄▄▄▄▄     ▄▄▄▄▄▄   ▄▄▄▄      ▄▄▄▄▄▄   
 █▀██▀▀██   █▀██▀▀▀█▄    ▄█▀▀█▄  ▀██████▀  ▄█▀▀████▄  ██▄   ██▀     █▀██  ██  ██▀▀  ▄█▀▀█▄   █▀██▀▀▀█▄  █▀██▀▀▀█▄  █▀ ██   ▄█▀▀████▄  █▀██▀▀▀█▄ 
   ██   ██    ██▄▄▄█▀    ██  ██    ██   ▄  ██    ██   ███▄  ██        ██  ██  ██    ██  ██     ██▄▄▄█▀    ██▄▄▄█▀     ██   ██    ██     ██▄▄▄█▀ 
   ██   ██    ██▀▀█▄     ██▀▀██    ██  ██  ██    ██   ██ ▀█▄██        ██  ██  ██    ██▀▀██     ██▀▀█▄     ██▀▀█▄      ██   ██    ██     ██▀▀█▄  
 ▄ ██   ██  ▄ ██  ██   ▄ ██  ██    ██  ██  ██    ██   ██   ▀██        ██▄ ██▄ ██  ▄ ██  ██   ▄ ██  ██   ▄ ██  ██      ██   ██    ██   ▄ ██  ██  
 ▀██▀███▀   ▀██▀  ▀██▀ ▀██▀  ▀█▄█  ▀█████   ▀████▀  ▀██▀    ██        ▀████▀███▀  ▀██▀  ▀█▄█ ▀██▀  ▀██▀ ▀██▀  ▀██▀  ▄▄██▄▄  ▀████▀    ▀██▀  ▀██▀
                                   ▄   ██                                                                                                       
                                   ▀████▀                                                                                                       
        """); 

        titulo.add("""

████████▄     ▄████████    ▄████████    ▄██████▄   ▄██████▄  ███▄▄▄▄         ▄█     █▄     ▄████████    ▄████████    ▄████████  ▄█   ▄██████▄     ▄████████ 
███   ▀███   ███    ███   ███    ███   ███    ███ ███    ███ ███▀▀▀██▄      ███     ███   ███    ███   ███    ███   ███    ███ ███  ███    ███   ███    ███ 
███    ███   ███    ███   ███    ███   ███    █▀  ███    ███ ███   ███      ███     ███   ███    ███   ███    ███   ███    ███ ███▌ ███    ███   ███    ███ 
███    ███  ▄███▄▄▄▄██▀   ███    ███  ▄███        ███    ███ ███   ███      ███     ███   ███    ███  ▄███▄▄▄▄██▀  ▄███▄▄▄▄██▀ ███▌ ███    ███  ▄███▄▄▄▄██▀ 
███    ███ ▀▀███▀▀▀▀▀   ▀███████████ ▀▀███ ████▄  ███    ███ ███   ███      ███     ███ ▀███████████ ▀▀███▀▀▀▀▀   ▀▀███▀▀▀▀▀   ███▌ ███    ███ ▀▀███▀▀▀▀▀   
███    ███ ▀███████████   ███    ███   ███    ███ ███    ███ ███   ███      ███     ███   ███    ███ ▀███████████ ▀███████████ ███  ███    ███ ▀███████████ 
███   ▄███   ███    ███   ███    ███   ███    ███ ███    ███ ███   ███      ███ ▄█▄ ███   ███    ███   ███    ███   ███    ███ ███  ███    ███   ███    ███ 
████████▀    ███    ███   ███    █▀    ████████▀   ▀██████▀   ▀█   █▀        ▀███▀███▀    ███    █▀    ███    ███   ███    ███ █▀    ▀██████▀    ███    ███ 
             ███    ███                                                                                ███    ███   ███    ███                   ███    ███ 
        """); 

        System.out.println(titulo.get(gerador.nextInt(titulo.size())));

        ArrayList<String> opcoesFilme = new ArrayList<>();
        opcoesFilme.add("Filme 1");
        opcoesFilme.add("Filme 2");
        opcoesFilme.add("Filme 3");

        System.out.println("Selecione o filme que você quer jogar:");
        int filmeEscolhido = inputHandler.selecionar(opcoesFilme);
        Inimigo inimigo;

        if (filmeEscolhido == 1) {
            inimigo = new Inimigo("Lord Shen", 32, 0, 1);
            CartaDano ataqueShenPeq = new CartaDano("Investida", null, 1, 4);
            CartaDano ataqueShenForte = new CartaDano("Canhao Dragao", null, 1, 12);

            CartaEscudo escudoShenPeq = new CartaEscudo("Escudo leve", null, 1, 2);
            CartaEscudo escudoShenMed = new CartaEscudo("Escudo medio", null, 1, 4);

            inimigo.adicionarCarta(escudoShenPeq);
            inimigo.adicionarCarta(escudoShenMed);

            inimigo.adicionarCarta(ataqueShenPeq);
            inimigo.adicionarCarta(ataqueShenPeq);
            inimigo.adicionarCarta(ataqueShenForte);
        }
        else if (filmeEscolhido == 2) {
            inimigo = new Inimigo("Kai", 36, 0, 1);
            CartaDano ataqueKaiPeq = new CartaDano("Investida", null, 1, 4);
            CartaDano ataqueKaiForte = new CartaDano("Espada Espiritual", null, 1, 14);

            CartaEscudo escudoKaiPeq = new CartaEscudo("Escudo leve", null, 1, 2);
            CartaEscudo escudoKaiMed = new CartaEscudo("Escudo medio", null, 1, 4);

            inimigo.adicionarCarta(escudoKaiPeq);
            inimigo.adicionarCarta(escudoKaiMed);

            inimigo.adicionarCarta(ataqueKaiPeq);
            inimigo.adicionarCarta(ataqueKaiPeq);
            inimigo.adicionarCarta(ataqueKaiForte);
        }
        else {
            inimigo = new Inimigo("Tai Lung", 34, 0, 1);
            CartaDano ataqueTaiPeq = new CartaDano("Investida", null, 1, 4);
            CartaDano ataqueTaiForte = new CartaDano("Chute da Pantera", null, 1, 13);

            CartaEscudo escudoTaiPeq = new CartaEscudo("Escudo leve", null, 1, 2);
            CartaEscudo escudoTaiMed = new CartaEscudo("Escudo medio", null, 1, 4);

            inimigo.adicionarCarta(escudoTaiPeq);
            inimigo.adicionarCarta(escudoTaiMed);

            inimigo.adicionarCarta(ataqueTaiPeq);
            inimigo.adicionarCarta(ataqueTaiPeq);
            inimigo.adicionarCarta(ataqueTaiForte);
        }
        inimigo.embaralhaMao();

        inputHandler.pressEnter();

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(inimigo.getNome() + ": (" + inimigo.getVida() + "/" + inimigo.getVidaMax() + " HP) (" + inimigo.getEscudo() + " de escudo.)");
            System.out.println();

            inimigo.printarProxAcao();
            System.out.println();

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), true);

            if (opcao < heroi.tamDeck()) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (escolhida instanceof CartaDano) {
                    if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                        heroi.usarCartaNDeck(opcao, inimigo);
                    }
                    else {
                        System.out.println("Energia insuficiente.");
                        inputHandler.pressEnter();
                    }
                }
                else if (escolhida instanceof CartaEscudo) {
                    if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                        heroi.usarCartaNDeck(opcao, heroi);
                    }
                    else {
                        System.out.println("Energia insuficiente.");
                        inputHandler.pressEnter();
                    }
                }
                
            }
            else {
                inimigo.resetarRound();
                inimigo.usarCartas(heroi);
                inputHandler.pressEnter();

                heroi.resetarRound();
            }
            

        } while (heroi.estaVivo() && inimigo.estaVivo());

        if (heroi.estaVivo()) {
            System.out.println("Voce GANHOU de " + inimigo.getNome() + "!!\nO mundo esta mais seguro agora.");
        }

        else {
            System.out.println("Voce MORREU, o mundo continua em trevas.");  
        }

    }
}