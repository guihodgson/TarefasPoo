package ProjetoPoo.Cartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import ProjetoPoo.Cor;
import ProjetoPoo.Efeitos.EfeitoBonusDano;
import ProjetoPoo.Efeitos.EfeitoCura;
import ProjetoPoo.Efeitos.EfeitoEnfraquecido;
import ProjetoPoo.Efeitos.EfeitoVeneno;
import ProjetoPoo.Efeitos.EfeitoVulneravel;

public class Baralho {

    // Atributos

    private Stack<Carta> baralho;

    // Contructor

    public Baralho() {
        baralho = new Stack<>();
    }

    // Metodos

    public int tamanho() {
        return baralho.size();
    }

    public Carta retirarCarta() {
        return baralho.pop();
    }

    public Carta retirarCartaN(int n) {
        return baralho.remove(n);
    }

    public Carta mostrarPrimeiraCarta() {
        return baralho.lastElement();
    }

    public Carta mostrarCartaN(int n) {
        return baralho.get(n);
    }

    public void adicionarCarta(Carta adicionada) {
        baralho.add(adicionada);
    }

    public void embaralhar() {
        Collections.shuffle(baralho);
    }

    public boolean vazio() {
        return baralho.empty();
    }

    public int cartasRestantes() {
        return baralho.size();
    }

    public void transferirCartas(Baralho baralho2) {
        while (!this.vazio()) {
            baralho2.adicionarCarta(this.retirarCarta());
        }
    }

    public void transferirNCartas(Baralho baralho2, int n) {
        for (int i = 0; i < n; i++) {
            baralho2.adicionarCarta(this.retirarCarta());
        }
    }

    /**
     * Retorna um arraylist na forma de Nome | Custo | Descricao.
     * @return
     */
    public ArrayList<String> mostrarBaralho() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < baralho.size(); i++) {
            String nome = baralho.get(i).getNome();
            
            if (baralho.get(i) instanceof CartaDano cartaDano && cartaDano.getAlvo() == AlvoCarta.UM_ALVO) {
                nome += " (Dano: " + cartaDano.getAtaque()+ ")";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.VERMELHO_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaDano cartaDano && cartaDano.getAlvo() == AlvoCarta.GLOBAL) {
                nome += " (Dano Global: " + cartaDano.getAtaque() + ")";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.VERMELHO_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaDanoComEfeito cartaDanoComEfeito) {
                nome += " (Dano: " + cartaDanoComEfeito.getAtaque() + ", Efeito: " + cartaDanoComEfeito.getEfeito().getTipo() + " por " + cartaDanoComEfeito.getEfeito().getDuracao() + " rounds)";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.VERMELHO_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEscudo cartaEscudo) {
                nome += " (Escudo: " + cartaEscudo.getDefesa() + ")";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.AZUL_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoVeneno efeitoVeneno) {
                nome += " (Veneno: " + efeitoVeneno.getDuracao() + " rounds)";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.VERDE_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoCura efeitoCura) {
                nome += " (Cura: " + efeitoCura.getValor() + ")";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.VERDE_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoBonusDano efeitoBonusDano) {
                nome += " (Bonus de Dano: " + efeitoBonusDano.getValor() + ")";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.AMARELO_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoEnfraquecido efeitoEnfraquecido) {
                nome += " (Enfraquecido: -" + efeitoEnfraquecido.getValor() + "% dano causado)";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.AMARELO_CLARO, nome);
            }

            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoVulneravel efeitoVulneravel) {
                nome += " (Vulneravel: +" + efeitoVulneravel.getValor() + "% dano recebido)";
                nome = String.format("%-45s", nome);
                nome = Cor.formataCor(Cor.AMARELO_CLARO, nome);
            }

            else {
                nome = String.format("%-45s", nome);
            }

            nome = String.format("%-45s", nome);

            int custo = baralho.get(i).getCusto();
            String descricao = baralho.get(i).getDescricao();
            String linhaFormatada = String.format("%s | Custo: %2d | %s", nome, custo, descricao);

            lista.add(linhaFormatada);
        }
        return lista;
    }
}
