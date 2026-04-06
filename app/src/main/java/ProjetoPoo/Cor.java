package ProjetoPoo;
import java.lang.String;

public enum Cor {
    RESET("\u001B[0m"),
    PRETO("\u001B[30m"),
    VERMELHO("\u001B[31m"),
    VERDE("\u001B[32m"),
    AMARELO("\u001B[33m"),
    AZUL("\u001B[34m"),
    ROXO("\u001B[35m"),
    CIANO("\u001B[36m"),
    BRANCO("\u001B[37m"),
    PRETO_CLARO("\u001B[90m"),
    VERMELHO_CLARO("\u001B[91m"),
    VERDE_CLARO("\u001B[92m"),
    AMARELO_CLARO("\u001B[93m"),
    AZUL_CLARO("\u001B[94m"),
    ROXO_CLARO("\u001B[95m"),
    CIANO_CLARO("\u001B[96m"),
    BRANCO_CLARO("\u001B[97m"),
    VERMELHO_ESCURO("\u001B[38;2;139;0;0m"),
    VERDE_ESCURO("\u001B[38;2;0;100;0m"),
    AZUL_ESCURO("\u001B[38;2;0;0;128m"),
    AMARELO_ESCURO("\u001B[38;2;184;134;11m"),
    ROXO_ESCURO("\u001B[38;2;75;0;130m"),
    CIANO_ESCURO("\u001B[38;2;0;139;139m"),
    CINZA_ESCURO("\u001B[38;2;64;64;64m");

    private final String codigoAnsi;

    // Construtor
    Cor(String codigoAnsi) {
        this.codigoAnsi = codigoAnsi;
    }

    public String getCodigo() {
        return codigoAnsi;
    }

    public static String formataCor(Cor cor, String texto) {
        return cor.codigoAnsi + texto + RESET.codigoAnsi;
    }

    public static void imprimeAnsi(Cor cor, String texto) {
        System.out.println(cor.codigoAnsi + texto + RESET.codigoAnsi);
    }
}
