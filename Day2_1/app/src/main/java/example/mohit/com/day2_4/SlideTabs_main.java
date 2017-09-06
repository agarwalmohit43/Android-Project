package example.mohit.com.day2_4;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import example.mohit.com.day2_1.R;

public class SlideTabs_main extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewpgr;
    ActionBar actionBar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_tabs_main);

        viewpgr=(ViewPager)findViewById(R.id.slidetabviewpager);

        actionBar=getActionBar();
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("Slide Tabs");

        ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(this);

        ActionBar.Tab tab2=actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(this);

        ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("Tab 3");
        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);

        viewpgr.setAdapter(new slideTabAdapter(getSupportFragmentManager()));
        viewpgr.setOnPageChangeListener(new slideTabAdapteronpage());

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
       // Log.d("Mohit","onTabSelected at position "+ tab.getPosition()+" name "+tab.getText());
        viewpgr.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        Log.d("Mohit","onTabUnselected at position "+ tab.getPosition()+" name "+tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        Log.d("Mohit","onTabReselected at position "+ tab.getPosition()+" name "+tab.getText());
    }

    class slideTabAdapteronpage implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            actionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}


class slideTabAdapter extends FragmentStatePagerAdapter{

    public slideTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragobj=null;
        if(position==0){
            fragobj=new SlideTabs_new1();
        }else if(position==1){
            fragobj=new SlideTabs_new2();
        }else if(position==2){
            fragobj=new SlideTabs_new3();
        }
        return fragobj;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
