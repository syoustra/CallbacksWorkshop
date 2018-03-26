package com.example.android.callbacksworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass {

    @BindView(R.id.callback_message_textview)
    protected TextView callbackMessageTextview;

    @BindView(R.id.activity_layout)
    protected ConstraintLayout activityLayout;
    private CallbackFragment callbackFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.fragment_launcher_button)
    protected void fragmentLauncherButtonClicket() {

        callbackFragment = CallbackFragment.newInstance();

        callbackFragment.attachParent(this);                    //or can do MainActivity.this

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, callbackFragment).commit();

    }



    @Override
    public void showToast() {
        Toast.makeText(this, "The Main Activity is toasting the fragment", Toast.LENGTH_LONG).show();
    }

    @Override
    public void changeTextview() {
        callbackMessageTextview.setText("Callback Received");

    }

    @Override
    public void changeBackgroundColor() {
        activityLayout.setBackgroundColor(Color.CYAN);

    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();

    }
}
