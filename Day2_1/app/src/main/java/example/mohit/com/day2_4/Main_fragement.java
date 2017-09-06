package example.mohit.com.day2_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.mohit.com.day2_1.R;

public class Main_fragement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragement);
    }

    public void fragmentProcess(View v){

        Intent in=null;
        if(v.getId()==R.id.fragments1)
        {
            in=new Intent(this,fragementMainActivity.class);
            startActivity(in);

        }else if(v.getId()==R.id.fragments2){

            in=new Intent(this,FragmentUsingJava.class);
            startActivity(in);
        }else if(v.getId()==R.id.fragments3){

            in=new Intent(this,FragmentCommunication.class);
            startActivity(in);
        }else if(v.getId()==R.id.fragments4){

            in=new Intent(this,SlideTabs_main.class);
            startActivity(in);

        }else if(v.getId()==R.id.fragments5){
            in=new Intent(this,ScrollableTabs.class);
            startActivity(in);

        }else if(v.getId()==R.id.fragments6){
            in=new Intent(this,AppDrawer.class);
            startActivity(in);

        }else if(v.getId()==R.id.fragments7){

            in=new Intent(this,AppDrawerCustom.class);
            startActivity(in);

        }else if(v.getId()==R.id.fragments8){

        }else if(v.getId()==R.id.fragments9){

        }else if(v.getId()==R.id.fragments10){

        }
    }
}
