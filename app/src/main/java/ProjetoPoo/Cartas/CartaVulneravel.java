package ProjetoPoo.Cartas;
import ProjetoPoo.Entidades.Entidade;

public class CartaVulneravel extends CartaEfeito {

	// Atributos

	protected int vulnerabilidade;
	protected int tempo;

	// Getters

	public int getVulnerabilidade() {
		return vulnerabilidade;
	}

	// Constructor

	public CartaVulneravel(String nome, String descricao, int custo, int vulnerabilidade, int tempo) {
		super(nome, descricao, custo);
		this.vulnerabilidade = vulnerabilidade;
		this.tempo = tempo;
	}

	// Metodos

	@Override
	public void usar(Entidade heroi, Entidade alvo) {
		alvo.ganharVulneravel(vulnerabilidade, tempo);
	}
}
