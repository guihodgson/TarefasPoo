package ProjetoPoo.Efeitos;

import java.util.ArrayList;

import ProjetoPoo.Entidades.Entidade;

public class GerenciadorEfeitos {

    private final ArrayList<Efeito> efeitos = new ArrayList<>();

    /**
     * Verifica se o efeito já está no ArrayList efeitos, se estiver, aumenta o tempo, senao cria um novo.
     * @param efeito
     */
    public void ganharEfeito(Efeito efeito) {
        boolean existe = false;
        for (Efeito atual : efeitos) {
            if (atual.getTipo() == efeito.getTipo() && atual.getValor() == efeito.getValor() && atual.getDuracao() > 0) {
                atual.adicionarDuracao(efeito.getDuracao());
                existe = true;
            }
        }
        if (existe) {
            return;
        }

        efeitos.add(efeito);
    }

    public void perderEfeito(Efeito efeito) {
        efeitos.remove(efeito);
    }

    /**
     * Retorna o maior valor de efeito na Lista de efeitos.
     * @param tipo
     * @return
     */
    public int getValorEfeito(TipoEfeito tipo) {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito.getTipo() == tipo && efeito.getDuracao() > 0) {
                val = Math.max(val, efeito.getValor());
            }
        }
        return val;
    }

    /**
     * Retorna o tempo do maior efeito que tem na lista.
     * @param tipo
     * @return
     */
    public int getTempoEfeito(TipoEfeito tipo) {
        int maiorValor = getValorEfeito(tipo);

        for (Efeito efeito : efeitos) {
            if (efeito.getTipo() == tipo && efeito.getDuracao() > 0 && efeito.getValor() == maiorValor) {
                return efeito.getDuracao();
            }
        }
        return 0;
    }

    public int calcularDanoAtaqueCausado(int danoBase) {
        int enfraquecido = getValorEfeito(TipoEfeito.ENFRAQUECIDO);
        return (int) Math.ceil(danoBase * (1 - (enfraquecido / 100.0)));
    }

    public int calcularDanoAtaqueRecebido(int danoBase) {
        int vulneravel = getValorEfeito(TipoEfeito.VULNERAVEL);
        return (int) Math.ceil(danoBase * (1 + (vulneravel / 100.0)));
    }

    /**
     * Calcula o dano que um ataque tem que causar com os buffs e debuffs.
     * @param danoBase
     * @param atacante
     * @param alvo
     * @return
     */
    public int calcularDanoFinalAtaque(int danoBase, Entidade atacante, Entidade alvo) {
        int danoComBonus = danoBase + atacante.getGerenciadorEfeitos().getValorEfeito(TipoEfeito.BONUS_DANO);
        int danoCausado = atacante.getGerenciadorEfeitos().calcularDanoAtaqueCausado(danoComBonus);
        return alvo.getGerenciadorEfeitos().calcularDanoAtaqueRecebido(danoCausado);
    }

    public void atualizarEfeito(String evento, Entidade dono) {
        for (Efeito efeito : efeitos) {
            efeito.atualizar(evento, dono);
        }
        limparEfeitosExpirados();
    }

    public void limparEfeitosExpirados() {
        efeitos.removeIf(efeito -> efeito.getDuracao() <= 0);
    }
}