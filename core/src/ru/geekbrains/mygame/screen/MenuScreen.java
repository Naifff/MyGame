package ru.geekbrains.mygame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.mygame.Background;
import ru.geekbrains.mygame.Button;
import ru.geekbrains.mygame.My2DGame;
import ru.geekbrains.mygame.engine.ActionListener;
import ru.geekbrains.mygame.engine.Base2DScreen;
import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.Sprite;
import ru.geekbrains.mygame.engine.math.Rnd;
import ru.geekbrains.mygame.star.Star;
import ru.geekbrains.mygame.ui.ButtonExit;
import ru.geekbrains.mygame.ui.ButtonPlay;

public class MenuScreen extends Base2DScreen implements ActionListener {
    public MenuScreen(My2DGame game) {//}, SpriteBatch batch) {
        super(game);
        this.game = game;
    }

    // private SpriteBatch batch;

    private static final float BUTTON_HEIGHT = 0.10f;
    private static final float BUTTON_PRESS_SCALE = 0.9f;

    private TextureAtlas atlas;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

//    private Star star;

    private Star[] slowStars=new Star[1000];
    private Star[] fastStars=new Star[100];

    private My2DGame game;
    private Texture backgroundTexture;
    private Texture ship;
    //при изменении разрешения экрана и текстуры корабля, пересчитать!!!
    private int xMid = 135;
    private int yMid = 270;
    //при изменении разрешения экрана и текстуры корабля, пересчитать!!!
    private int x = xMid;
    private int y = yMid;
//    private int i = 0;
    private int move = 5;
    private Vector2 centr;
    private Vector2 mouse;
    private Vector2 shipVector;
    private Vector2 res;
    private Vector2 levo = new Vector2(-1, 0);
    private int speed = 180;
    private Vector2 testMatrixVector;
    private Matrix3 matrix3;

    private Sprite shipSprite;
    private Background background;
//    private Button startBTN;
//    private Button exitBTN;


//    private float xDif;
//    private  float yDif;


    @Override
    public void show() {
        super.show();
//        Gdx.graphics.setResizable(false);
        Gdx.graphics.setTitle("Go Go Go");
        //  batch = new SpriteBatch();
        backgroundTexture = new Texture("1.png");
        //ship = new Texture("2.png");
        shipVector = new Vector2(x, y);
        testMatrixVector = new Vector2(2, 3);
        matrix3 = new Matrix3();
        matrix3.idt();
        testMatrixVector.mul(matrix3);
        ship = new Texture("sh5.png");
        shipSprite = new Sprite(new TextureRegion(ship));
        shipSprite.setSize(1f, 1f);
        atlas = new TextureAtlas("menuAtlas.tpack");
        background = new Background(new TextureRegion(backgroundTexture));
//        startBTN = new Button(new TextureRegion(new Texture("statr.png")));
//        exitBTN = new Button(new TextureRegion(new Texture("exit.png")));
        buttonPlay = new ButtonPlay(new TextureRegion(new TextureRegion(new Texture("statr.png"))), BUTTON_PRESS_SCALE, this);
                buttonPlay.setHeightProportion(BUTTON_HEIGHT);
        buttonExit = new ButtonExit(new TextureRegion(new Texture("exit.png")), BUTTON_PRESS_SCALE, this);
        buttonExit.setHeightProportion(BUTTON_HEIGHT);
//        star = new Star(atlas, Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.5f, -0.1f), 0.01f);

//        for(Star star:slowStars){
//            star=new Star(atlas, Rnd.nextFloat(-0.00005f, 0.00005f), Rnd.nextFloat(-0.0005f, -0.0001f), Rnd.nextFloat(0.001f,0.0001f));
//        }
//        for(Star star:fastStars){star= new Star(atlas, Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.5f, -0.1f), 0.01f);}
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

    public void draw(){
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
//        for(Star star:slowStars){star.draw(batch);}
//        for(Star star:fastStars){star.draw(batch);}

        buttonPlay.draw(batch);
        buttonExit.draw(batch);
        batch.end();
    }

    public void update(float dt) {

        for (int i = 0; i <slowStars.length ; i++) {
            slowStars[i].update(dt);
        }
        for (int i = 0; i < fastStars.length; i++) {
            fastStars[i].update(dt);
        }

//        for(Star star:slowStars){star.update(dt);}
//        for(Star star:fastStars){star.update(dt);}

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
    public void dispose() {

//        batch.dispose();
        backgroundTexture.dispose();
        ship.dispose();
//        super.dispose();
    }

    @Override
    protected void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
//        startBTN.resize(worldBounds);
//        startBTN.setLeft(-worldBounds.getHalfWidth()/2-startBTN.getHalfWidth());
//        startBTN.setBottom(worldBounds.getBottom()+startBTN.getHalfWidth()*2);
//        exitBTN.resize(worldBounds);
//        exitBTN.setLeft(worldBounds.getHalfWidth()/2-exitBTN.getHalfWidth());
//        exitBTN.setBottom(startBTN.getBottom());
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);

        for (int i = 0; i < slowStars.length; i++) {
            slowStars[i].resize(worldBounds);
        }
        for (int i = 0; i < fastStars.length; i++) {
            fastStars[i].resize(worldBounds);
        }

//        for(Star star:slowStars){star.resize(worldBounds);}
//        for(Star star:fastStars){star.resize(worldBounds);}

    }

