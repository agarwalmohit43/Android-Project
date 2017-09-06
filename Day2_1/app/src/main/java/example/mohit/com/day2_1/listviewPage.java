package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MOHIT AGARWAL on 05-07-2017.
 */

public class listviewPage extends Activity implements AdapterView.OnItemClickListener{

    ListView listView1;

    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview1);


        Resources res=getResources();
        data=res.getStringArray(R.array.WeekRepeated);

        listView1=(ListView) findViewById(R.id.listview1);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView text=(TextView) view;
        Toast.makeText(this,text.getText()+" "+i,Toast.LENGTH_SHORT).show();
    }
}
