package pingan.com.quarter_hour.acyivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pingan.com.quarter_hour.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.qita)
    TextView qita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        qita.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qita:
                Intent intent = new Intent(LoginActivity.this,ZhuCeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
