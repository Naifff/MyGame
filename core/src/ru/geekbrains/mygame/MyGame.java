package ru.geekbrains.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	Texture ship;
	TextureRegion region;
	int i=0;
	int x=100;
	int y=100;
	boolean dest=true;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background=new Texture("1.png");
		ship=new Texture("2.png");
//		region = new TextureRegion(img, (int)(Math.random()*img.getHeight())-100, (int)(Math.random()*img.getWidth())-100,100,100);
	}

	@Override
	public void render () {
		if(i%10==0){
		if (dest){
			x++;
		}else {x--;}
		if(x>150){dest=false;}
		if(x<50){dest=true;}
		}
		//		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		i++;
		batch.begin();
		batch.draw(background, 0, 0);
//		batch.setColor(0.11f,0.154f,0.241f,1);
		batch.draw(ship, x, y);
//		batch.draw(region, 100, 100);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
