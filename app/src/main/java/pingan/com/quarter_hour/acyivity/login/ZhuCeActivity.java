package pingan.com.quarter_hour.acyivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pingan.com.quarter_hour.R;

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.zhcue)
    TextView zhcue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);

        zhcue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhcue:
                Intent intent = new Intent(ZhuCeActivity.this,RegisteredActivity.class);
                startActivity(intent);
                break;
        }
    }
}
