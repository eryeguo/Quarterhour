package pingan.com.quarter_hour.y_model;

import java.util.HashMap;

import io.reactivex.Flowable;
import pingan.com.quarter_hour.bean.BannerBean;
import pingan.com.quarter_hour.bean.HotVideoBean;
import pingan.com.quarter_hour.bean.VideoBean;
import pingan.com.quarter_hour.http.ApiService;
import pingan.com.quarter_hour.http.RetrofitUtil;
import pingan.com.quarter_hour.y_presenter.HttpPresenter;

/**
 * Created by xsj on 2018/1/15.
 */

public class HttpModel {

    private HttpPresenter presenter;

    public HttpModel(HttpPresenter presenter) {
        this.presenter = presenter;
    }

    public void getData(String url,HashMap<String,String> map,String tag){
        if(tag.equals("轮播")){
            ApiService apiService = RetrofitUtil.getInstant(url).getApiService();
            Flowable<BannerBean> banner = apiService.getBanner();
            presenter.getBannerData(banner,tag);
        }

        if(tag.equals("热门视频")){
            ApiService apiService = RetrofitUtil.getInstant(url).getApiService();
            Flowable<HotVideoBean> hotVideos = apiService.getHotVideos();
            presenter.getHotVideo(hotVideos,tag);
        }
    }
}
