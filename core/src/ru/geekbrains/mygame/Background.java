package ru.geekbrains.mygame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.Sprite;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
