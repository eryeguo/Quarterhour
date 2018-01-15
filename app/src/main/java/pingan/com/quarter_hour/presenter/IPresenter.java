package pingan.com.quarter_hour.presenter;

import java.util.Map;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public interface IPresenter {
    void getVideos(String url,String user,Map<String, String> map);
    //void getVideos(String url,Map<String, String> map);
}
