package example.mohit.com.day2_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by dbcent31 on 7/4/17.
 */

public class FramesThird extends Activity implements View.OnClickListener{


    ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelay);
        iv1=(ImageView) findViewById(R.id.imageView);
        iv2=(ImageView) findViewById(R.id.imageView2);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageView){
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.VISIBLE);
            Toast.makeText(this, "IV1 Gone", Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.imageView2) {
            iv2.setVisibility(View.GONE);
            iv1.setVisibility(View.VISIBLE);
            Toast.makeText(this, "IV2 Gone", Toast.LENGTH_SHORT).show();
        }

    }
}
