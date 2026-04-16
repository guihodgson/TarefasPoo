package ProjetoPoo.Save;

import java.util.ArrayList;
import java.util.List;

import ProjetoPoo.Entidades.Heroi;

// import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveHeroi {

	// Dados heroi
	public String nome;
	public int vidaAtual;
    public int vidaMaxima;
    public int escudo;
    public int energiaAtual;
    public int energiaMaxima;
    public int moedas;

	// ID
    public List<String> cardasNoBaralho = new ArrayList<>();
    public List<String> cardasNoDeck = new ArrayList<>();
    public List<String> cardasNoDescarte = new ArrayList<>();

	// Efeitos
    public List<SaveEfeito> efeitos = new ArrayList<>();

	// Construtor Jackson
    public SaveHeroi() {}
    
    // Construtor com dados
    public SaveHeroi(Heroi heroi) {
        this.nome = heroi.getNome();
        this.vidaAtual = heroi.getVida();
        this.vidaMaxima = heroi.getVidaMax();
        this.escudo = heroi.getEscudo();
        this.energiaAtual = heroi.getEnergia();
        this.energiaMaxima = heroi.getEnergiaMax();
        this.moedas = heroi.getMoedas();
    }
}
