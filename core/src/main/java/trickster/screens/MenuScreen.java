package trickster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import trickster.Main;
import trickster.hud.ConfigurationsHud;
import trickster.hud.Hud;
import trickster.util.EstadosDelJuego;
import trickster.util.FontStyle;
import trickster.util.MundoConfig;
import trickster.util.Recursos;
import trickster.util.Render;
import trickster.util.Resources;

public class MenuScreen extends Hud implements Screen {
    private final Main GAME;

    private Table menuTable;
    private Table options;

    private Label title;
    private Label[] optionsText;

    private Label.LabelStyle titleStyle, optionsStyle, optionSelectedStyle;

    public MenuScreen(final Main GAME){
        this.GAME = GAME;
    }

    @Override
    public void show() {
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

        optionsText = new Label[3];
        optionsText[0] = new Label(Recursos.bundle.get("menu1.valor1.jugar"), optionsStyle);
        optionsText[1] = new Label(Recursos.bundle.get("menu1.valor2.config"), optionsStyle);
        optionsText[2] = new Label(Recursos.bundle.get("menu1.valor3.salir"), optionsStyle);

        for(int i = 0; i < optionsText.length; i++){
            Label option = optionsText[i];
            option.setTouchable(Touchable.enabled);

            int finalI = i;
            option.addListener(new ClickListener(){
                @Override
                public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                    option.setStyle(optionSelectedStyle);
                }

                @Override
                public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                    option.setStyle(optionsStyle);
                }

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    selectedOption(finalI);
                }
            });

        }
    }

    @Override
    protected void populateStage() {
        options.add(optionsText[0]);
        options.row();
        options.add(optionsText[1]);
        options.row();
        options.add(optionsText[2]);
        options.row();

        menuTable.add(title).padTop(10);
        menuTable.row();
        menuTable.add(options).expand();
        menuTable.row();

        super.stage.addActor(menuTable);
    }

}
