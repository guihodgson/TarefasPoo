package ProjetoPoo.Eventos;

public enum TipoEvento {
    RAIZ,
    BATALHA_COMUM,
    BATALHA_ELITE,
    BOSS,
    FOGUEIRA,
    ESCOLHA,
    ALEATORIO;

    public int getDificuldade() {
        return switch (this) {
            case BATALHA_COMUM -> 1;
            case BATALHA_ELITE -> 4;
            case BOSS -> 16;
            default -> 0;
        };
    }
}
