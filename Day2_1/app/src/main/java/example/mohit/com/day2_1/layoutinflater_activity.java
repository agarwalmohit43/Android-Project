package example.mohit.com.day2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class layoutinflater_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutinflater_activity);
        LayoutInflater l=getLayoutInflater();
        LinearLayout linear=(LinearLayout) findViewById(R.id.layoutinflaterLinear);
        View v=l.inflate(R.layout.layoutinflator_sublayout,linear,false);
        FrameLayout fv=(FrameLayout) findViewById(R.id.layoutinflaterframe);
        fv.addView(v);

    }
}
