package trickster.cartas;

import java.awt.Rectangle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import trickster.util.Render;
import trickster.util.Resources;

/**
 * Este es el objeto visual de una carta, la cual contiene los metodos necesarios para mostrar la carta y, tambien, la carta
 */
public class CartaVisual {

	private Carta cartaLogica;
	
	private Vector2 posicion = new Vector2();
	private float anguloInclinacion;
	private Rectangle rect; //el cuerpo de la carta
	
	private Texture tx;
	private Sprite spr;
	
	
	
	public CartaVisual(Carta cartaLogica) {
		this.cartaLogica = cartaLogica;
		this.posicion.x = 0;
		this.posicion.y = 0;
		
		tx = new Texture(Resources.ANCHO_BOSTA);//aca no va a hacer falta ponerlo pq con la carta logica deberia salir solo TODO
		spr = new Sprite(tx);
		
		spr.setPosition(posicion.x, posicion.y);
		rect = new Rectangle((int)posicion.x, (int)posicion.y, (int)spr.getWidth(), (int)spr.getHeight());
		
		
		spr.setScale(0.3f);
		
		rect.setBounds((int)spr.getX(), (int)spr.getY(), (int)spr.getWidth(), (int)spr.getHeight());
		
		
	}
	
	public void dibujar() {
		spr.draw(Render.batch);
	}
	
}
