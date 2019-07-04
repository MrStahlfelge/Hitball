package com.sdsmdg.cycle.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.sdsmdg.cycle.AboutUs;
import com.sdsmdg.cycle.CGame;

import de.golfgl.gdxgamesvcs.KongClient;
import de.golfgl.gdxgamesvcs.NoGameServiceClient;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        GwtApplicationConfiguration gwtApplicationConfiguration = new GwtApplicationConfiguration(640, 960);
        gwtApplicationConfiguration.usePhysicalPixels = true;
        return gwtApplicationConfiguration;
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new CGame(new KongClient(), null);
    }
}