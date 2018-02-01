package ru.geekbrains.mygame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.geekbrains.mygame.My2DGame;
import ru.geekbrains.mygame.MyGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//        config.width = 360;
//        config.height = 640;
//		config.foregroundFPS=60;

        new LwjglApplication(new My2DGame(), config);
    }
}
