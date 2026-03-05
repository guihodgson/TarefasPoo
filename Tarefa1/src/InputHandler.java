import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    // Atributos

    private Scanner in;

    // Constructor

    public InputHandler() {
        in = new Scanner(System.in);
    }

    public void pressEnter() {
        System.out.println("Pressione Enter para continuar");
        in.nextLine();
    }

    public int selecionar(ArrayList<String> listaOpcoes) {
        for(int i = 1; i < listaOpcoes.size(); i++) {
            System.out.println(i + ": " + listaOpcoes.get(i));
        }
        System.out.println("----------\n");
        int resposta = in.nextInt();
        in.nextLine();  // Limpando o \n do buffer
        return resposta;
    }
}
