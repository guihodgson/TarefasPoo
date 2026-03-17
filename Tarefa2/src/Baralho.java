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

    public Carta retirarCarta() {
        return baralho.pop();
    }

    public Carta mostrarPrimeiraCarta() {
        return baralho.firstElement();
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

    public void mostrarBaralho() {
        for (int i = 0; i < baralho.size(); i++) {
            System.out.println((i + 1) + ": " + baralho.get(i).getNome() + "(Custo: " + baralho.get(i).getCusto() + ")");
        }
    }

}
