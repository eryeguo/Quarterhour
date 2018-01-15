package pingan.com.quarter_hour.acyivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import pingan.com.quarter_hour.R;

/**
 * Created by 迷人的脚毛！！ on 2018/1/9.
 */

public class Custom extends LinearLayout {

    private TextView et;

    //定义接口
    interface OnAddDelClickLinstener{
        void onAddClick(View v);
        void onDelClick(View v);

    }
    //定义接口方法
    private OnAddDelClickLinstener linsanter;
    //定义接口方法
    public void setOnAddDelClickLinstener(OnAddDelClickLinstener linsanter){
        this.linsanter=linsanter;
    }

    public Custom(Context context) {
        this(context,null);
    }

    public Custom(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Custom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {

        View view = View.inflate(context, R.layout.layout_del_add, this);

        SimpleDraweeView add=(SimpleDraweeView) findViewById(R.id.add);
        TextView del=(TextView) findViewById(R.id.del);
        et = (TextView)findViewById(R.id.et);
        //自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddDelViewStyle);
        String leftText = typedArray.getString(R.styleable.AddDelViewStyle_left_text);
        String rightText = typedArray.getString(R.styleable.AddDelViewStyle_right_text);
        String middleText = typedArray.getString(R.styleable.AddDelViewStyle_middle_text);
        int color = typedArray.getColor(R.styleable.AddDelViewStyle_left_text_color, Color.RED);

        //自定义属性设置
//        add.setText(leftText);
//        add.setTextColor(color);
        del.setText(rightText);
        et.setText(middleText);
        //因为是数组，所以需要回收
        typedArray.recycle();


        Uri uri = Uri.parse("http://a0.att.hudong.com/40/19/01300000870086129301191690908.jpg");
        add.setImageURI(uri);
        //设置接口点击事件
        //加
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                linsanter.onAddClick(view);
            }
        });
        //减
        del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                linsanter.onDelClick(view);
            }
        });
    }



}
