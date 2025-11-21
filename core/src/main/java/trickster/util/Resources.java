package trickster.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.utils.I18NBundle;

public abstract class Resources {

    /* assets/fonts/ */
    public static final String MENU_FONT = "fonts/alagard.ttf";
    
	public static InputMultiplexer muxJuego = new InputMultiplexer();
	public static InputMultiplexer muxMenu = new InputMultiplexer();
	
	public static I18NBundle bundle = I18NBundle.createBundle(Gdx.files.internal("locale/locale"));
	

}
