package Entidades;
import Cartas.*;

public class Inimigo extends Entidade {

    // Atributos

    private final Baralho baralho;

    // Constructor

    public Inimigo(String nome, int vida, int escudo, int energia) {
        super(nome, vida, escudo);
        this.energia = energiaMax = energia;
        baralho = new Baralho();
    }

    // Metodos

    public void adicionarCarta(Carta carta, int n) {
        for (int i = 0; i < n; i++) {
            baralho.adicionarCarta(carta);
        }
    }

    public void embaralharMao() {
        baralho.embaralhar();
    }

    public void printarProxAcao() {

        if (baralho.mostrarPrimeiraCarta() instanceof CartaDano cartadano) {
            System.out.println(">>> AVISO: " + nome + " vai usar " + cartadano.getNome() + " (" + cartadano.getAtaque() + " de dano, " + cartadano.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEscudo cartaescudo) {
            System.out.println(">>> AVISO: " + nome + " vai usar " + cartaescudo.getNome() + " (" + cartaescudo.getDefesa() + " de escudo, " + cartaescudo.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaVeneno cartaVeneno) {
            System.out.println(">>> AVISO: " + nome + " vai usar " + cartaVeneno.getNome() + " (" + cartaVeneno.getVeneno() + " de veneno, " + cartaVeneno.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaVulneravel cartaVulneravel) {
            System.out.println(">>> AVISO: " + nome + " vai usar " + cartaVulneravel.getNome() + " (+" + cartaVulneravel.getVulnerabilidade() + "% de dano recebido, " + cartaVulneravel.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEnfraquecido cartaEnfraquecido) {
            System.out.println(">>> AVISO: " + nome + " vai usar " + cartaEnfraquecido.getNome() + " (-" + cartaEnfraquecido.getPorcentagem() + "% de dano causado, " + cartaEnfraquecido.getDescricao() + ")");
        }
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
            if (acao instanceof CartaBonusDano cartaBonusDano) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e ganhou " + cartaBonusDano.getBonus() + " de bonus de dano.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }
            if (acao instanceof CartaVeneno cartaVeneno) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou " + cartaVeneno.getVeneno() + " de veneno.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }
            if (acao instanceof CartaVulneravel cartaVulneravel) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou +" + cartaVulneravel.getVulnerabilidade() + "% de dano recebido.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }
            if (acao instanceof CartaEnfraquecido cartaEnfraquecido) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou -" + cartaEnfraquecido.getPorcentagem() + "% de dano causado.");
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