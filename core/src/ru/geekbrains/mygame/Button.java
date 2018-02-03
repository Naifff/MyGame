package ru.geekbrains.mygame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.Sprite;

public class Button extends Sprite {

    public Button(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
//setWidthProportion(worldBounds.getWidth()*0.1f);
        setHeightProportion(worldBounds.getHeight()*0.05f);
        pos.set(worldBounds.pos);
        System.out.println("-------");
        System.out.println(worldBounds.getHeight());
        System.out.println(worldBounds.pos);
    }
}