package pingan.com.quarter_hour.fragment.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.swipbackhelper.SwipeBackHelper;

import pingan.com.quarter_hour.R;

public class Details_Video extends AppCompatActivity {

    private SimpleDraweeView img;
    private ImageView img1;
    private TextView fin;

    private static final String TAG = "Details_Video";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__video);
        //销毁当前页面
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeRelateOffset(300);
        fin = (TextView) findViewById(R.id.fin);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });


        //创建SimpleDraweeView对象
        img = (SimpleDraweeView) findViewById(R.id.main_adv);
        //创建将要下载的图片的URI


        Uri imageUri = Uri.parse("http://cdn.duitang.com/uploads/item/201204/09/20120409153606_xrJEc.jpeg");
        //开始下载
        img.setImageURI(imageUri);


        // 图片链接
        String imgUrl = "http://p1.so.qhimgs1.com/bdr/200_200_/t01f5fe5c9996f7ffa1.gif";
        // 图片控件
        img1 = (ImageView) findViewById(R.id.gif);

        // 加载图片
        Glide.with(this).load(imgUrl).centerCrop().placeholder(R.drawable.jizai).crossFade().into(img1);

    }


    @Override
    protected void onDestroy() {
        SwipeBackHelper.onDestroy(this);
        super.onDestroy();
        Log.i(TAG, "销毁没");

    }
}
