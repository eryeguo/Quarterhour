package pingan.com.quarter_hour.presenter;

import android.util.Log;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import pingan.com.quarter_hour.bean.VideoBean;
import pingan.com.quarter_hour.model.IModel;
import pingan.com.quarter_hour.model.UserModel;
import pingan.com.quarter_hour.view.IView;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public class UserPresenter implements IPresenter {

    private static final String TAG = "UserPresenter";
    private IView iv;
    private DisposableSubscriber<VideoBean> disposableSubscriber;

    public void attachView(IView iv) {
        this.iv = iv;
    }

    public void delete(){
        if (iv!=null){
            iv=null;
        }
        if (disposableSubscriber!=null){
            if (disposableSubscriber.isDisposed()){
                disposableSubscriber.dispose();
            }
        }
    }


    @Override
    public void getVideos(String url,String user,Map<String, String> map) {
        //热门视频
        IModel model=new UserModel(this);
        model.getVideos(url,user,map);

    }


    //热门视频
    public void getVideosa(Flowable<VideoBean> videos){

        disposableSubscriber = videos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<VideoBean>() {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        if (videoBean != null) {
                            String msg = videoBean.getMsg();
                            Log.d("zzz",msg);
                            List<VideoBean.DataBean> data = videoBean.getData();
//                            Log.i(TAG, "视频P层解析onNext: "+data.size());
                            if (data!= null) {
                                iv.success(data);
                                Log.i(TAG, "视频P层解析onNext: "+data.size());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                     iv.Failes(new Exception(t));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
