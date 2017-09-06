package example.mohit.com.day2_4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.mohit.com.day2_1.R;

public class ScrollableTabs extends FragmentActivity {

    ViewPager vpgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        vpgr=(ViewPager) findViewById(R.id.scrollabletabs_Viewpager);
        FragmentManager manager=getSupportFragmentManager();
        vpgr.setAdapter(new scrollAdapter(manager));
    }

    //FragmentPagerAdapter doesnot call onSavedInstance method
    class scrollAdapter extends FragmentStatePagerAdapter {
        public scrollAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragobj=null;
             if(position==0){
                fragobj=new ScrollableTabsnew1();
             }else if(position==1){
                 fragobj=new ScrollableTabsnew2();
             }else if(position==2){
                 fragobj=new ScrollableTabsnew3();
             }
            return fragobj;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0){
                return "Tab 1";
            }else if(position==1){
                return "Tab 2";
            }else if(position==2){
                return "Tab 3";
            }

            return "Tab";
        }
    }
}
