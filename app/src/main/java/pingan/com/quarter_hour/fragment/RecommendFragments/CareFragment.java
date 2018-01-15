package pingan.com.quarter_hour.fragment.RecommendFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pingan.com.quarter_hour.R;

/**
 * Created by xsj on 2018/1/12.
 */

public class CareFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.care_fragment, container, false);

        return view;
    }
}
