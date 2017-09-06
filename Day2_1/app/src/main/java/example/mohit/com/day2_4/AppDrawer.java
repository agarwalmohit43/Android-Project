package example.mohit.com.day2_4;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import example.mohit.com.day2_1.R;

public class AppDrawer extends Activity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] weeks;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_drawer);

        weeks=getResources().getStringArray(R.array.Week);
        listView=(ListView) findViewById(R.id.appdrawerlistview);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,weeks));
        listView.setOnItemClickListener(this);


        drawerLayout = (DrawerLayout) findViewById(R.id.appdrawer_drawerLayout);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.dr,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(AppDrawer.this,"Drawer Opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(AppDrawer.this,"Drawer Closed",Toast.LENGTH_SHORT).show();
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
        selectItem(i);
    }

    private void selectItem(int i) {
        listView.setItemChecked(i,true);
        setTitle(weeks[i]);
    }

    public void setTitle(String title){
        getActionBar().setTitle(title);
    }

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
