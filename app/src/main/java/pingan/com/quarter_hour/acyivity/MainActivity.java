package pingan.com.quarter_hour.acyivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.fragment.EpisodeFragment;
import pingan.com.quarter_hour.fragment.RecommendFragment;
import pingan.com.quarter_hour.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mb;
    private Custom ade;
    private SimpleDraweeView add;
    private FlowingDrawer mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        //侧拉
        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);

        setupMenu();


        SimpleDraweeView add= (SimpleDraweeView)findViewById(R.id.add);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }


        //自定义的布局控件
        ade = (Custom)findViewById(R.id.ade);

        //自定义控件的加减以及EditText 。这三个的回调接口
        ade.setOnAddDelClickLinstener(new Custom.OnAddDelClickLinstener() {
            @Override
            public void onAddClick(View v) {
                mDrawer.toggleMenu();
                Toast.makeText(MainActivity.this,"点击一",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDelClick(View v) {
                Toast.makeText(MainActivity.this,"点击二",Toast.LENGTH_SHORT).show();
            }
        });
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("推荐",R.drawable.recommend_selected,R.drawable.recommend_unselected, RecommendFragment.class)
                .addTabItem("段子",R.drawable.smile_selected,R.drawable.smile_unselected, EpisodeFragment.class)
                .addTabItem("视频",R.drawable.video_selected,R.drawable.video_unselected, VideoFragment.class)

                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment mMenuFragment = (MenuListFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }


    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isMenuVisible()) {
            mDrawer.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

}
