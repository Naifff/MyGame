package ru.geekbrains.mygame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.mygame.Background;
import ru.geekbrains.mygame.My2DGame;
import ru.geekbrains.mygame.engine.ActionListener;
import ru.geekbrains.mygame.engine.Base2DScreen;
import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.math.Rnd;
import ru.geekbrains.mygame.star.Star;


public class GameScreen extends Base2DScreen implements ActionListener{

    public GameScreen(My2DGame game) {
        super(game);
        this.game=game;
    }

    private TextureAtlas atlas;
    private Star[] slowStars=new Star[100];
    private Star[] fastStars=new Star[10];
    private My2DGame game;
    private Texture backgroundTexture;
    private Background background;


    @Override
    public void show() {
        super.show();
        Gdx.graphics.setTitle("Go Go Go");
        backgroundTexture = new Texture("1.png");
        atlas = new TextureAtlas("menuAtlas.tpack");
        background = new Background(new TextureRegion(backgroundTexture));
        for (int i = 0; i < slowStars.length; i++) {
            slowStars[i]=new Star(atlas, Rnd.nextFloat(-0.00005f, 0.00005f), Rnd.nextFloat(-0.0005f, -0.0001f), Rnd.nextFloat(0.01f,0.001f));
        }
        for (int i = 0; i <fastStars.length ; i++) {
            fastStars[i]=new Star(atlas, Rnd.nextFloat(-0.001f, 0.001f), Rnd.nextFloat(-0.7f, -0.1f), 0.01f);
        }

    }

    @Override
    public void render(float dt) {
        super.render(dt);
        update(dt);
        draw();
    }
    public  void draw(){
        Gdx.gl.glClearColor(0.7f, 0.3f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i <slowStars.length ; i++) {
            slowStars[i].draw(batch);
        }
        for (int i = 0; i <fastStars.length ; i++) {
            fastStars[i].draw(batch);
        }
        batch.end();
    }

    public void update(float dt){

        for (int i = 0; i <slowStars.length ; i++) {
            slowStars[i].update(dt);
        }
        for (int i = 0; i < fastStars.length; i++) {
            fastStars[i].update(dt);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundTexture.dispose();

    }

    public Texture moveShip(int m) {
        switch (m) {
            case 1:
                return new Texture("sh1.png");
            case 2:
                return new Texture("sh2.png");
            case 3:
                return new Texture("sh3.png");
            case 4:
                return new Texture("sh4.png");
            case 6:
                return new Texture("sh6.png");
            case 7:
                return new Texture("sh7.png");
            case 8:
                return new Texture("sh8.png");
            case 9:
                return new Texture("sh9.png");
            default:
                return new Texture("sh5.png");

        }

    }

    @Override
    protected void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < slowStars.length; i++) {
            slowStars[i].resize(worldBounds);
        }
        for (int i = 0; i < fastStars.length; i++) {
            fastStars[i].resize(worldBounds);
        }
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer, int button) {
        super.touchDown(touch, pointer, button);

    }

    @Override
    protected void touchUp(Vector2 touch, int pointer, int button) {
        super.touchUp(touch, pointer, button);
    }

    @Override
    protected void touchDragged(Vector2 touch, int pointer) {
        super.touchDragged(touch, pointer);
    }

    @Override
    public void actionPerformed(Object src) {

    }
}
