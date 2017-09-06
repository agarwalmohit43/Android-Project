package example.mohit.com.day2_4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import example.mohit.com.day2_1.R;

public class AppDrawerCustom extends Activity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    private Mycustomadapter adapterCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_drawer_custom);

        listView=(ListView) findViewById(R.id.appdrawer_custom_listView);
       // listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,weeks));
        adapterCustom=new Mycustomadapter(this);
        listView.setAdapter(adapterCustom);
        listView.setOnItemClickListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.appdrawer_custom_drawerLayout);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.dr,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(AppDrawerCustom.this,"Drawer Opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(AppDrawerCustom.this,"Drawer Closed",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView text=(TextView) view;
        Toast.makeText(this,text.getText()+" "+i,Toast.LENGTH_SHORT).show();
       // selectItem(i);
    }

    /*private void selectItem(int i) {
        listView.setItemChecked(i,true);
        setTitle(weeks[i]);
    }*/

    /*public void setTitle(String title){
        getActionBar().setTitle(title);
    }*/
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)//3line image
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}

class Mycustomadapter extends BaseAdapter{

    private Context context;
    String[] week;
    int[] images={R.drawable.dr,R.drawable.dr,R.drawable.dr,R.drawable.dr,R.drawable.dr,R.drawable.dr,R.drawable.dr};;

    public Mycustomadapter(Context context){
        this.context=context;
        week=context.getResources().getStringArray(R.array.Week);
    }
    @Override
    public int getCount() {
        return week.length;
    }

    @Override
    public Object getItem(int i) {
        return week[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View row=null;

        if(view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.activity_app_drawer_custom,viewGroup,false);

        }else{
            row=view;
        }
        TextView tv=(TextView) row.findViewById(R.id.appdrawer_custom_listViewdesign_textview);
        ImageView iv=(ImageView) row.findViewById(R.id.appdrawer_custom_listViewdesign_imageView);

        tv.setText(week[i]);
        iv.setImageResource(images[i]);
        return row;
    }
}
