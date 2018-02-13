package com.example.bohdan.new_app_tanks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityTWO extends AppCompatActivity {

    Button back;
    int image = R.drawable.mack;
    int image2 = R.drawable.oneal;
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        back = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView.setImageResource(image);
        imageView2.setImageResource(image2);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Intent intent = new Intent(ActivityTWO.this, MainActivity.class);
                        startActivity(intent);
                }
            }
        };
        back.setOnClickListener(onClickListener);
    }
}
