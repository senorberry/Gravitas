package com.berry.gravitas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MapEditorScreen implements Screen {

	


    OrthographicCamera camera;
    
    
    public MapEditorScreen(){
    	
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    	
        FileHandle file = Gdx.files.local("map.txt");
        file.writeBytes(new byte[] { 10,10}, false);
        for(int i=0; i<100; i++){
        	file.writeBytes(i%2, true);
        	
        }
    }
    
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
        if (Gdx.input.isKeyPressed(Keys.Q))
        	Gdx.app.exit();
		
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
