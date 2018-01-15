package pingan.com.quarter_hour.y_presenter;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import pingan.com.quarter_hour.bean.BannerBean;
import pingan.com.quarter_hour.bean.HotVideoBean;
import pingan.com.quarter_hour.view.IView;
import pingan.com.quarter_hour.y_interface.HttpIview;
import pingan.com.quarter_hour.y_model.HttpModel;

/**
 * Created by xsj on 2018/1/15.
 */

public class HttpPresenter {
    private HttpIview iv;
    private DisposableSubscriber<BannerBean> p1;

    public HttpPresenter(HttpIview iv) {
        this.iv = iv;
    }

    //获得网络请求的url
    public void getMap(String url,HashMap<String,String> map,String tag){
        HttpModel httpModel = new HttpModel(this);
        httpModel.getData(url,map,tag);
    }

    //获得Banner接口数据
    public void getBannerData(Flowable<BannerBean> flowable, final String tag){
        p1 = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iv.success(bannerBean, tag);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //获取热门视频
    public void getHotVideo(Flowable<HotVideoBean> flowable, final String tag){
        if(tag.equals("热门视频")){
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSubscriber<HotVideoBean>() {
                        @Override
                        public void onNext(HotVideoBean hotVideoBean) {
                            iv.success(hotVideoBean, tag);
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    //资源释放
    public void disAttach(){
        if(p1!=null){
            if(p1.isDisposed()){
                p1.dispose();
            }
        }
    }
}
