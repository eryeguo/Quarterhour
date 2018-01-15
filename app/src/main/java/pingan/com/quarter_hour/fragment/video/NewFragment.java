package pingan.com.quarter_hour.fragment.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.adpater.G_Video_RecuclerView;
import pingan.com.quarter_hour.bean.VideoBean;
import pingan.com.quarter_hour.presenter.UserPresenter;
import pingan.com.quarter_hour.view.IView;

import static android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL;

/**
 * Created by 迷人的脚毛！！ on 2018/1/10.
 */

public class NewFragment extends Fragment implements IView{

    private static final String TAG = "NewFragment";
    private RecyclerView recy;
    private UserPresenter userPresenter;
    private String url="https://www.zhaoapi.cn/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //找到布局文件
              View v = View.inflate(getActivity(), R.layout.video_one, null);
        //ListView控件
        recy = (RecyclerView) v.findViewById(R.id.recy);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        //接收传递过来的值
        String string = bundle.getString("name", "getHotVideos");
        //调用解析方法
        Jiexi(string);

    }

    private void Jiexi(String string) {
        userPresenter = new UserPresenter();
        userPresenter.attachView(this);
        //视频热门接口：https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=101&token=1
        HashMap<String,String> map = new HashMap<>();
        map.put("appVersion","101");
        map.put("token","1");
        map.put("source", "android");
        userPresenter.getVideos(url,string,map);

    }

    @Override
    public void success(Object o) {
        if (o instanceof List){
            List<VideoBean.DataBean> list= (List<VideoBean.DataBean>) o;
            if (list!=null){
                G_Video_RecuclerView g_video_recuclerView = new G_Video_RecuclerView(getActivity(),list);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,VERTICAL );
                recy.setLayoutManager(staggeredGridLayoutManager);
                recy.setAdapter(g_video_recuclerView);
                //点击事件     调用接口方法
                g_video_recuclerView.setOnRecyclerViewItemClickLintemet(new G_Video_RecuclerView.OnRecyclerViewItemClickLintemet() {
                    @Override
                    public void onItemClick(int position) {

                        Intent intent = new Intent(getActivity(),Details_Video.class);
                        startActivity(intent);
                    }
                });
                g_video_recuclerView.notifyDataSetChanged();


            }
        }
    }

    @Override
    public void Failes(Exception e) {
        Log.i(TAG, "Failes: "+e.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (userPresenter!=null){
            userPresenter.delete();
        }
    }
}