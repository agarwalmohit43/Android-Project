package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Internalstorage1st extends Activity {

    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage1st);
        uname=(EditText) findViewById(R.id.Internalstorage1stuname);
        pass= (EditText) findViewById(R.id.Internalstorage1stpass);
    }

    public void Internalstorage1stsave(View view) throws FileNotFoundException {

        FileOutputStream fos=null;
        File file=null;
        String username=uname.getText().toString();
        String password=pass.getText().toString();

        username+=" ";
        try{
          //  file.getAbsolutePath();
           fos= openFileOutput("Mohit.txt", Context.MODE_PRIVATE);

            fos.write(username.getBytes());
            fos.write(password.getBytes());

            fos.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void Internalstorage1stnext(View view){


        Intent in=new Intent(this,Internalstorage2nd.class);
        startActivity(in);
    }
}
