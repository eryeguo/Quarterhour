package pingan.com.quarter_hour.acyivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pingan.com.quarter_hour.R;
import pingan.com.quarter_hour.acyivity.login.LoginActivity;

/**
 * Created by mxn on 2016/12/13.
 * MenuListFragment
 */

public class MenuListFragment extends Fragment {


    @BindView(R.id.c_name)
    TextView cName;
    @BindView(R.id.c_sex)
    TextView cSex;
    Unbinder unbinder;
    private SimpleDraweeView img;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        img = (SimpleDraweeView) view.findViewById(R.id.ivMenuUserProfilePhoto);
        //设置图片
        init();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void init() {
        Uri uri = Uri.parse("http://a0.att.hudong.com/40/19/01300000870086129301191690908.jpg");
        img.setImageURI(uri);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ivMenuUserProfilePhoto, R.id.item_one, R.id.item_tow, R.id.item_three, R.id.item_four, R.id.item_moshi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivMenuUserProfilePhoto:
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);

                break;
            case R.id.item_one:
                break;
            case R.id.item_tow:
                break;
            case R.id.item_three:
                break;
            case R.id.item_four:
                break;
            case R.id.item_moshi:
                break;
        }
    }
}
