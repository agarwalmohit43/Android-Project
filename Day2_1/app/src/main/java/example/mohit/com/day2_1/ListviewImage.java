package example.mohit.com.day2_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MOHIT AGARWAL on 06-07-2017.
 */

public class ListviewImage extends Activity {

    ListView lv;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewimage);

        al.add("Sunday");
        al.add("Monday");
        al.add("Tuesday");
        al.add("Wednesday");
        al.add("Thursaday");
        al.add("Friday");
        al.add("Saturrday");
        al.add("Sunday");
        al.add("Monday");
        al.add("Tuesday");
        al.add("Wednesday");
        al.add("Thursaday");
        al.add("Friday");
        al.add("Saturrday");
        al.add("Sunday");
        al.add("Monday");
        al.add("Tuesday");
        al.add("Wednesday");
        al.add("Thursaday");
        al.add("Friday");
        al.add("Saturrday");
        al.add("Sunday");
        al.add("Monday");
        al.add("Tuesday");
        al.add("Wednesday");
        al.add("Thursaday");
        al.add("Friday");
        al.add("Saturrday");
        al.add("Sunday");
        al.add("Monday");
        al.add("Tuesday");
        al.add("Wednesday");
        al.add("Thursaday");
        al.add("Friday");
        al.add("Saturrday");

        lv=(ListView) findViewById(R.id.listviewimage);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.listviewimagesinglerow,R.id.listviewimagetextview,al);
        lv.setAdapter(adp);

    }

}
