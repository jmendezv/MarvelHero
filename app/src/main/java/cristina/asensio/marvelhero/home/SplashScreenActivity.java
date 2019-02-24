package cristina.asensio.marvelhero.home;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cristina.asensio.marvelhero.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int TWO_SECONDS_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, TWO_SECONDS_DELAY);
    }
}
