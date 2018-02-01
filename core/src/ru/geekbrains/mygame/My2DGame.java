package ru.geekbrains.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.geekbrains.mygame.engine.Base2DScreen;

public class My2DGame extends Game {
    private Base2DScreen menuscreen;
//    private SpriteBatch batch;
   // private Viewport viewport;

   // public Viewport getViewport() {
//        return viewport;
//    }

    @Override
    public void create() {
//        batch = new SpriteBatch();
//        viewport = new FitViewport(1280, 720);
        menuscreen = new MenuScreen(this);//, batch);
        setScreen(menuscreen);
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        getScreen().render(dt);
    }

    @Override
    public void dispose() {
        getScreen().dispose();
//        batch.dispose();
    }

}
