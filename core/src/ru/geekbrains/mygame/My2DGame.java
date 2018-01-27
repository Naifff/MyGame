package ru.geekbrains.mygame;

import com.badlogic.gdx.Game;

public class My2DGame extends Game{
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
