package ru.geekbrains.mygame.Ships;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.mygame.engine.Sprite;
import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.math.Rnd;



public class Ship extends Sprite {
    private final Vector2 v = new Vector2();
    private Rect worldBounds;
    private final Vector2 vStatic = new Vector2(0, 0);
    private Vector2 currentVector;
    private float mouse=0;
    



    public Ship(TextureRegion region, float vx, float vy, float height) {
        super(region);
        v.set(vx, vy);
        setHeightProportion(height);
        currentVector = vStatic;

    }

    @Override
    public void update(float delta) {

        if(Math.abs(mouse- pos.x)<0.03){currentVector=vStatic;}
        pos.mulAdd(currentVector, delta);
        checkAndHandleBounds();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;


    }

    protected void checkAndHandleBounds() {
        if (getRight() > worldBounds.getRight()) setRight(worldBounds.getRight());
        if (getLeft() < worldBounds.getLeft()) setLeft(worldBounds.getLeft());
    }

    @Override
    public void touchDown(Vector2 touch, int pointer) {
        System.out.println("ships x="+pos.x);
        if (touch.x>pos.x){currentVector=v;
        mouse=touch.x;
        }else{currentVector=v.cpy().scl(-1f);mouse=touch.x;}
        super.touchDown(touch, pointer);
    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
        currentVector=vStatic;
        super.touchUp(touch, pointer);
    }

    @Override
    public void touchDragged(Vector2 touch, int pointer) {
        if (touch.x>getRight()){currentVector=v;mouse=touch.x;}else{currentVector=v.cpy().scl(-1f);mouse=touch.x;}
        super.touchDragged(touch, pointer);
    }
}
