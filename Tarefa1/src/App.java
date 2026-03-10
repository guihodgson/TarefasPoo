
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Heroi heroi = new Heroi("Po, o Dragao Guerreiro", 40, 0, 4);
        CartaDano cartaDano = new CartaDano("CartaDano", 2, 4);
        CartaEscudo cartaEscudo = new CartaEscudo("CartaEscudo", 2, 4);
        InputHandler inputHandler = new InputHandler();
        Random gerador = new Random();

        ArrayList<String> opcoesCartas = new ArrayList<>();
        opcoesCartas.add("Posicao 0 invalida");
        opcoesCartas.add("Carta Dano " + cartaDano.getAtaque() + " (" + cartaDano.getCusto() + " de energia)");
        opcoesCartas.add("Carta Escudo " + cartaEscudo.getDefesa() + " (" + cartaEscudo.getCusto() + " de energia)");
        opcoesCartas.add("Encerrar Turno");


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
        opcoesFilme.add("Posicao 0 invalida");
        opcoesFilme.add("Filme 1");
        opcoesFilme.add("Filme 2");
        opcoesFilme.add("Filme 3");

        System.out.println("Selecione o filme que você quer jogar:");
        int filmeEscolhido = inputHandler.selecionar(opcoesFilme);
        Inimigo inimigo;

        if (filmeEscolhido == 2) {
            inimigo = new Inimigo("Lord Shen", 32, 0, 7);
        }
        else if (filmeEscolhido == 3) {
            inimigo = new Inimigo("Kai", 36, 0, 9);
        }
        else {
            inimigo = new Inimigo("Tai Lung", 34, 0, 8);
        }

        inputHandler.pressEnter();

        do {
            System.out.println(heroi.getNome() + ": (" + heroi.getVida() + "/" + heroi.getVidaMax() + " HP) (" + heroi.getEscudo() + " de escudo.)");
            System.out.println("--- VS ---");
            System.out.println(inimigo.getNome() + ": (" + inimigo.getVida() + "/" + inimigo.getVidaMax() + " HP)");
            System.out.println();

            System.out.println(heroi.getEnergia() + "/" + heroi.getEnergiaMax() + " de Energia restantes.");

            int opcao = inputHandler.selecionar(opcoesCartas);

            if (opcao == 1) {
                if (heroi.podeGastarEnergia(cartaDano.getCusto())) {
                    cartaDano.usarAtaque(inimigo);
                }
                else {
                    System.out.println("Energia insuficiente.\n");
                    inputHandler.pressEnter();
                }
                continue;
            }

            if (opcao == 2) {
                if (heroi.podeGastarEnergia(cartaEscudo.getCusto())) {
                    cartaEscudo.usarEscudo(heroi);
                }
                else {
                    System.out.println("Energia insuficiente.\n");
                    inputHandler.pressEnter();
                }
                continue;
            }

            if (opcao == 3) {
                inimigo.atacar(heroi);
                System.out.println(inimigo.getNome() + " atacou e causou " + (((inimigo.getDanoBase() - heroi.getEscudo()) >= 0) ? inimigo.getDanoBase() - heroi.getEscudo() : 0) + " de dano.");
                heroi.resetRound();
                inputHandler.pressEnter();
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
