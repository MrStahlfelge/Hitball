package com.sdsmdg.cycle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.sdsmdg.cycle.chelpers.AssetLoader;
import com.sdsmdg.cycle.screens.SplashScreen;

import de.golfgl.gdxgamesvcs.IGameServiceClient;

public class CGame extends Game{

    private final String TAG = CGame.class.getSimpleName();
    public IGameServiceClient playServices;
    public AboutUs aboutUs;

    public CGame(IGameServiceClient playServices, AboutUs aboutUs) {
        this.playServices = playServices;
        this.aboutUs = aboutUs;
    }

    @Override
    public void create() {
        Gdx.app.log(TAG, "created");
        AssetLoader.load(Gdx.graphics.getWidth());
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        AssetLoader.dispose();
        super.dispose();
    }

    @Override
    public void resume() {
        super.resume();
        playServices.resumeSession();
    }

    @Override
    public void pause() {
        super.pause();
        playServices.pauseSession();
    }
}
