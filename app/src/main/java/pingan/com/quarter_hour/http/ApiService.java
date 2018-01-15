package pingan.com.quarter_hour.http;

import java.util.Map;

import io.reactivex.Flowable;
import pingan.com.quarter_hour.bean.BannerBean;
import pingan.com.quarter_hour.bean.HotVideoBean;
import pingan.com.quarter_hour.bean.VideoBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public interface ApiService {

    //视频热门接口：https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=101&token=1
    @GET("quarter/{user}")
    Flowable<VideoBean> getVideos(@Path("user") String user,@QueryMap Map<String,String> map);

    //轮播的接口
    @GET("quarter/getAd")
    Flowable<BannerBean> getBanner();

    //热门视频
    @GET("quarter/getHotVideos")
    Flowable<HotVideoBean> getHotVideos();
}
