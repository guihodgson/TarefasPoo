package ProjetoPoo.Entidades;
import ProjetoPoo.Cartas.Baralho;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Cor;
import ProjetoPoo.InputHandler;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;

public class Inimigo extends Entidade {

    // Atributos

    private TipoInimigo tipo;
    private final Baralho baralho;

    // Constructor

    public Inimigo(String nome, int vida, int escudo, int energia, TipoInimigo tipo) {
        super(nome, vida, escudo);
        this.energia = energiaMax = energia;
        this.tipo = tipo;
        baralho = new Baralho();
    }

    // Getters

    public TipoInimigo getTipo() {
        return tipo;
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

    public String stringProxAcao() {

        if (baralho.mostrarPrimeiraCarta() instanceof CartaDano cartadano) {
            return nome + " vai usar " + cartadano.getNome() + " (" + cartadano.getAtaque() + " de dano)";
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEscudo cartaescudo) {
            return nome + " vai usar " + cartaescudo.getNome() + " (" + cartaescudo.getDefesa() + " de escudo)";
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEfeito cartaEfeito) {
            if (cartaEfeito.getEfeito() instanceof EfeitoVeneno EfeitoVeneno) {
                return nome + " vai usar " + cartaEfeito.getNome() + " (" + EfeitoVeneno.getDuracao() + " de veneno)";
            }
            if (cartaEfeito.getEfeito() instanceof EfeitoVulneravel EfeitoVulneravel) {
                return nome + " vai usar " + cartaEfeito.getNome() + " (+" + EfeitoVulneravel.getValor() + "% de dano recebido)";
            }
            if (cartaEfeito.getEfeito() instanceof EfeitoEnfraquecido EfeitoEnfraquecido) {
                return nome + " vai usar " + cartaEfeito.getNome() + " (-" + EfeitoEnfraquecido.getValor() + "% de dano causado)";
            }
        }
        return "";
    }

    public void usarCartas(Heroi heroi) {
        while (true) { 
            Carta acao = baralho.retirarCarta();
            baralho.adicionarCarta(acao);
            if (acao instanceof CartaDano cartaDano) {
                if (this.podeGastarEnergia(acao.getCusto())) {
                    this.gastarEnergia(acao.getCusto());
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
                    this.gastarEnergia(acao.getCusto());
                    acao.usar(this, heroi);
                    System.out.println(nome + " usou o movimento " + acao.getNome() + " e ganhou " + cartaEscudo.getDefesa() + " de escudo.");
                }
                else {
                    baralho.embaralhar();
                    break;
                }
            }

            if (acao instanceof CartaEfeito cartaEfeito) {
                if (cartaEfeito.getEfeito() instanceof EfeitoVeneno cartaVeneno) {
                    if (this.podeGastarEnergia(acao.getCusto())) {
                        this.gastarEnergia(acao.getCusto());
                        acao.usar(this, heroi);
                        System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou " + cartaVeneno.getValor() + " de veneno.");
                    }
                    else {
                        baralho.embaralhar();
                        break;
                    }
                }
                if (cartaEfeito.getEfeito() instanceof EfeitoVulneravel cartaVulneravel) {
                    if (this.podeGastarEnergia(acao.getCusto())) {
                        this.gastarEnergia(acao.getCusto());
                        acao.usar(this, heroi);
                        System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou +" + cartaVulneravel.getValor() + "% de dano recebido.");
                    }
                    else {
                        baralho.embaralhar();
                        break;
                    }
                }
                if (cartaEfeito.getEfeito() instanceof EfeitoEnfraquecido cartaEnfraquecido) {
                    if (this.podeGastarEnergia(acao.getCusto())) {
                        this.gastarEnergia(acao.getCusto());
                        acao.usar(this, heroi);
                        System.out.println(nome + " usou o movimento " + acao.getNome() + " e aplicou -" + cartaEnfraquecido.getValor() + "% de dano causado.");
                    }
                    else {
                        baralho.embaralhar();
                        break;
                    }
                }
            }
        }
    }

    public void resetarRound() {
        energia = energiaMax;
        escudo = 0;
    }

}