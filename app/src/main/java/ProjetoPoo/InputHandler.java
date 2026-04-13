package ProjetoPoo;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    // Atributos

    private final Scanner in;

    // Constructor

    public InputHandler() {
        in = new Scanner(System.in);
    }

    public void pressEnter() {
        pressEnter(true, Cor.formataCor(Cor.CINZA_ESCURO, "Pressione Enter para continuar."));
    }

    public void pressEnter(boolean temTexto, String texto) {
        if (temTexto) {
            System.out.println(texto);
        }
        in.nextLine();
    }

    /**
     * Faz o terminal esperar n segundos para a proxima ação.
     * @param segundos
     */
    public static void sleep(double segundos) {
        try {
            Thread.sleep((int)(segundos * 1000));
        } catch (Exception e) {
        }
    }

    /**
     * Limpa o terminal.
     */
    public void clear() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public int selecionar(ArrayList<String> listaOpcoes, double tempo) {
        return selecionar(listaOpcoes, tempo, false, "");
    }

    /**
     * Monta uma tela de seleção para uma arryalist e retorna o indice escolhido.
     * @param listaOpcoes
     * @param tempo
     * @param opcaoVoltar
     * @param textoVoltar
     * @return
     */
    public int selecionar(ArrayList<String> listaOpcoes, double tempo, boolean opcaoVoltar, String textoVoltar) {
        double tempoOpcao;

        if (listaOpcoes.isEmpty()) {
            tempoOpcao = tempo;
        }
        else {
            tempoOpcao = tempo / listaOpcoes.size();
        }

        for(int i = 0; i < listaOpcoes.size(); i++) {
            System.out.println(Cor.AMARELO.getCodigo() + "[" + (i + 1) + "]" + Cor.RESET.getCodigo() + ": " + listaOpcoes.get(i));
            sleep(tempoOpcao);
        }
        if (opcaoVoltar) {
            System.out.println(Cor.AMARELO.getCodigo() + "[" + (listaOpcoes.size() + 1) + "]" + Cor.RESET.getCodigo() + Cor.CINZA_ESCURO.getCodigo() + ": " + textoVoltar + Cor.RESET.getCodigo());
        }
        sleep(tempoOpcao);

        System.out.println("----------");
        sleep(tempoOpcao);

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

    public static void imprimirBonito(String texto, double tempo) {
        String[] linhas = texto.split("\n");

        int tam = 0;
        for (String linha : linhas) {
            tam++;
        }

        for (String linha : linhas) {
            for (int i = 0; i < linha.length(); i++) {                
                System.out.print(linha.charAt(i)); 
                InputHandler.sleep(tempo/(linha.length() * tam)); 
            }
            
            System.out.println();
            InputHandler.sleep(tempo/tam);
        }
    }
}
