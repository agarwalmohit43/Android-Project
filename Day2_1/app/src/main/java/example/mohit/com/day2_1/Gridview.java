package example.mohit.com.day2_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MOHIT AGARWAL on 06-07-2017.
 */

public class Gridview extends Activity implements AdapterView.OnItemClickListener {

    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        gv =(GridView) findViewById(R.id.gridview1);
        gv.setAdapter(new adap(this));
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in=new Intent(this,MyDailog.class);

        adapview hold=(adapview) view.getTag();
        Week temp=(Week) hold.iv.getTag();
        in.putExtra("weekimage",temp.imageId);
        in.putExtra("weekname",temp.countryName);
        startActivity(in);


    }
}

class Week{

    int imageId;String countryName;
    Week(int imageId,String countryName){
        this.imageId=imageId;
        this.countryName=countryName;
    }
}

class adapview
{
    ImageView iv;
    adapview(View v)
    {
        iv=(ImageView) v.findViewById(R.id.gridviewimageview);
    }
}

class adap extends BaseAdapter{

    ArrayList<Week> al;
    Context context;
    adap(Context context)
    {
        this.context=context;
        al=new ArrayList<Week>();
        Resources res=context.getResources();
        String[] week=res.getStringArray(R.array.Week);
        int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
        for(int i=0;i<7;i++){
            Week wk=new Week(images[i],week[i]);
            al.add(wk);
        }
    }
    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int i) {
        return al.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row=view;
        adapview adapviews;
        if(row==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.gridviewsinglerow,viewGroup,false);
            adapviews=new adapview(row);
            row.setTag(adapviews);
        }else{
            adapviews=(adapview) row.getTag();
        }
        Week temp=al.get(i);
        adapviews.iv.setImageResource(temp.imageId);
        adapviews.iv.setTag(temp);
        return row;
    }
}