package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDailog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydailog);

        Intent in=getIntent();
        if(in!=null){
            int imageid=in.getIntExtra("weekimage",R.drawable.ic_launcher);
           String weekName= in.getStringExtra("weekname");

            ImageView iv=(ImageView) findViewById(R.id.mydialogiamgeview);
            iv.setImageResource(imageid);

            TextView tv=(TextView) findViewById(R.id.mydialogtextview);
            tv.setText(weekName);
        }
    }

    public void dialogprocess(View v){
        finish();
    }
}
