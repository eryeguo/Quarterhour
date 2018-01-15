package pingan.com.quarter_hour.model;

import java.util.Map;

import io.reactivex.Flowable;
import pingan.com.quarter_hour.bean.VideoBean;
import pingan.com.quarter_hour.http.RetrofitUtil;
import pingan.com.quarter_hour.presenter.UserPresenter;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public class UserModel  implements IModel {

    private UserPresenter presenter;

    public UserModel(UserPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void getVideos(String url,String user,Map<String, String> map) {
        //热门视频
        Flowable<VideoBean> videos = RetrofitUtil.getInstant(url).getApiService().getVideos(user,map);
        presenter.getVideosa(videos);
    }

}
