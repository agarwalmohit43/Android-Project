package example.mohit.com.day2_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.btn1);
        b2=(Button) findViewById(R.id.btn2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent in=null;
        if(view.getId()==R.id.btn1){
            //Toast.makeText(this,"Mohit",Toast.LENGTH_SHORT).show();

            in=new Intent(this,EditextExample.class);
            startActivity(in);
        }else if(view.getId()==R.id.btn2){
            //Toast.makeText(this,"Agarwal",Toast.LENGTH_SHORT).show();

            in=new Intent(this,AdaptersExample.class);
            startActivity(in);
        }
    }

    public void doSomething(View v){

        Intent in=null;
        if(v.getId()==R.id.btn3){
            in=new Intent(this,SecondPage.class);
            startActivity(in);
        }else if(v.getId()==R.id.btn4){
            in=new Intent(this,storagenavigation.class);
            startActivity(in);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        counter++;

        Toast.makeText(this,counter+" time",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("counter",counter);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counter=savedInstanceState.getInt("counter");
    }
}
