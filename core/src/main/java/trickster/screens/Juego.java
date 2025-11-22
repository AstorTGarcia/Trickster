package trickster.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import trickster.cartas.Carta;
import trickster.cartas.Palo;
import trickster.entidades.Barajador;
import trickster.entidades.Enemigo;
import trickster.entidades.Jugador;
import trickster.util.HelpDebug;
import trickster.util.Render;
import trickster.util.Resources;

public class Juego implements Screen{

	private Jugador j;
	private Enemigo e;
	private Barajador b;
	
	private Sprite c = new Sprite(new Texture(Resources.ANCHO_BOSTA));
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		j = new Jugador();
		e = new Enemigo();
		b = new Barajador(j, e);
		
		b.repartirCartas();
		
		j.mostrarCartas();
		
		c.setScale(0.3f,0.3f);
	}

	@Override
	public void render(float delta) {
		
		if(j.tieneCarta(new Carta(1,Palo.BASTO))) {
			Render.batch.begin();
			c.draw(Render.batch);
			Render.batch.end();
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
