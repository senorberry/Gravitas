package com.berry.gravitas;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen{
    final GravitasGame game;

    
    Texture playerSprite;

    OrthographicCamera camera;
    
   

    
    Entity player;
    Location loc;
    
    
    long lastDropTime;
    int dropsGathered;
    Vector2 camPos;

    public GameScreen(final GravitasGame gam) {
        this.game = gam;
       // Gdx.input.setInputProcessor(this);
        
        player = new Entity();
        loc = new Location("map.txt");
        
        // load the images 
        playerSprite = new Texture(Gdx.files.internal("Character.png"));


        
        // load the drop sound effect and the rain background "music"
       // dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
       // rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
       // rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);



        // create the raindrops array and spawn the first raindrop
       // raindrops = new Array<Rectangle>();
       // spawnRaindrop();

    }

  

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch 
        game.batch.begin();
        
        for(int i =0; i<20;i++){
        	for(int j=0; j<20;j++){
        		
        	  game.batch.draw(loc.getTexture(i, j, 0), i*40, j*24,40,24);

        			
        	}
        	
        }
        
        game.batch.draw(playerSprite, player.pos.x*40, player.pos.y*24, 25, 25);

        game.batch.end();

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

        }
        player.update();
        if (Gdx.input.isKeyPressed(Keys.Q))
        	Gdx.app.exit();
      

  
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
       // rainMusic.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        
        playerSprite.dispose();

    }

   


}

/*
//Check keyboard

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
      	//player.position.add(-2, 0);
      	player.direction= Direction.Left;
      	keyPressed=true;
      	}
      	
      	
      if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
          //player.position.add(2,0);
          player.direction= Direction.Right;
      	//camera.translate(2,0);
          keyPressed=true;
          }
      	
      if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
          //player.position.add(0, 2);
          player.direction= Direction.Up;
      	//camera.translate(0,2);
          keyPressed=true;
          }
      	
      if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
      	//player.position.add(0, -2);
      	player.direction= Direction.Down;
      	keyPressed=true;
      	//camera.translate(0,-2);
      	}
      
          //tmap.getLayers().get(0).setVisible(!tmap.getLayers().get(0).isVisible());
       
		if(keycode == Input.Keys.SPACE){
			if(player.fire){
				
			}else{
				player.fire =true;
				player.firedirection=player.direction;
				player.fireposition=player.position;
				player.z=0;
			}
		}
      if(keycode == Input.Keys.NUM_1){
          //tmap.getLayers().get(0).setVisible(!tmap.getLayers().get(0).isVisible());
      	game.setCurrentMenuLevel(
      			game.getMenuLevels().get(0));
			game.switchScreens(4);
      }
      
      if(keycode == Input.Keys.NUM_2){
      	game.setCurrentMenuLevel(
      			game.getMenuLevels().get(1));
			game.switchScreens(4);
      }
      
      if(keycode == Input.Keys.NUM_3){
      	game.setCurrentMenuLevel(
      			game.getMenuLevels().get(2));
			game.switchScreens(4);
      }
      
      if(keycode == Input.Keys.NUM_4){
      	game.setCurrentMenuLevel(
      			game.getMenuLevels().get(3));
			game.switchScreens(4);
      }
      
      if(keycode == Input.Keys.NUM_5){
      	game.setCurrentMenuLevel(
      			game.getMenuLevels().get(4));
			game.switchScreens(4);
      }
		return false;
	}

	
	
		
	@Override
	public boolean keyUp(int keycode) {
		keyPressed=false;
  

		return false;
	}
*/