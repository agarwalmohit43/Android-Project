package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import example.mohit.com.day2_3.InsertMain2Activity;

public class storagenavigation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storagenavigation);
    }

    public void storageProcess(View view){

        Intent in=null;

        if(view.getId()==R.id.storageBtn1){
            in=new Intent(this,SharedPrefernce1st.class);
            startActivity(in);
        }else if(view.getId()==R.id.storageBtn2){
            in=new Intent(this,Internalstorage1st.class);
            startActivity(in);
        }
        else if(view.getId()==R.id.storageBtn3){
            in=new Intent(this,example.mohit.com.day2_2.SqlMain2Activity.class);
            startActivity(in);
        }
        else if(view.getId()==R.id.storageBtn4){
            in=new Intent(this,InsertMain2Activity.class);
            startActivity(in);
        }
        else if(view.getId()==R.id.storageBtn5){

        }
        else if(view.getId()==R.id.storageBtn6){

        }
        else if(view.getId()==R.id.storageBtn7){

        }
    }
}
