package greendaotest.wq.com.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import greendaotest.wq.com.demo.R;
import greendaotest.wq.com.demo.widget.AgeSelectDialog;

public class WMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wm);
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgeSelectDialog dialog = new AgeSelectDialog();
                dialog.show(getSupportFragmentManager(),"AgeSelectDialog");
            }
        });
    }
}
