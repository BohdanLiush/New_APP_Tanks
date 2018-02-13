package com.example.bohdan.new_app_tanks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start;
    Button tank_1;
    Button tank_2;
    TextView expression_1;
    TextView expression_2;
    TextView expression_3;
    int image = R.drawable.jack_s;
    int image2 = R.drawable.jordan;
    ImageView imageView;
    ImageView imageView2;
    Tank tank, tank1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button2);
        tank_1 = findViewById(R.id.button3);
        tank_2 = findViewById(R.id.button4);
        expression_1 = findViewById(R.id.textView);
        expression_2 = findViewById(R.id.textView2);
        //expression_3 = findViewById(R.id.textView3);
        imageView = findViewById(R.id.imageView3);
        imageView2 = findViewById(R.id.imageView4);

        // програмуєм самі кнопки - старт
       /* View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression_3.setText("the winner is..."); // кнопка старт // при нажиманні цьої кнопки має пройти весь цикл програми і має вивести в кінці переможця
            }
        };*/
        //start.setOnClickListener(onClickListener);

        // кнопка танк - 1
        View.OnClickListener onClickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression_2.setText("fight tanks...");  // тут має прописатись кількість здоровя що залишається
            }
        };
        tank_1.setOnClickListener(onClickListener2);

        // кнопка танк - 2
        View.OnClickListener onClickListener1_1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression_1.setText("count shoots...");  // тут має прописатись кількість пострілів що залишається
            }
        };
        tank_1.setOnClickListener(onClickListener1_1);

        // при нажиманні на картинку переходим до другого актівіті
        View.OnClickListener onClickListener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageView3:
                        Intent intent = new Intent(MainActivity.this, ActivityTWO.class);
                        startActivity(intent);
                }
            }
        };
        // аналогічно як і при попередній картинці при нажиманні на картинку переходим до другого актівіті
                View.OnClickListener onClickListener4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageView4:
                        Intent intent = new Intent(MainActivity.this, ActivityTWO.class);
                        startActivity(intent);
                }
            }
        };

        // джерело картинок
        imageView.setImageResource(image);
        imageView2.setImageResource(image2);

        // програмуванні setOnClickListener по картинкам
        imageView.setOnClickListener(onClickListener3);
        imageView2.setOnClickListener(onClickListener4);

    }
     public void starter(View view) throws InterruptedException {
         expression_3 = findViewById(R.id.textView3);

         System.out.println("Hello");
         final MiddleTank tank0 = new MiddleTank("one");
         final MiddleTank tank1 = new MiddleTank("two");

         Thread t = new Thread(new Runnable() {
             public void run() {
                 while (tank0.endurance > 0 && tank1.endurance > 0) {
                     System.out.println("Player 1 health: " + tank0.endurance + " ***  Player 2 health: " + tank1.endurance);
                     tank0.fireTank(tank1);
                     try {
                         Thread.sleep(500);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 if (tank0.endurance > 0)

                     System.out.println("The winner is: " + tank0.name);
//                     expression_3.setText("The winner is: " + tank0.name);
             }
         });

         t.start();


         Thread p  =  new Thread(new Runnable() {
             public void run() {
                 while (tank0.endurance > 0 && tank1.endurance > 0) {
                     System.out.println("Player 1 health: " + tank0.endurance + " ***  Player 2 health: " + tank1.endurance);
                     System.out.println("------------------------");
                     tank1.fireTank(tank0);
                     try {
                         Thread.sleep(500);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println("------------------------ * ---------------------------");
                 if (tank1.endurance > 0)
                     System.out.println("The winner is: " + tank1.name);
                     //expression_3.setText("The winner is: " + tank1.name);
             }
         });

         p.start();
         t.join();
         p.join();
         if (tank0.endurance > 0)
             expression_3.setText("The winner is: " + tank0.name);
         else if (tank1.endurance > 0)
             expression_3.setText("The winner is: " + tank1.name);

         /*runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 if (tank0.endurance > 0)
                     expression_3.setText("The winner is: " + tank0.name);
                 else if (tank1.endurance > 0)
                     expression_3.setText("The winner is: " + tank1.name);

             }
         });*/
     }
}

