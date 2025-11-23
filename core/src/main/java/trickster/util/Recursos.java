package trickster.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.utils.I18NBundle;

//Los recursos (rutas) que el juego utiliza
public class Recursos {

	public static InputMultiplexer muxJuego = new InputMultiplexer();
	public static InputMultiplexer muxMenu = new InputMultiplexer();

    public static I18NBundle bundle = I18NBundle.createBundle(Gdx.files.internal("locale/locale"));

    public static String botonMainMenuSprite  ="sprites/MainMenu/GloboDeTextoMenu.png";
    public static String botonMainMenuHoverSprite = "sprites/MainMenu/GloboDeTextoMenuAnimate-Sheet.png";
    public static String botonMainMenuFinal = "sprites/MainMenu/GloboDeTextoMenuFinal.png";
}
