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
    private int x=0;
    private int y=0;
    private int i=0;
private Vector2 centr;
private Vector2 mouse;
private Vector2 shipVectpr;
private Vector2 res;

    @Override
    public void show() {
        super.show();
//        Gdx.graphics.setResizable(false);
        Gdx.graphics.setTitle("Go Go Go");
        batch =new SpriteBatch();
        background=new Texture("1.png");
        ship = new Texture("2.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        if(i%10==0){
//            System.out.println(mouse.x+" "+mouse.y);
//            System.out.println(shipVectpr.x+" "+shipVectpr.y);
//            System.out.println("_________________________");
//            if(mouse.x-shipVectpr.x<1&&mouse.y-shipVectpr.y<1){
            res=(mouse.cpy().sub(shipVectpr)).nor().scl(4);
            shipVectpr=shipVectpr.cpy().add(res);
//            shipVectpr=new Vector2((int)shipVectpr.x,(int)shipVectpr.y);
//        }

           // System.out.println(xMid+"!!!!!!"+yMid);
//        }
//        i++;
//        if (i>10000){i=i%10;}
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
//		batch.setColor(0.11f,0.154f,0.241f,1);
        batch.draw(ship, shipVectpr.x, shipVectpr.y);
//		batch.draw(region, 100, 100);
        batch.end();
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
        x=screenX-ship.getWidth()/2;
        y=(Gdx.graphics.getHeight()-screenY)-ship.getHeight()/2;
        mouse=new Vector2(x,y);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        x=screenX-ship.getWidth()/2;
        y=(Gdx.graphics.getHeight()-screenY)-ship.getHeight()/2;
        mouse=new Vector2(xMid,yMid);
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        x=screenX-ship.getWidth()/2;
        y=(Gdx.graphics.getHeight()-screenY)-ship.getHeight()/2;
        mouse=new Vector2(x,y);
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public void resize(int width, int height) {

//        System.out.println( Gdx.graphics.getBackBufferWidth());
        xMid=width/2-ship.getWidth()/2;
        x=xMid;

        yMid=height/2-ship.getHeight()/2;
        y=yMid;
centr = new Vector2(x,y);
shipVectpr = new Vector2(x,y);
mouse =new Vector2(x,y);
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