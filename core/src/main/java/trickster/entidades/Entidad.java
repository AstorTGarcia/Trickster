package trickster.entidades;

import java.util.ArrayList;

import trickster.cartas.Carta;
import trickster.cartas.Palo;

public abstract class Entidad {

	private ArrayList<Carta> baraja = new ArrayList<>();
	
	
	public void agarrarCarta(Carta c) {
		baraja.add(c);
	}
	
	public void descartarCarta(Carta c) {
		baraja.remove(c);
	}
	
	/**
	 * Mostrar carta por indice, en el caso de algun poder donde se deba elegir por orden de carta
	 * @param i
	 */
	public void mostrarCarta(int i){
		mostrarCarta(baraja.get(i));
	}
	
	/**
	 * Imprime los atributos de la carta por consola (por ahora)
	 * @param c
	 */
	public void mostrarCarta(Carta c) {
		System.out.println(c.getValor());
		System.out.println(c.getPalo());
	}
	
	/**
	 * Muestra todas las cartas de la baraja
	 */
	public void mostrarCartas() {
		for (Carta carta : baraja) {
			mostrarCarta(carta);
		}
	}
	
	/**
	 * Se fija si la entidad tiene la carta en su baraja
	 * @return
	 */
	public boolean tieneCarta(Carta c) {
		for (Carta carta : baraja) {
	        if (carta.getValor() == c.getValor() && carta.getPalo() == c.getPalo()) {
	            return true;
	        }
		}
		return false;
	}
	
	public boolean tieneCarta(int numero, Palo palo) {
		return tieneCarta(new Carta(numero, palo));
	}
	
	
}
