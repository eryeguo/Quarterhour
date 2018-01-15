package pingan.com.quarter_hour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.fragment.video.NewFragment;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public class VideoFragment extends Fragment {
    private TabLayout tab;
    private ViewPager pa;
    private List<String> list=new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);

        //查找控件
        tab = (TabLayout) view.findViewById(R.id.tab);
        pa = (ViewPager) view.findViewById(R.id.pager);
        //tab的标题
        list.add("热门");
        list.add("附近");

        //tablayout和viewpager关联
        tab.setupWithViewPager(pa);
        //设置viewpager适配器
        pa.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            //重写这个方法，将设置每个Tab的标题
            @Override
            public CharSequence getPageTitle(int position) {

                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //一般我们在这个位置对比一下标题是什么,,,然后返回对应的fragment
                //初始化fragment  对应position有多少，fragment有多少
                NewFragment newFragment = new NewFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("热门")){
                    bundle.putString("name","getHotVideos");
                }else if (list.get(position).equals("附近")){
                    bundle.putString("name","getNearVideos");
                }
                //给fragment 加bundle 数据
                //activity与fragment 1.getset，2.接口回调，3.setArguments ,getAraguments
                newFragment.setArguments(bundle);
                return newFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        return view;
    }


}


