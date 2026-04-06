package ProjetoPoo;
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

    public void sleep(double segundos) {
        try {
            Thread.sleep((int)(segundos * 1000));
        } catch (Exception e) {
        }
    }

    public void clear() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public int selecionar(ArrayList<String> listaOpcoes) {
        return selecionar(listaOpcoes, false);
    }

    public int selecionar(ArrayList<String> listaOpcoes, boolean mostrarEncerrar) {
        for(int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println(Cor.AMARELO.getCodigo() + "[" + (i + 1) + "]" + Cor.RESET.getCodigo() + ": " + listaOpcoes.get(i));
            sleep(0.1);
        }
        if (mostrarEncerrar) {
            System.out.println(Cor.AMARELO.getCodigo() + "[" + (listaOpcoes.size() + 1) + "]" + Cor.RESET.getCodigo() + Cor.CINZA_ESCURO.getCodigo() + ": Encerrar Turno." + Cor.RESET.getCodigo());
        }
        sleep(0.1);

        System.out.println("----------");
        sleep(0.1);

        System.out.println("Escolha uma opcao:");
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
