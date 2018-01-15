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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.fragment.RecommendFragments.CareFragment;
import pingan.com.quarter_hour.fragment.RecommendFragments.FieryFragment;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public class RecommendFragment extends Fragment {

    @BindView(R.id.tas)
    TabLayout tas;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    //tablelayout的集合
    List<String> tabname = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, container, false);

        //ButterKnife寻找组件
        unbinder = ButterKnife.bind(this, view);

        //tablelayout上切换
        gettablelayout();

        return view;
    }

    public void gettablelayout(){

        tabname.add("热门");
        tabname.add("关注");

        //适配器
        vp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                //当选中的位置是对应的索引值的话 就加载那个Fragment
                switch (position) {
                    case 0:
                        fragment = new FieryFragment();
                        break;
                    case 1:
                        fragment = new CareFragment();
                        break;

                    default:
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            //设置tablelayout标题
            public CharSequence getPageTitle(int position) {
                return tabname.get(position);
            }
        });

        //进行关联
        tas.setupWithViewPager(vp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
