package dotcom.com.sam.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dotcom.com.sam.R;
import dotcom.com.sam.Utils.Utils;


/**
 * Created by sanjay on 11/10/2017.
 */

public class CheckInternetScreen extends AppCompatActivity {

    Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_internet);
        tryAgain = (Button) findViewById(R.id.try_again);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Utils.isOnline(getApplicationContext()))
                {
                    finish();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(Utils.isOnline(getApplicationContext()))
        {
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        finish();
    }
}
