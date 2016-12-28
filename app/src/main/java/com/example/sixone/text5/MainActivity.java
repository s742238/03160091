package com.example.sixone.text5;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int m=0;
    String a_str_l,b_str_l,c_str_l,d_str_l,e_str_l,f_str_l,g_str_l,h_str_l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MCU Food Turntable");
        setSupportActionBar(toolbar);
        Button star = (Button) findViewById(R.id.star);
        Button me= (Button) findViewById(R.id.me);
        Button mont = (Button) findViewById(R.id.mont);
        Button input_bt = (Button) findViewById(R.id.input_bt);
        Button behind = (Button) findViewById(R.id.behind);
        final View turntable = findViewById(R.id.turntable);


        //取的intent中的bundle物件

        if (this.getIntent().getExtras() != null) {
            Bundle input_b =this.getIntent().getExtras();
            a_str_l =input_b.getString("a_str");
            b_str_l =input_b.getString("b_str");
            c_str_l =input_b.getString("c_str");
            d_str_l =input_b.getString("d_str");
            e_str_l=input_b.getString("e_str");
            f_str_l =input_b.getString("f_str");
            g_str_l =input_b.getString("g_str");
            h_str_l =input_b.getString("h_str");

        }


        final ValueAnimator animator = ValueAnimator.ofFloat(0, 1.0f);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        // ValueAnimator.INFINITE 無限重播
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                turntable.setRotation(m * value);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (m % 360 <= 44 && m % 360 >= 0) {
                    Toast.makeText(MainActivity.this, "來去吃 " + h_str_l, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 89 && m % 360 >= 45) {
                    Toast.makeText(MainActivity.this, "來去吃 " + g_str_l, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 134 && m % 360 >= 90) {
                    Toast.makeText(MainActivity.this, "來去吃 " + f_str_l, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 179 && m % 360 >= 135) {
                    Toast.makeText(MainActivity.this, "來去吃 " + e_str_l, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 224 && m % 360 >= 180) {
                    Toast.makeText(MainActivity.this, "來去吃 " + d_str_l, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 269 && m % 360 >= 225) {
                    Toast.makeText(MainActivity.this, "來去吃 " + c_str_l, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 314 && m % 360 >= 270) {
                    Toast.makeText(MainActivity.this, "來去吃 " + b_str_l, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 359 && m % 360 >= 315) {
                    Toast.makeText(MainActivity.this, "來去吃 " + a_str_l, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int n = (int) (Math.random() * 1500) + 360;
                m = n;
                turntable.setRotation(0);
                animator.start();
            }
        });

        mont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,  mont.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
        behind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this,behind.class);
                startActivity(intent2);
                MainActivity.this.finish();
            }
        });
        input_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this,input.class);
                startActivity(intent3);
                MainActivity.this.finish();

            }
        });

    }
}