package com.example.sixone.text5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sixone on 2016/12/20.
 */

public class input extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MCU Food Turntable");
        setSupportActionBar(toolbar);
        Button bt = (Button) findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText a_edit = (EditText) findViewById(R.id.a_edit);
                EditText b_edit = (EditText) findViewById(R.id.b_edit);
                EditText c_edit = (EditText) findViewById(R.id.c_edit);
                EditText d_edit = (EditText) findViewById(R.id.d_edit);
                EditText e_edit = (EditText) findViewById(R.id.e_edit);
                EditText f_edit = (EditText) findViewById(R.id.f_edit);
                EditText g_edit = (EditText) findViewById(R.id.g_edit);
                EditText h_edit = (EditText) findViewById(R.id.h_edit);

                String a_str =a_edit.getText().toString();
                String b_str =b_edit.getText().toString();
                String c_str =c_edit.getText().toString();
                String d_str =d_edit.getText().toString();
                String e_str =e_edit.getText().toString();
                String f_str =f_edit.getText().toString();
                String g_str =g_edit.getText().toString();
                String h_str =h_edit.getText().toString();

                Intent intent5 = new Intent();
                intent5.setClass(input.this, MainActivity.class);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                bundle.putString("a_str",a_str );
                bundle.putString("b_str",b_str );
                bundle.putString("c_str",c_str );
                bundle.putString("d_str",d_str );
                bundle.putString("e_str",e_str );
                bundle.putString("f_str",f_str );
                bundle.putString("g_str",g_str );
                bundle.putString("h_str",h_str );

                //將Bundle物件assign給intent
                intent5.putExtras(bundle);

                //切換Activity
                startActivity(intent5);
                input.this.finish();

            }
            });

    }


}
