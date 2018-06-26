package greendaotest.wq.com.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import greendaotest.wq.com.demo.R;
import greendaotest.wq.com.demo.adapter.CVRecyclerViewAdapter;

public class RVCVActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvcv);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        CVRecyclerViewAdapter adapter = new CVRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
