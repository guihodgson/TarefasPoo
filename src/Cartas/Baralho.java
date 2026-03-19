package Cartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

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
            lista.add(baralho.get(i).getNome() + " (Custo: " + baralho.get(i).getCusto() + ") (Descrição: " + baralho.get(i).getDescricao() + ")");
        }
        return lista;
    }

}
