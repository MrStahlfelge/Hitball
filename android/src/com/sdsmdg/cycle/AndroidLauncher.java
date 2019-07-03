package com.sdsmdg.cycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.sdsmdg.ball.R;

import de.golfgl.gdxgamesvcs.GpgsClient;
import de.golfgl.gdxgamesvcs.IGameServiceIdMapper;

public class AndroidLauncher extends AndroidApplication implements AboutUs {

    private final static int requestCode = 1;
    private static String TAG = AndroidLauncher.class.getSimpleName();
    private GpgsClient gpgsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout layout = new RelativeLayout(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
        );

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        //Game View
        gpgsClient = new GpgsClient().initialize(this, false);
        View gameView = initializeForView(new CGame(gpgsClient, this), config);
        layout.addView(gameView);

        setContentView(layout);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (gpgsClient != null)
            gpgsClient.onGpgsActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick() {
        Intent i = new Intent(this, AboutUsActivity.class);
        startActivity(i);
    }

    private void setupMapper() {
        gpgsClient.setGpgsLeaderboardIdMapper(new IGameServiceIdMapper<String>() {
            @Override
            public String mapToGsId(String independantId) {
                switch (independantId) {
                    case PlayServices.ACH_BEGINNER:
                        return getString(R.string.achievement_beginner);
                    case PlayServices.ACH_BORED:
                        return getString(R.string.achievement_bored);
                    case PlayServices.ACH_SILVER:
                        return getString(R.string.achievement_silver_jubilee);
                    case PlayServices.ACH_DECADE:
                        return getString(R.string.achievement_decade);
                    case PlayServices.ACH_GOD:
                        return getString(R.string.achievement_you_are_the_god);
                    case PlayServices.ACH_INTOHEAVEN:
                        return getString(R.string.achievement_into_the_heavens);
                    case PlayServices.ACH_HALFCENT:
                        return getString(R.string.achievement_half_century);
                    case PlayServices.ACH_CENT:
                        return getString(R.string.achievement_century);
                    case PlayServices.ACH_TRICKY:
                        return getString(R.string.achievement_the_tricky_one);
                    case PlayServices.ACH_TWO:
                        return getString(R.string.achievement_welcome_to_the_2_group);
                }

                return null;
            }
        })
                .setGpgsAchievementIdMapper(new IGameServiceIdMapper<String>() {
                    @Override
                    public String mapToGsId(String independantId) {
                        return getString(R.string.leaderboard_leaderboard);
                    }
                });
    }
}
