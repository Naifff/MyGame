package ru.geekbrains.mygame.ui;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.mygame.engine.ActionListener;
import ru.geekbrains.mygame.engine.math.Rect;
import ru.geekbrains.mygame.engine.ui.ScaledTouchUpButton;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, float pressScale, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), pressScale, actionListener);
    }

    public ButtonExit(TextureRegion region, float pressScale, ActionListener actionListener) {
        super(region, pressScale, actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom()+0.05f);
        setRight(worldBounds.getRight()-0.05f*worldBounds.getWidth());
    }
}
