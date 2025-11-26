package trickster.cartas;

import java.awt.Rectangle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import trickster.util.HelpDebug;
import trickster.util.Render;
import trickster.util.Resources;

/**
 * Este es el objeto visual de una carta, la cual contiene los metodos necesarios para mostrar la carta y, tambien, la carta
 */
public class CartaVisual extends Actor {

    private Sprite spr;
    private Carta cartaLogica;
    
    private boolean animando = false; //todas las animaciones van a tener que usar esta variable de control para que se ejecuten bien

    public CartaVisual(Carta cartaLogica, Texture t) {
        this.cartaLogica = cartaLogica;
        spr = new Sprite(t);
        spr.setOrigin(getOriginX(), getOriginY());//Esto es importante, por que el actor y el sprite tienen origenes disntintos (actor en esquina inferior izquierda y el sprite en su centro) haciendo que cuando se escale esten defasados

        setSize(spr.getWidth(), spr.getHeight());
        setScale(0.35f);

        //setPosition(100, 100); 
        spr.setScale(getScaleX(), getScaleY());

        agregarListeners();


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
    	spr.setScale(getScaleX(), getScaleY());
    	spr.setPosition(getX(), getY());
        spr.setRotation(getRotation());
        spr.draw(batch);
    }
    
    
    private void agregarListeners() {
    	//Hay que cambiar el origen para que la animacion salga como nos imaginamos
    	this.setOriginX(getWidth()/2);
    	spr.setOrigin(getOriginX(), getOriginY());//del sprite tambien!

    	//Click
        this.addListener(new ClickListener(){
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        HelpDebug.debub(getClass(), "Click en carta "+ cartaLogica.getValor() +" "+ cartaLogica.getPalo());
		    }
		});
        

        addListener(new InputListener() {
        	
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
//                animacionEscalar(true);
            	animacionVoltear();
            	
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
//            	animacionEscalar(false);

            }
        });
        
        
    }
    
    private void animacionVoltear() {
    	if(animando) return;
    	
    	animando = true;
    	addAction(Actions.sequence(
    			
            	  Actions.scaleTo(0, .35f, .5f),
            	  
      			Actions.run(() ->{//hay que hacer esto para poder modificar cosas del codigo
     				 spr.setTexture(new Texture(Resources.UNO_ORO));
      			}),
      			
            	  Actions.scaleTo(.35f, .35f, .5f)
      			

      			
      			));
    	animando = false;
    }
    
    private void animacionEscalar(boolean enter) {
    	if(animando) return;
    	animando = true;
    	
    	if(enter) {
    		addAction(Actions.scaleTo(.45f, .45f, .1f));
    	}else {
    		addAction(Actions.scaleTo(.35f, .35f, .1f));
    	}

    	animando = false;
    }
}

