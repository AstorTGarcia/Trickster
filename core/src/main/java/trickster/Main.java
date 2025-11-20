package trickster;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import trickster.screens.MenuScreen;
import trickster.util.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static InputMultiplexer multiplexer;

    @Override
    public void create() {
        Render.batch = new SpriteBatch();

        multiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);

        setScreen(new MenuScreen(this));
    }

}
