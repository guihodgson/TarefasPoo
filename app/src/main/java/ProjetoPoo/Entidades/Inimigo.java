package ProjetoPoo.Entidades;
import ProjetoPoo.Cartas.Baralho;
import ProjetoPoo.Cartas.Carta;
import ProjetoPoo.Cartas.CartaDano;
import ProjetoPoo.Cartas.CartaEfeito;
import ProjetoPoo.Cartas.CartaEscudo;
import ProjetoPoo.Cor;
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

    public void printarProxAcao() {

        if (baralho.mostrarPrimeiraCarta() instanceof CartaDano cartadano) {
            System.out.println(Cor.formataCor(Cor.VERMELHO_CLARO, ">>> AVISO: ") + nome + " vai usar " + cartadano.getNome() + " (" + cartadano.getAtaque() + " de dano, " + cartadano.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEscudo cartaescudo) {
            System.out.println(Cor.formataCor(Cor.VERMELHO_CLARO, ">>> AVISO: ") + nome + " vai usar " + cartaescudo.getNome() + " (" + cartaescudo.getDefesa() + " de escudo, " + cartaescudo.getDescricao() + ")");
        }
        if (baralho.mostrarPrimeiraCarta() instanceof CartaEfeito cartaEfeito) {
            if (cartaEfeito.getEfeito() instanceof EfeitoVeneno EfeitoVeneno) {
                System.out.println(Cor.formataCor(Cor.VERMELHO_CLARO, ">>> AVISO: ") + nome + " vai usar " + cartaEfeito.getNome() + " (" + EfeitoVeneno.getDuracao() + " de veneno, " + cartaEfeito.getDescricao() + ")");
            }
            if (cartaEfeito.getEfeito() instanceof EfeitoVulneravel EfeitoVulneravel) {
                System.out.println(Cor.formataCor(Cor.VERMELHO_CLARO, ">>> AVISO: ") + nome + " vai usar " + cartaEfeito.getNome() + " (+" + EfeitoVulneravel.getValor() + "% de dano recebido, " + cartaEfeito.getDescricao() + ")");
            }
            if (cartaEfeito.getEfeito() instanceof EfeitoEnfraquecido EfeitoEnfraquecido) {
                System.out.println(Cor.formataCor(Cor.VERMELHO_CLARO, ">>> AVISO: ") + nome + " vai usar " + cartaEfeito.getNome() + " (-" + EfeitoEnfraquecido.getValor() + "% de dano causado, " + cartaEfeito.getDescricao() + ")");
            }
        }
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