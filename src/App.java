import Cartas.Carta;
import Cartas.CartaBuffDano;
import Cartas.CartaDano;
import Cartas.CartaEscudo;
import Entidades.Heroi;
import Entidades.Inimigo;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 32, 0, 5);

        // Baralho Po

        CartaDano cartaSkidoosh = new CartaDano("Skidoosh (12)", "MuchoDano", 5, 12);
        CartaDano cartaDanoMed = new CartaDano("Ataque medio (5)", "MuchoDano", 2, 5);
        CartaDano cartaDanoPeq = new CartaDano("Ataque leve (2)", "lala", 1, 2);

        CartaEscudo cartaEscudoGrnd = new CartaEscudo("Escudo Grande (9)", "Aiaiai", 4, 9);
        CartaEscudo cartaEscudoMed = new CartaEscudo("Escudo Medio (4)", "Aiaiai", 2, 4);
        CartaEscudo cartaEscudoPeq = new CartaEscudo("Escudo Pequeno (2)", "Aiaiai", 1, 2);

        CartaBuffDano cartaBuffPeq = new CartaBuffDano("Bonus de Ataque Pequeno (1 por 2 rounds)", "danodano", 2, 2, 2);
        CartaBuffDano cartaBuffMed = new CartaBuffDano("Bonus de Ataque Medio (2 por 2 rounds)", "danodano", 3, 4, 2);
        

        InputHandler inputHandler = new InputHandler();
        Random gerador = new Random();

        heroi.adicionarCartaBaralho(cartaDanoMed, 4);
        heroi.adicionarCartaBaralho(cartaDanoPeq, 3);
        heroi.adicionarCartaBaralho(cartaSkidoosh, 2);

        heroi.adicionarCartaBaralho(cartaEscudoPeq, 2);
        heroi.adicionarCartaBaralho(cartaEscudoMed, 3);
        heroi.adicionarCartaBaralho(cartaEscudoGrnd, 2);

        heroi.adicionarCartaBaralho(cartaBuffPeq, 2);
        heroi.adicionarCartaBaralho(cartaBuffMed, 2);

        heroi.deckInicial();

        // Titulos

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

        int filmeEscolhido;

        do {
            System.out.println("Selecione o filme que você quer jogar:");
            filmeEscolhido = inputHandler.selecionar(opcoesFilme);
        } while (filmeEscolhido > 2 || filmeEscolhido < 0);
        Inimigo inimigo;

        // Baralho do inimigo

        switch (filmeEscolhido) {
            case 0 -> {
                inimigo = new Inimigo("Tai Lung", 34, 0, 1);
                CartaDano ataqueTaiPeq = new CartaDano("Investida", null, 1, 7);
                CartaDano ataqueTaiForte = new CartaDano("Chute da Pantera", null, 1, 14);

                CartaEscudo escudoTaiMed = new CartaEscudo("Escudo medio", null, 1, 6);

                inimigo.adicionarCarta(escudoTaiMed, 1);
                inimigo.adicionarCarta(ataqueTaiPeq, 4);
                inimigo.adicionarCarta(ataqueTaiForte, 3);
            }
            case 1 -> {
                inimigo = new Inimigo("Lord Shen", 32, 0, 1);
                CartaDano ataqueShenPeq = new CartaDano("Investida", null, 1, 8);
                CartaDano ataqueShenForte = new CartaDano("Canhao Dragao", null, 1, 14);

                CartaEscudo escudoShenMed = new CartaEscudo("Escudo medio", null, 1, 5);

                inimigo.adicionarCarta(escudoShenMed, 1);
                inimigo.adicionarCarta(ataqueShenPeq, 4);
                inimigo.adicionarCarta(ataqueShenForte, 3);
            }
            case 2 -> {
                inimigo = new Inimigo("Kai", 36, 0, 1);
                CartaDano ataqueKaiPeq = new CartaDano("Investida", null, 1, 8);
                CartaDano ataqueKaiForte = new CartaDano("Espada Espiritual", null, 1, 16);

                CartaEscudo escudoKaiMed = new CartaEscudo("Escudo medio", null, 1, 6);

                inimigo.adicionarCarta(escudoKaiMed, 1);
                inimigo.adicionarCarta(ataqueKaiPeq, 4);
                inimigo.adicionarCarta(ataqueKaiForte, 3);
            }
            default -> {
                throw new AssertionError();
            }
        }

        inimigo.embaralharMao();

        // Logica de batalha

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(inimigo.getNome() + ": (" + inimigo.getVida() + "/" + inimigo.getVidaMax() + " HP) (" + inimigo.getEscudo() + " de escudo.)");
            System.out.println();

            inimigo.printarProxAcao();
            System.out.println();

            if (heroi.getTempoBuff() > 0) {
                System.out.println("Po possui " + heroi.getBuffDano() + " de dano extra por mais " + heroi.getTempoBuff() + " round(s)\n");
            }

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(heroi.mostrarDeck(), true);

            if (opcao < heroi.tamDeck() && opcao >= 0) {  // Nao quer passar de turno ainda
                Carta escolhida = heroi.getCartaNDeck(opcao);

                if (heroi.podeGastarEnergia(escolhida.getCusto())) {
                    heroi.usarCartaNDeck(opcao, inimigo);
                }
                else {
                    System.out.println("Energia insuficiente.");
                    inputHandler.pressEnter();
                }

            }
            else if (opcao == heroi.tamDeck()){
                inimigo.resetarRound();
                inimigo.usarCartas(heroi);
                inputHandler.pressEnter();

                heroi.resetarRound();
            }
            else {
                System.out.println("Opcao invalida, tente novamente\n");
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