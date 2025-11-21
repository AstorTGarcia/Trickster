package trickster.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import trickster.Main;

public abstract class Hud {
    protected ScreenViewport viewPort;
    protected Stage stage;
    public boolean visible;

    public Hud() {
        viewPort = new ScreenViewport();
        stage = new Stage(viewPort);
        createFonts();
        createActors();
        populateStage();
    }

    public void resize(int width, int height){
        viewPort.update(width, height, true);
    }

    public void display(){
        visible = true;
    }

    public void close(){
        visible = false;
    }

    public void draw() {
        if(visible){
            this.stage.act(Gdx.graphics.getDeltaTime());
            this.stage.draw();
        }
    }

    protected abstract void createFonts();
    protected abstract void createActors();
    protected abstract void populateStage();
}
