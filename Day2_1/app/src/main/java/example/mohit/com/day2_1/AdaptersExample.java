package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by MOHIT AGARWAL on 05-07-2017.
 */

public class AdaptersExample extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapterviews);
    }


    public void adapprocess(View view){

        Intent in=null;

        if(view.getId()==R.id.adapbtn1)
        {
            in=new Intent(this,listviewPage.class);
            startActivity(in);
        }else if(view.getId()==R.id.adapbtn2)
        {
            in=new Intent(this,ListviewImage.class);
            startActivity(in);
        }else if(view.getId()==R.id.adapbtn3)
        {
            in=new Intent(this,Gridview.class);
            startActivity(in);
        }else if(view.getId()==R.id.adapbtn4)
        {
            in=new Intent(this,SpinnerActivity.class);
            startActivity(in);

        }else if(view.getId()==R.id.adapbtn5)
        {
            in=new Intent(this,FramesThird.class);
            startActivity(in);

        }else if(view.getId()==R.id.adapbtn6)
        {
            in=new Intent(this,example.mohit.com.day2_4.Main_fragement.class);
            startActivity(in);
        }else if(view.getId()==R.id.adapbtn7)
        {
            in=new Intent(this,layoutinflater_activity.class);
            startActivity(in);
        }
    }
}
