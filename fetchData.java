package com.example.emre.ismsehiroyunu;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by EMRE on 15/12/2017.
 */

public class fetchData extends AsyncTask<String, Void, String[]> {

    String data = "";
    String isim;
    String sehir2;
    String sehir="";
    String hayvan="";
    String hayvan2;
    String [] x= new String [5] ;
    String meyve="";
    String meyve2;
    String esya="";
    String esya2;
    String singleParsed = "";
    @Override
    protected String[] doInBackground(String... params) {
        try {
            URL url = new URL("https://api.myjson.com/bins/hexfr");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while (line != null) {
            line = bufferedReader.readLine();
            data =data + line;
        }
        JSONArray JA = new JSONArray(data);

        try{
            isim=params[0].substring(5,6).trim();
           }
            catch (StringIndexOutOfBoundsException a){
            isim="a";
        }


            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = JO.get("name").toString();
                singleParsed.trim();
                if (isim.equals(params[5]) && params[0].equals("İsim:"+singleParsed)){
                    x[0]="true";
                    Log.w("if bloğu","if bloğuna girildi.");
                    break;
                }
                else{
                    x[0]="false";
                }
            }
            String [] y= new String [67];
            ArrayList <String> dizi =new ArrayList <String>();
            String [] a= new String [23];
            String [] b= new String [23];
            String [] c= new String [23];
            for (int i=0;i<67;i++)
            {
                JSONObject JO2=(JSONObject) JA.get(i);
                y[i]=JO2.get("il").toString();
            }

            try{
                sehir2=params[1].substring(6,7).trim();
            }
            catch (StringIndexOutOfBoundsException z){
                sehir2="a";
            }
            for (int i=0;i<67;i++) {
                if (sehir2.equals(params[5]) && params[1].equals("Şehir:" + y[i])) {
                    x[1] = "true";
                    Log.w("ŞEhir if bloğu", "if bloğuna girildi.");
                    break;
                } else {
                    x[1] = "false";
                    Log.w("ŞEhir else bloğu", "else bloğuna girildi.");
                }
            }
        for (int i=0;i<23;i++)
        {
            JSONObject JO2=(JSONObject) JA.get(i);
            a[i]=JO2.get("hayvan").toString();
            b[i]=JO2.get("meyve").toString();
            c[i]=JO2.get("eşya").toString();
        }

            try{
                hayvan2=params[2].substring(7,8).trim();
            }
            catch (StringIndexOutOfBoundsException z){
                hayvan2="a";
            }
            for (int i=0;i<23;i++) {
                if (hayvan2.equals(params[5]) && params[2].equals("Hayvan:" + a[i])) {
                    x[2] = "true";
                    Log.w("Hayvan if bloğu", "if bloğuna girildi.");
                    break;
                } else {
                    x[2] = "false";
                    Log.w("Hayvan else bloğu", "else bloğuna girildi.");
                }
            }

            try{
                meyve2=params[3].substring(6,7).trim();
            }
            catch (StringIndexOutOfBoundsException z){
                meyve2="a";
            }
            for (int i=0;i<23;i++) {
                if (meyve2.equals(params[5]) && params[3].equals("Meyve:" + b[i])) {
                    x[3] = "true";
                    Log.w("Meyve if bloğu", "if bloğuna girildi.");
                    break;
                } else {
                    x[3] = "false";
                    Log.w("Meyve else bloğu", "else bloğuna girildi.");
                }
            }


            try{
                esya2=params[4].substring(5,6).trim();
            }
            catch (StringIndexOutOfBoundsException z){
                esya2="a";
            }
            for (int i=0;i<23;i++) {
                if (esya2.equals(params[5]) && params[4].equals("Eşya:" + c[i])) {
                    x[4] = "true";
                    Log.w("Eşya if bloğu", "if bloğuna girildi.");
                    break;
                }
                else {
                    x[4] = "false";
                    Log.w("Eşya else bloğu", "else bloğuna girildi.");
                }
            }

        } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
        return x;
}
    @Override
    protected void onPostExecute(String [] x) {
        for (int i=0;i<5;i++){
            if (x[i].equals("true")){
                Oyun_Ekrani.puan+=10;
            }
            if (x[i].equals("false"))
            {
                Oyun_Ekrani.puan+=0;
            }

        //}
        Oyun_Ekrani.tv4.setText("PUANINIZ: "+Integer.toString(Oyun_Ekrani.puan));
    }
}}


