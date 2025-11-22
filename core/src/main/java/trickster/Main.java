package trickster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import trickster.screens.Juego;
import trickster.screens.MenuScreen;
import trickster.util.EstadosDelJuego;
import trickster.util.HelpDebug;
import trickster.util.MundoConfig;
import trickster.util.Recursos;
import trickster.util.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {


    @Override
    public void create() {
    	MundoConfig.estadoDelJuego = EstadosDelJuego.JUGANDO;//Al iniciar el juego arranca en el menu
        Render.batch = new SpriteBatch();

        
        switch (MundoConfig.estadoDelJuego) {//esto nos va a servir para debugear facil
		case MENU:
			//cuando el estado de juego es MENU, usamos el input multiplexer de menus
			Gdx.input.setInputProcessor(Recursos.muxJuego);
			 setScreen(new MenuScreen(this));
			break;

		case JUGANDO:
			//cuando el estado de juego es JUGANDO, usamos el input multiplexer del juego
			Gdx.input.setInputProcessor(Recursos.muxJuego);
			this.setScreen(new Juego());
			break;
		default:
			break;
		}
       
        

    }

}
