package trickster.cartas;

public class Carta {

	private int valor;
	private Palo palo;
	
	public Carta(int valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public Palo getPalo() {
		return palo;
	}
}
