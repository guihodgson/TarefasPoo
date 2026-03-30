package Entidades;

import Efeitos.Efeito;
import Efeitos.EfeitoBonusDano;
import Efeitos.EfeitoEnfraquecido;
import Efeitos.EfeitoVulneravel;
import Efeitos.EfeitoVeneno;
import java.util.ArrayList;

public class Entidade {
    
    // Atributos

    protected String nome;

    protected int vidaMax;
    protected int vida;
    protected int escudo;

    protected int energia;
    protected int energiaMax;

    protected int buffDano;

    protected ArrayList<Efeito> efeitos = new ArrayList<>();

    // Getters

    public String getNome() {
        return nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }

    // Constructor

    public Entidade(String nome, int vida, int escudo) {
        this.nome = nome;

        this.vida = vidaMax = vida;
        this.escudo = escudo;
    }


    // Metodos

    public void receberDano(int dano) {
        if (dano <= escudo) {
            escudo -= dano;
        }
        else {
            vida -= (dano - escudo);
            escudo = 0;
        }
    }

    public int curarVida(int valor) {
        if (vida + valor > vidaMax) {
            vida = vidaMax;
        }
        else {
            vida += valor;
        }
        return vida;
    }

    public int ganharEscudo(int valor) {
        escudo += valor;
        return escudo;
    }

    public int perderEscudo(int valor) {
        if (escudo - valor < 0) {
            escudo = 0;
        }
        else {
            escudo -= valor;
        }
        return escudo;
    }

    public void resetarEscudo() {
        escudo = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void ganharVeneno(int valor, int tempo) {
        boolean existe = false;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVeneno e && e.getDano() == valor && e.getDuracao() > 0) {
                e.adicionarDuracao(tempo);
                existe = true;
            }
        }
        if (existe) {
            return;
        }

        efeitos.add(new EfeitoVeneno(valor, tempo));
    }

    public void ganharBonusDano(int valor, int tempo) {
        boolean existe = false;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoBonusDano e && e.getDano() == valor && e.getDuracao() > 0) {
                e.adicionarDuracao(tempo);
                existe = true;
            }
        }
        if (existe) {
            return;
        }

        efeitos.add(new EfeitoBonusDano(valor, tempo));
    }

    public void ganharVulneravel(int valor, int tempo) {
        boolean existe = false;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVulneravel e && e.getPorcentagem() == valor && e.getDuracao() > 0) {
                e.adicionarDuracao(tempo);
                existe = true;
            }
        }
        if (existe) {
            return;
        }

        efeitos.add(new EfeitoVulneravel(valor, tempo));
    }

    public void ganharEnfraquecido(int valor, int tempo) {
        boolean existe = false;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoEnfraquecido e && e.getPorcentagem() == valor && e.getDuracao() > 0) {
                e.adicionarDuracao(tempo);
                existe = true;
            }
        }
        if (existe) {
            return;
        }

        efeitos.add(new EfeitoEnfraquecido(valor, tempo));
    }

    public void perderEfeito(Efeito efeito) {
        efeitos.remove(efeito);
    }

    public int calcularBonusDano() {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoBonusDano e) {
                if (val < e.getDano() && e.getDuracao() > 0) {
                    val = e.getDano();
                }
            }
        }
        return val;
    }

    public int calcularTempoBonusDano(int valor) {
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoBonusDano e) {
                if (valor == e.getDano()) {
                    return e.getDuracao();
                }
            }
        }
        return 0;
    }

    public int calcularVeneno() {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVeneno e) {
                if (val < e.getDano() && e.getDuracao() > 0) {
                    val = e.getDano();
                }
            }
        }
        return val;
    }

    public int calcularTempoVeneno(int valor) {
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVeneno e) {
                if (valor == e.getDano()) {
                    return e.getDuracao();
                }
            }
        }
        return 0;
    }

    public int calcularVulneravel() {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVulneravel e) {
                if (val < e.getPorcentagem() && e.getDuracao() > 0) {
                    val = e.getPorcentagem();
                }
            }
        }
        return val;
    }

    public int calcularTempoVulneravel(int valor) {
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoVulneravel e) {
                if (valor == e.getPorcentagem()) {
                    return e.getDuracao();
                }
            }
        }
        return 0;
    }

    public int calcularEnfraquecido() {
        int val = 0;
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoEnfraquecido e) {
                if (val < e.getPorcentagem() && e.getDuracao() > 0) {
                    val = e.getPorcentagem();
                }
            }
        }
        return val;
    }

    public int calcularTempoEnfraquecido(int valor) {
        for (Efeito efeito : efeitos) {
            if (efeito instanceof EfeitoEnfraquecido e) {
                if (valor == e.getPorcentagem()) {
                    return e.getDuracao();
                }
            }
        }
        return 0;
    }

    public int calcularDanoAtaqueCausado(int danoBase) {
        int enfraquecido = calcularEnfraquecido();
        return (int) Math.ceil(danoBase * (1 - (enfraquecido / 100.0)));
    }

    public int calcularDanoAtaqueRecebido(int danoBase) {
        int vulneravel = calcularVulneravel();
        return (int) Math.ceil(danoBase * (1 + (vulneravel / 100.0))); // Arredonda a porcentagem a mais para cima
    }

    public void resetarEnergia() {
        energia = energiaMax;
    }

    public boolean podeGastarEnergia(int valor) {
        if (valor <= energia) {
            energia -= valor;
            return true;
        }
        else {
            return false;
        }
    }

    public void atualizarEfeito(String evento) {
        for(Efeito efeito : efeitos) {
            efeito.atualizar(evento, this);
        }
        limparEfeitosExpirados();
    }

    public void limparEfeitosExpirados() {
        efeitos.removeIf(efeito -> efeito.getDuracao() == 0);
    }
}