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
	TextureRegion region;
//	int i=0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
//		region = new TextureRegion(img, (int)(Math.random()*img.getHeight())-100, (int)(Math.random()*img.getWidth())-100,100,100);
	}

	@Override
	public void render () {
//		if(i%10==0){
//		region = new TextureRegion(img, (int)(Math.random()*img.getHeight())-100, (int)(Math.random()*img.getWidth())-100,100,100);}
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		i++;
		batch.begin();
		batch.setColor(0.11f,0.154f,0.241f,1);
		batch.draw(img, 0, 0);
//		batch.draw(region, 100, 100);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
