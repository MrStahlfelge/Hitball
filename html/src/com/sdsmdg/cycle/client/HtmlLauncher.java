package com.sdsmdg.cycle.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.backends.gwt.preloader.Preloader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Panel;
import com.sdsmdg.cycle.AboutUs;
import com.sdsmdg.cycle.CGame;

import de.golfgl.gdxgamesvcs.KongClient;
import de.golfgl.gdxgamesvcs.NoGameServiceClient;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        GwtApplicationConfiguration gwtApplicationConfiguration = new GwtApplicationConfiguration(640, 900);
        gwtApplicationConfiguration.usePhysicalPixels = true;
        return gwtApplicationConfiguration;
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new CGame(new KongClient(), null);
    }

    @Override
    public Preloader.PreloaderCallback getPreloaderCallback() {
        return createPreloaderPanel(GWT.getHostPageBaseURL() + "preload.png");
    }

    @Override
    protected void adjustMeterPanel(Panel meterPanel, Style meterStyle) {
        meterPanel.setStyleName("gdx-meter");
        meterPanel.addStyleName("nostripes");
        Style meterPanelStyle = meterPanel.getElement().getStyle();
        meterStyle.setProperty("backgroundColor", "#ff0000");
        meterStyle.setProperty("backgroundImage", "none");
    }
}