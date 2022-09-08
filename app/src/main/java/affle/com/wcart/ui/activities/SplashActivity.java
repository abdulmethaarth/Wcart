package affle.com.wcart.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import affle.com.wcart.R;
import affle.com.wcart.preference.PreferenceKeys;
import affle.com.wcart.utils.AppUtilMethods;

public class SplashActivity extends BaseActivity {

    private static final long DURATION_SPLASH = 1500;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        super.initData();
        AppUtilMethods.generateFBKeyHash(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAppSharedPreference.getBoolean(PreferenceKeys.KEY_LOGGED_IN, false)) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, TutorialActivity.class));
                    finish();
                }
            }
        }, DURATION_SPLASH);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initVariables() {
        mHandler = new Handler();
    }

    @Override
    public void onClick(View view) {
    }
}
