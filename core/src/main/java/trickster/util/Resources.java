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
	


    public static final String ANCHO_BOSTA = "borrar/anchoDeBasto.png";
    public static final String UNO_ORO = "borrar/chadDeOro.png";

    public static String botonMainMenuSprite  ="sprites/MainMenu/GloboDeTextoMenu.png";
    public static String botonMainMenuHoverSprite = "sprites/MainMenu/GloboDeTextoMenuAnimate-Sheet.png";
    public static String botonMainMenuFinal = "sprites/MainMenu/GloboDeTextoMenuFinal.png";

    public static String FUEGO_PARTICULAS = "particleEffects/flame.p";
    public static String CHISPAS_PARTICULAS = "particleEffects/chispas.p";
    public static String ATLAS_PARTICULAS = "particleEffects/particulasDelJuego.atlas";//ATLAS CON TODAS LAS PARTICULAS, USAR GDXTEXTUREPACKER

}
