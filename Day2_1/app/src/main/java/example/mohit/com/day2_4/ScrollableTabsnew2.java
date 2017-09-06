package example.mohit.com.day2_4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.mohit.com.day2_1.R;

/**
 * Created by MOHIT AGARWAL on 13-07-2017.
 */

public class ScrollableTabsnew2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.scrollabletabs_new2,container,false);
    }
}
