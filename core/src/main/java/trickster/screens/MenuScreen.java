package trickster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import trickster.Main;
import trickster.hud.ConfigurationsHud;
import trickster.hud.Hud;
import trickster.util.*;

public class MenuScreen extends Hud implements Screen {
    private final Main GAME;




    private Table menuTable;
    private Table options;

    private Label title;
    private ButtonsGame[] optionsText;

    private Label.LabelStyle titleStyle, optionsStyle, optionSelectedStyle;
    private Texture buttonSprite, buttonFinalSprite;
    private Texture animacionHover;
    private Skin miSkin;
    float buttonWidth,buttonHeight;

    public MenuScreen(final Main GAME){
        this.GAME = GAME;
    }

    @Override
    public void show() {
        super.stage.setDebugAll(true);
        Recursos.muxJuego.addProcessor(stage);//agrega la stage al mux del juego
        super.visible = true;
   }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Render.batch.begin();

        draw();

        Render.batch.end();
    }

    private void selectedOption(int option) {
        switch(option){
            // Jugar
            case 0:
            	MundoConfig.estadoDelJuego = EstadosDelJuego.JUGANDO;
                 GAME.setScreen(new Juego());
                 this.dispose();
                break;
            // Configuraciones
            case 1:
            	MundoConfig.estadoDelJuego = EstadosDelJuego.CONFIGURACION;
            	GAME.setScreen(new ConfigurationsHud());
                break;
            // Salir
            case 2:
                dispose();
                Gdx.app.exit(); // Me parece que esta mal
                break;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    	 Recursos.muxJuego.removeProcessor(stage);

        super.stage.dispose();
    }

    @Override
    protected void createFonts() {
        titleStyle = FontStyle.generateFont(80, "#ffffff", false, Resources.MENU_FONT);
        optionsStyle = FontStyle.generateFont(50, "#ffffff", false, Resources.MENU_FONT);
        optionSelectedStyle = FontStyle.generateFont(50, "#ffff00", true, Resources.MENU_FONT);
        buttonSprite = new Texture(Recursos.botonMainMenuSprite);
        animacionHover = new Texture(Recursos.botonMainMenuHoverSprite);
        buttonFinalSprite = new Texture(Recursos.botonMainMenuFinal);
        buttonHeight = buttonSprite.getHeight();
        buttonWidth = buttonSprite.getWidth();

        miSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    }

    @Override
    protected void createActors() {
        // Tables
        menuTable = new Table();
        menuTable.setFillParent(true);

        options = new Table();

        options.setTouchable(Touchable.childrenOnly);
        menuTable.setTouchable(Touchable.childrenOnly);

        // Labels
        title = new Label("Trickster", titleStyle);

        optionsText = new ButtonsGame[3];
        optionsText[0] = new ButtonsGame("Jugar",miSkin,buttonSprite,animacionHover,6);
        optionsText[1] = new ButtonsGame("Opciones",miSkin,buttonSprite,animacionHover,6);
        optionsText[2] = new ButtonsGame("Salir",miSkin,buttonSprite,animacionHover,6);

    }

    @Override
    protected void populateStage() {
        options.add(optionsText[0]).width(buttonWidth).height(buttonHeight);
        options.row();
        options.add(optionsText[1]).width(buttonWidth).height(buttonHeight);
        options.row();
        options.add(optionsText[2]).width(buttonWidth).height(buttonHeight);
        options.row();

        menuTable.add(title).padTop(10);
        menuTable.row();
        menuTable.add(options).expand();
        menuTable.row();

        stage.addActor(menuTable);
    }

}
