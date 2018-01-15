package pingan.com.quarter_hour.fragment.RecommendFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.acyivity.WebViewActivity;
import pingan.com.quarter_hour.bean.BannerBean;
import pingan.com.quarter_hour.bean.HotVideoBean;
import pingan.com.quarter_hour.utils.BannerImageLoader;
import pingan.com.quarter_hour.y_interface.HttpIview;
import pingan.com.quarter_hour.y_presenter.HttpPresenter;

/**
 * Created by xsj on 2018/1/12.
 */

public class FieryFragment extends Fragment implements HttpIview {

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.recycle)
    RelativeLayout recycle;
    private HttpPresenter presenter;
    private List<String> bannerlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fiery_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);

        presenter = new HttpPresenter(this);

        //轮播的网络请求
        HashMap<String, String> map = new HashMap<>();
        presenter.getMap("https://www.zhaoapi.cn/", map, "轮播");

        //热门段子
        presenter.getMap("https://www.zhaoapi.cn/", map, "热门视频");

        return view;
    }

    //网络请求成功
    @Override
    public void success(Object o, String tag) {
        if (tag.equals("轮播")) {

            BannerBean bannerBean = (BannerBean) o;
            final List<BannerBean.DataBean> data = bannerBean.getData();
            for (int i = 0; i < data.size(); i++) {
                String icon = data.get(i).getIcon();
                bannerlist.add(icon);
            }

            //轮播
            banner.setImageLoader(new BannerImageLoader()); //自己建一个类
            banner.setImages(bannerlist); //自己建一个list集合放图片
            banner.setDelayTime(2000);//几秒切换一次图片
            banner.start();

            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("webviewUrl", data.get(position).getUrl() + "");
                    startActivity(intent);
                }
            });

        }

        if (tag.equals("热门视频")) {
            HotVideoBean hotVideoBean = (HotVideoBean) o;

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
        presenter.disAttach();
    }
}
