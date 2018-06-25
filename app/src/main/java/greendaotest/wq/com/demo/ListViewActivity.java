package greendaotest.wq.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import greendaotest.wq.com.demo.adapter.TwoListAdapter;
import greendaotest.wq.com.demo.bean.Animal;

public class ListViewActivity extends AppCompatActivity {

    private RecyclerView rvTwo;
    private List<Animal> animals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 99; i++) {
            Animal animal = new Animal(0, "20" + i + "年",null,true);
            animals.add(animal);
            int number = 5 + (int) (Math.random() * 10);
            for (int j = 0; j < number; j++) {
                Animal animalIner = new Animal(1, "月龄" + i + j,"20" + i + "年",false);
                animals.add(animalIner);
            }
        }
    }

    private void initView() {
        rvTwo = (RecyclerView) findViewById(R.id.rv_test);
        rvTwo.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTwo.setLayoutManager(manager);
        TwoListAdapter adapter = new TwoListAdapter(animals,this);
        rvTwo.setAdapter(adapter);
    }
}
