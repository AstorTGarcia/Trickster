package trickster.entidades;

import trickster.cartas.Carta;
import trickster.cartas.Palo;
import trickster.util.MisUtiles;

/**
 * El sujeto que se encarga de repartir las cartas
 */
public class Barajador {

	private Jugador j;
	private Enemigo e;
	
	
	public Barajador(Jugador j,  Enemigo e) {
		this.j = j;
		this.e = e;
	}
	
	public void repartirCartas() {
		j.agarrarCarta(new Carta(1, Palo.BASTO));
		j.agarrarCarta(cartaAleatoria());
	}
	
	
	private Carta cartaAleatoria() {
		return new Carta(MisUtiles.generarAleatorio(1, 12), MisUtiles.generarPaloAleatorio());
	}
}
