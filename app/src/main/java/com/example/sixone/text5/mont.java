package com.example.sixone.text5;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sixone on 2016/12/20.
 */

public class mont extends AppCompatActivity {
    int m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mont);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MCU Food Turntable");
        setSupportActionBar(toolbar);
        Button star = (Button) findViewById(R.id.star);
        Button me= (Button) findViewById(R.id.me);
        Button mont = (Button) findViewById(R.id.mont);
        Button input_bt = (Button) findViewById(R.id.input_bt);
        Button behind = (Button) findViewById(R.id.behind);
        final View turntable = findViewById(R.id.turntable);

        final ValueAnimator animator = ValueAnimator.ofFloat(0, 1.0f);

        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        // ValueAnimator.INFINITE 無限重播
        // animator.setRepeatCount(ValueAnimator.INFINITE);
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
                String values = "";
                if (m % 360 <= 44 && m % 360 >= 0) {
                    values = "四海之家";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 89 && m % 360 >= 45) {
                    values = "北海道滷味";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 134 && m % 360 >= 90) {
                    values = "雙醬咖哩";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 179 && m % 360 >= 135) {
                    values = "天下第一羹";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 224 && m % 360 >= 180) {
                    values = "三杯滷味";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m% 360 <= 269 && m % 360 >= 225) {
                    values = "燒餃子";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 314 && m % 360 >= 270) {
                    values = "大台北";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
                } else if (m % 360 <= 359 && m % 360 >= 315) {
                    values = "羅媽媽";
                    Toast.makeText(mont.this, "來去吃 " + values, Toast.LENGTH_SHORT).show();
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

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mont.this,  MainActivity.class);
                startActivity(intent);
                mont.this.finish();
            }
        });
        behind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(mont.this,behind.class);
                startActivity(intent2);
                mont.this.finish();
            }
        });

    }
}