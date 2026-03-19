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
        return selecionar(listaOpcoes, false);
    }

    public int selecionar(ArrayList<String> listaOpcoes, boolean mostrarEncerrar) {
        for(int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + ": " + listaOpcoes.get(i));
        }
        if (mostrarEncerrar) {
            System.out.println("[" + (listaOpcoes.size() + 1) + "]" + ": Encerrar Turno.");
        }

        System.out.println("----------\nEscolha uma opcao:");
        int resposta;

        try {
            resposta = in.nextInt();
        } 
        catch (Exception e) {
            resposta = -1;
        }

        in.nextLine();  // Limpando o \n do buffer
        System.out.println();
        return resposta - 1;
    }
}
