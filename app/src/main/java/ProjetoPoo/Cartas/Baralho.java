package ProjetoPoo.Cartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import ProjetoPoo.Cor;
import ProjetoPoo.Efeitos.EfeitoVeneno;

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

    public ArrayList<String> mostrarBaralho() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < baralho.size(); i++) {
            String nome = baralho.get(i).getNome();
            nome = String.format("%-45s", nome);

            if (baralho.get(i) instanceof CartaDano) {
                nome = Cor.formataCor(Cor.VERMELHO_CLARO, nome);
            }
            else if (baralho.get(i) instanceof CartaEscudo) {
                nome = Cor.formataCor(Cor.AZUL_CLARO, nome);
            }
            else if (baralho.get(i) instanceof CartaEfeito cartaEfeito && cartaEfeito.getEfeito() instanceof EfeitoVeneno) {
                nome = Cor.formataCor(Cor.VERDE_CLARO, nome);
            }
            else if (baralho.get(i) instanceof CartaEfeito) {
                nome = Cor.formataCor(Cor.AMARELO_CLARO, nome);
            }
            else if (baralho.get(i) instanceof CartaCura) {
                nome = Cor.formataCor(Cor.VERDE_CLARO, nome);
            }

            int custo = baralho.get(i).getCusto();
            String descricao = baralho.get(i).getDescricao();
            String linhaFormatada = String.format("%s | Custo: %2d | %s", nome, custo, descricao);

            lista.add(linhaFormatada);
        }
        return lista;
    }
}
