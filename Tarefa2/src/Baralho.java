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


}
