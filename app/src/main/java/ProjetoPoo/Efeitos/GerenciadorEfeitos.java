package ProjetoPoo.Efeitos;

import java.util.ArrayList;

import ProjetoPoo.Entidades.Entidade;

public class GerenciadorEfeitos {

    private final ArrayList<Efeito> efeitos = new ArrayList<>();

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

    public int getValorEfeito(TipoEfeito tipo) {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito.getTipo() == tipo && efeito.getDuracao() > 0) {
                val = Math.max(val, efeito.getValor());
            }
        }
        return val;
    }

    public int getTempoEfeito(TipoEfeito tipo) {
        int maiorValor = getValorEfeito(tipo);
        if (maiorValor == 0) {
            return 0;
        }

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
        efeitos.removeIf(efeito -> efeito.getDuracao() == 0);
    }
}