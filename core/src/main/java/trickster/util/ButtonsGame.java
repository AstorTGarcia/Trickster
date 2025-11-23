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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class ButtonsGame extends TextButton {

    protected Texture botonHoverTexture, botonFinalHover;
    protected boolean botonFrameFinal;
    protected Animation<TextureRegion> botonHoverAnimation;
    private float stateTime;

    public ButtonsGame(String textButton, Skin skin, Texture botonSprite, Texture botonHover,Texture botonFinalHover ,int frameCount) {
        super(textButton, skin);

        TextButtonStyle style = new TextButtonStyle(skin.get(TextButtonStyle.class));
        style.up = new TextureRegionDrawable(new TextureRegion(botonSprite));
        setStyle(style);

        this.botonHoverTexture = botonHover;
        this.stateTime = 0f;

        this.botonHoverAnimation = createAnimation(botonHoverTexture, frameCount, 0.1f);
        botonHoverAnimation.setPlayMode(PlayMode.NORMAL);
    }

    @Override
    public void draw(Batch b, float parentAlpha){
        if (isOver() && botonHoverAnimation != null) {

            boolean animationFinished = botonHoverAnimation.isAnimationFinished(stateTime);

            if(!animationFinished){
                stateTime += Gdx.graphics.getDeltaTime();
                
                TextureRegion currentFrame = botonHoverAnimation.getKeyFrame(stateTime, false);
                b.draw(currentFrame,getX(),getY(),getWidth(),getHeight());
                getLabel().draw(b, parentAlpha);
            }else{
                TextureRegion currentFrame = botonHoverAnimation.getKeyFrame(stateTime, false);
                b.draw(currentFrame,getX(),getY(),getWidth(),getHeight());

                

            }

        } else {
            stateTime = 0;
            super.draw(b, parentAlpha);
        }
    }


    public Animation<TextureRegion> createAnimation(Texture sprite, int frameCount, float frameDuration) {
        TextureRegion[][] framesMatrix = TextureRegion.split(sprite, sprite.getWidth()/frameCount, sprite.getHeight());
        TextureRegion[] animationFrames = new TextureRegion[frameCount];

        for (int i = 0;i< frameCount; i++){
            animationFrames[i] = framesMatrix [0][i];

        }

        return new Animation<>(frameDuration,animationFrames);
    }


}

