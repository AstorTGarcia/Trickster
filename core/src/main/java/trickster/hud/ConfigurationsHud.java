package trickster.hud;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import trickster.util.FontStyle;
import trickster.util.Resources;

public class ConfigurationsHud extends Hud {

    private Table menuTable;
    private Table options;

    private Label[] optionsText;
    private Label title;

    private Label.LabelStyle titleStyle, optionsStyle, optionSelectedStyle;

    public ConfigurationsHud() {}

    @Override
    protected void createFonts() {
        titleStyle = FontStyle.generateFont(80, "#ffffff", false, Resources.MENU_FONT);
        optionsStyle = FontStyle.generateFont(50, "#ffffff", false, Resources.MENU_FONT);
        optionSelectedStyle = FontStyle.generateFont(50, "#ffff00", true, Resources.MENU_FONT);
    }

    @Override
    protected void createActors() {
        menuTable = new Table();
        menuTable.setFillParent(true);

        options = new Table();

        options.setTouchable(Touchable.childrenOnly);
        menuTable.setTouchable(Touchable.childrenOnly);

        //
        title = new Label("CONFIGURACIONES", titleStyle);

        optionsText = new Label[2];
        optionsText[0] = new Label("opc1", optionsStyle);
        optionsText[1] = new Label("Volver", optionsStyle);

        optionsText[1].addListener(new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                optionsText[1].setStyle(optionSelectedStyle);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                optionsText[1].setStyle(optionsStyle);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                //options.addAction(Actions.sequence(Actions.fadeOut(0.2f)));
                close();
            }
        });

    }

    @Override
    protected void populateStage() {
        options.add(optionsText[0]);
        options.row();
        options.add(optionsText[1]);
        options.row();

        menuTable.add(title).padTop(10);
        menuTable.row();
        menuTable.add(options).expand();
        menuTable.row();

        super.stage.addActor(menuTable);
    }

}
