package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Internalstorage2nd extends Activity {

    TextView unametext,passtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage2nd);
        unametext=(TextView) findViewById(R.id.Internalstorage2nduname);
        passtext=(TextView) findViewById(R.id.Internalstorage2ndpass);
    }

    public void Internalstorage2ndLoad(View view){

        FileInputStream fos=null;
        int splitPos;
        try {
            fos= openFileInput("Mohit.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while((read=fos.read())!=-1){
                buffer.append((char)read);
            }
            splitPos=buffer.indexOf(" ");
            String uname=buffer.substring(0,splitPos);
            String Pass=buffer.substring(splitPos+1);
            unametext.setText(uname);
            passtext.setText(Pass);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Internalstorage2ndprevious(View view){
        Intent in=new Intent(this,Internalstorage1st.class);
        startActivity(in);
    }
}
