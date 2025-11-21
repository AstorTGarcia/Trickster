package trickster.util;

//Caundo el proyecto crece vamos a tenes sysos por todos lados que no sabemos de donde vienen, si antes del syso usamos esto vamos a saber por lo menos la clase de donde salio

//Uso: HelpDebug.debub(getClass(), "Hola");
//Resultado: [trickster.Main] Dice: Hola
public class HelpDebug {
	
	public static void debub(Class string, String mensaje) {
		 System.out.println("["+string.getName()+"] Dice: " + mensaje);
	}
	
}
