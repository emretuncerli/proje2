package com.example.emre.ismsehiroyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static char randoms(){
        Random k=new Random();
        char x=(char)(65+k.nextInt(25));
        return x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et=(EditText) findViewById(R.id.editText);
        Button bt=(Button) findViewById(R.id.button);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Oyun_Ekrani.class);
                char a = randoms();
                i.putExtra("String", et.getText().toString() + "\n\n" + "Rastgele harfiniz: " +a);
                i.putExtra("Char", a);
                startActivity(i);

            }
        });

    }
}

