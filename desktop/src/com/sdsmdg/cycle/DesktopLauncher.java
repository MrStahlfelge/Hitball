package com.sdsmdg.cycle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.golfgl.gdxgamesvcs.NoGameServiceClient;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 640;
        config.height = 960;
        new LwjglApplication(new CGame(new NoGameServiceClient(), null), config);
    }


}
