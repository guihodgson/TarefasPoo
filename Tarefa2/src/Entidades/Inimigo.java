package Entidades;
import Cartas.*;

public class Inimigo extends Entidade {

    // Atributos

    private Baralho baralho;

    // Constructor

    public Inimigo(String nome, int vida, int escudo, int energia) {
        super(nome, vida, escudo);
        this.energia = energiaMax = energia;
        baralho = new Baralho();
    }

    // Metodos

    public void adicionarCarta(Carta carta) {
        baralho.adicionarCarta(carta);
    }

    public void embaralhaMao() {
        baralho.embaralhar();
    }

    public void printarProxAcao() {
        System.out.println(nome + " vai usar " + baralho.mostrarPrimeiraCarta().getNome() + ".");
    }

    public void usarCartas(Heroi heroi) {
        while (true) { 
            Carta acao = baralho.retirarCarta();
            baralho.adicionarCarta(acao);
            if (acao instanceof CartaDano cartaDano) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o golpe " + acao.getNome() + " e causou " + cartaDano.getAtaque() + " de dano.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }
            if (acao instanceof CartaEscudo cartaEscudo) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e ganhou " + cartaEscudo.getDefesa() + " de escudo.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }
        }
    }

    public void resetarRound() {
        energia = energiaMax;
        escudo = 0;
    }

}