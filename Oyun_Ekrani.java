package com.example.emre.ismsehiroyunu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Oyun_Ekrani extends AppCompatActivity {
    public static TextView tv;
    public static TextView tv4;
    public static int puan = 0;
    int clickcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun__ekrani);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        final String b = bundle.getString("String");
        final char c = bundle.getChar("Char");
        final String s = Character.toString(c);
        tv2.setText(b);
        tv4 = (TextView) findViewById(R.id.textView4);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final EditText et3 = (EditText) findViewById(R.id.editText3);
        final EditText et4 = (EditText) findViewById(R.id.editText4);
        final EditText et5 = (EditText) findViewById(R.id.editText5);
        final EditText et6 = (EditText) findViewById(R.id.editText6);
        Button bt = (Button) findViewById(R.id.button3);

            bt.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          clickcount=clickcount+1;
                                          if(clickcount==1) {
                                              //first time clicked to do this
                                              Toast.makeText(getApplicationContext(), "Düğmeye 1 kere tıklama hakkınız vardır", Toast.LENGTH_LONG).show();
                                              new fetchData().execute(et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString(), et6.getText().toString(),s);
                                          }
                                          if (clickcount>1){

                                          }
                                      }
                                  }
            );

    }}



