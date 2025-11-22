package trickster.util;

import java.util.Random;

import trickster.cartas.Palo;

/**
 * cosas como numeros aleatorios o alguna boludez chiquita que necesitemos
 */
public abstract class MisUtiles {

	public static Random r = new Random();
	
	/**
	 * Genera un numero aleatorio de 0 a max
	 * @return
	 */
	public static int generarAleatorio(int max) {
		return r.nextInt(max+1);
	}
	
	/**
	 * Genera un numero aleatorio entre min(incluido) y max(incluido)
	 * @param min
	 * @param max
	 * @return
	 */
	public static int generarAleatorio(int min, int max) {
		return r.nextInt(min,max+1);
	}
	
	public static Palo generarPaloAleatorio() {
		switch (generarAleatorio(1,4)) {
		case 1:
			return Palo.BASTO;
		case 2:
			return Palo.COPA;
		case 3:
			return Palo.ESPADA;
		case 4:
			return Palo.ORO;
		default:
			return null;
		}
	}
	
	
}
