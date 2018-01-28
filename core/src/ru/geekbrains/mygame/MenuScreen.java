package ru.geekbrains.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.mygame.engine.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    public MenuScreen(Game game) {
        super(game);
    }

    private SpriteBatch batch;
    private Texture background;
    private Texture ship;
    private int xMid;
    private int yMid;
    private int x = 0;
    private int y = 0;
    private int i = 0;
    private int move = 5;
    private Vector2 centr;
    private Vector2 mouse;
    private Vector2 shipVectpr;
    private Vector2 res;
    private Vector2 levo = new Vector2(-1, 0);
    private int speed =3;


    @Override
    public void show() {
        super.show();
//        Gdx.graphics.setResizable(false);
        Gdx.graphics.setTitle("Go Go Go");
        batch = new SpriteBatch();
        background = new Texture("1.png");
        //ship = new Texture("2.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (Math.abs(mouse.x - shipVectpr.x) < 3 && Math.abs(mouse.y - shipVectpr.y) < 3) {
            shipVectpr = new Vector2(mouse.x, mouse.y);
        }
        res = (mouse.cpy().sub(shipVectpr)).nor().scl(speed);
        shipVectpr = shipVectpr.cpy().add(res);
        if (i % 10 == 0) {
            if (res.x * levo.x + res.y * levo.y > 0) {
                move--;
                if (move < 1) {
                    move = 1;
                }
            } else if (res.x * levo.x + res.y * levo.y < 0) {
                move++;
                if (move > 9) {
                    move = 9;
                }
            } else {
                if (move>5){move--;}
                if (move<5){move++;}
            }
            ship = moveShip(move);


        }
        i++;
        if (i > 10000) {
            i = i % 10;
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
//		batch.setColor(0.11f,0.154f,0.241f,1);
        batch.draw(ship, shipVectpr.x, shipVectpr.y);
//		batch.draw(region, 100, 100);
        batch.end();
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
        batch.dispose();
        background.dispose();
        ship.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        x = screenX - ship.getWidth() / 2;
        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
        mouse = new Vector2(x, y);
        if (button==0){speed=4;}else {speed=8;}
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        x = screenX - ship.getWidth() / 2;
        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
        mouse = new Vector2(xMid, yMid);
        speed =3;
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        x = screenX - ship.getWidth() / 2;
        y = (Gdx.graphics.getHeight() - screenY) - ship.getHeight() / 2;
        mouse = new Vector2(x, y);
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public void resize(int width, int height) {

//        System.out.println( Gdx.graphics.getBackBufferWidth());
        ship = new Texture("sh5.png");
        xMid = width / 2 - ship.getWidth() / 2;
        x = xMid;

        yMid = height / 2 - ship.getHeight() / 2;
        y = yMid;
        centr = new Vector2(x, y);
        shipVectpr = new Vector2(x, y);
        mouse = new Vector2(x, y);

//        System.out.println(ship.getWidth()+"_ship_"+ship.getHeight());
//        System.out.println(width+"_windiw_"+height);
//        System.out.println(xMid+"_center_"+yMid);
        super.resize(width, height);
    }
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