    @Override
    protected void touchDown(Vector2 touch, int pointer, int button) {
        super.touchDown(touch, pointer, button);
        buttonExit.touchUp(touch, pointer);
        buttonPlay.touchUp(touch, pointer);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer, int button) {
        super.touchUp(touch, pointer, button);
        buttonExit.touchDown(touch, pointer);
        buttonPlay.touchDown(touch, pointer);
    }

    @Override
    protected void touchDragged(Vector2 touch, int pointer) {
        super.touchDragged(touch, pointer);
    }

    @Override
    public void actionPerformed(Object src) {
        if (src == buttonExit) {
            Gdx.app.exit();
        } else if (src == buttonPlay) {
            game.setScreen(new GameScreen(game));
        } else {
            throw new RuntimeException("Unknown src " + src);
        }

    }

    //    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        x = screenX - ship.getWidth() / 2;
//        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
//        mouse = new Vector2(x, y);
//        if (button == 0) {
//            speed = 240;
//        } else {
//            speed = 480;
//        }
//        return super.touchDown(screenX, screenY, pointer, button);
//    }

//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        x = screenX - ship.getWidth() / 2;
//        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
//        mouse = new Vector2(xMid, yMid);
//        speed = 180;
//        return super.touchUp(screenX, screenY, pointer, button);
//    }

//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        x = screenX - ship.getWidth() / 2;
//        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
//        mouse = new Vector2(x, y);
//        return super.touchDragged(screenX, screenY, pointer);
//    }

//    @Override
//    public void resize(int width, int height) {
////        this.game.getViewport().update(width, height, true);
////        this.game.getViewport().apply();
//
////        System.out.println( Gdx.graphics.getBackBufferWidth());
//        ship = new Texture("sh5.png");
////        xMid = width / 2 - ship.getWidth() / 2;
////        x = xMid;
//
////        yMid = height / 2 - ship.getHeight() / 2;
////        y = yMid;
//        centr = new Vector2(x, y);
////        shipVector = new Vector2(x, y);
//        mouse = new Vector2(xMid, yMid);
//
////        xDif=width/1280;
////        yDif=height/720;
//
////        x = screenX - ship.getWidth() / 2;
////        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
////        mouse = new Vector2(xMid, yMid);
////        speed = 180;
//
////        System.out.println(xMid+"_+_"+yMid);
//
////        System.out.println(ship.getWidth()+"_ship_"+ship.getHeight());
////        System.out.println(width+"_windiw_"+height);
////        System.out.println(xMid+"_center_"+yMid);
//        super.resize(width, height);
//    }
}

/*
        Vector2 v1 = new Vector2(1, 3);
		Vector2 v2 = new Vector2(0, -1);
		// v1(x1, y1) + v2(x2, y2) = v3(x1 + x2, y1 + y2)
		Vector2 v3 = v1.cpy().add(v2);
		System.out.println("Сложение v3 = " + v3.x + " " + v3.y);

		v1 = new Vector2(4, 3);
		v2 = new Vector2(1, 2);
		// v1(x1, y1) - v2(x2, y2) = v3(x1 - x2, y1 - y2)
		v3 = v1.cpy().sub(v2);
		System.out.println("Вычитание v3 = " + v3.x + " " + v3.y);

		v1 = new Vector2(7, 5);
		// n * v1(x, y) = v2(n*x, n*y)
		v1.scl(0.9f);
		System.out.println("Умножение на скаляр v1 = " + v1.x + " " + v1.y);

		v1 = new Vector2(2, 8);
		// |v1| = sqrt(x^2 + y^2)
		System.out.println("Длина v1 = " + v1.len());

		System.out.println("Нормализованны v1 = " + v1.nor());

		// v1(x1, y1) * v2(x2, y2) = x1*x2 + y1*y2
		v1 = new Vector2(1, 1);
		v2 = new Vector2(-1, 1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));
 */