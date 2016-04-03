/* Created by Kyle Berry
 * 
 * 
*/

package com.berry.gravitas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MapEditorScreen implements Screen {

	private long diff, start = System.currentTimeMillis();
	final GravitasGame game;

    OrthographicCamera camera;
    Location loc;
    FileHandle file;
    
    public MapEditorScreen(final GravitasGame gam){
    	this.game = gam;
    	
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    	
        loc = new Location(20,20);
        
        file = Gdx.files.local("map.txt");
        file.writeBytes(new byte[] { 20,20}, false);

    }
    
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
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
        
   
        game.batch.end();
        
        //quit
        if (Gdx.input.isKeyPressed(Keys.Q)){
            for(int i=0; i<20; i++){
            	for(int j =0; j<20; j++){
            	file.writeBytes(new byte[] {(byte) (loc.getTile(i,j,0))}, true);
            	}
            }
        	
        	Gdx.app.exit();
        }
	
        //edit tile
        if (Gdx.input.justTouched()) {
            Vector2 touchPos = new Vector2();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            //camera.unproject(touchPos);
            int t= (int) ((int)(touchPos.x/40)+(int)(20-touchPos.y/24)*loc.getWidth());
            if(loc.tiles[t]<4){
            loc.tiles[t]++;}
            else{loc.tiles[t]=0;}
        }
	
        //limit 30 fps
        diff = System.currentTimeMillis() - start;
        long targetDelay = 1000/30;
        if (diff < targetDelay) {
          try{
              Thread.sleep(targetDelay - diff);
            } catch (InterruptedException e) {}
          }   
        start = System.currentTimeMillis();
        
        
        
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
