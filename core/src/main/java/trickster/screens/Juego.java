package trickster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import trickster.cartas.Carta;
import trickster.cartas.CartaVisual;
import trickster.cartas.Palo;
import trickster.entidades.Barajador;
import trickster.entidades.Enemigo;
import trickster.entidades.Jugador;
import trickster.hud.Hud;
import trickster.util.HelpDebug;
import trickster.util.MisUtiles;
import trickster.util.MundoConfig;
import trickster.util.Render;
import trickster.util.Resources;

public class Juego extends Hud implements Screen{

	private Jugador j;
	private Enemigo e;
	private Barajador b;
	
	private CartaVisual c;
	private CartaVisual c1;
	
	private HorizontalGroup hgrup;
	private Table contenedor;
	
	private Stage stage;
	private OrthographicCamera camara;
	
	private ParticleEffect particle;
	private TextureAtlas tA = new TextureAtlas(Resources.FUEGO_PARTICULAS);
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

		Resources.muxJuego.addProcessor(stage);
		
		j = new Jugador();
		e = new Enemigo();
		b = new Barajador(j, e);
		
		b.repartirCartas();
		
		j.mostrarCartas();


		particle = new ParticleEffect();
		particle.load(Gdx.files.internal(Resources.FUEGO_PARTICULAS));
		particle.setPosition(200, 200);
		particle.start();

		
		

	}

	@Override
	public void render(float delta) {
	    ScreenUtils.clear(0, 0, 0, 1);
		stage.draw();
		stage.act();
		
		Render.batch.begin();
		particle.draw(Render.batch, delta); 
		Render.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		  stage.getViewport().update(width, height, true);
		
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
	       stage.dispose();
		
	}

	@Override
	protected void createFonts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createActors() {
		camara = new OrthographicCamera();
		stage = new Stage(new ScreenViewport(camara));
		hgrup = new HorizontalGroup();
		contenedor = new Table();
		
		c = new CartaVisual(new Carta(1, Palo.BASTO), new Texture(Resources.ANCHO_BOSTA));
		c1 = new CartaVisual(new Carta(1, Palo.BASTO), new Texture(Resources.ANCHO_BOSTA));
		
	}

	@Override
	protected void populateStage() {
		hgrup.addActor(c);
		hgrup.addActor(c1);
		hgrup.grow();
		contenedor.setFillParent(true);
		contenedor.add(hgrup);
		stage.addActor(contenedor);

		
		stage.setDebugAll(true);
		
	}

}
