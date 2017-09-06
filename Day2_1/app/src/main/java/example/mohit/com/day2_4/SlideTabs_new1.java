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

public class SlideTabs_new1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.slidetabs_new1,container,false);
    }
}
