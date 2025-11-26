package trickster.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ButtonsGame extends TextButton {

    protected Texture botonHoverTexture;
    protected Animation<TextureRegionDrawable> botonHoverAnimation;
    private Label label;
    private TextureRegionDrawable botonSprite, botonHover;
    private float stateTime;

    public ButtonsGame(String textButton, Skin skin, Texture botonSprite, Texture botonHover ,int frameCount) {
        super(textButton, skin);

        label = getLabel();
        TextButtonStyle style = new TextButtonStyle(skin.get(TextButtonStyle.class));
        this.botonSprite = new TextureRegionDrawable(botonSprite);
        setStyle(style);

        this.botonHoverTexture = botonHover;
        this.stateTime = 0f;

        this.botonHoverAnimation = createAnimation(botonHoverTexture, frameCount, 0.1f);
        botonHoverAnimation.setPlayMode(PlayMode.NORMAL);
    }

    @Override
    public void draw(Batch b, float parentAlpha){
        if (isOver() && botonHoverAnimation != null) {
            if(!botonHoverAnimation.isAnimationFinished(stateTime)){
                stateTime += Gdx.graphics.getDeltaTime();
            }
            TextureRegionDrawable currentFrame = new TextureRegionDrawable(botonHoverAnimation.getKeyFrame(stateTime, false));
            getStyle().up = currentFrame;
        } else {
            stateTime = 0;
            getStyle().up = botonSprite;
        }
        super.draw(b, parentAlpha);
    }


    public Animation<TextureRegionDrawable> createAnimation(Texture sprite, int frameCount, float frameDuration) {
        TextureRegion[][] framesMatrix = TextureRegion.split(sprite, sprite.getWidth()/frameCount, sprite.getHeight());
        TextureRegionDrawable[] animationFrames = new TextureRegionDrawable[frameCount];

        for (int i = 0;i< frameCount; i++){
            animationFrames[i] = new TextureRegionDrawable(framesMatrix[0][i]);
        }

        return new Animation<TextureRegionDrawable>(frameDuration,animationFrames);
    }


}

