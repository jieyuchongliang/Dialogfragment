package greendaotest.wq.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import greendaotest.wq.com.demo.activity.WMActivity;
import greendaotest.wq.com.demo.widget.TestDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_sensor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SensorActivity.class));
            }
        });

        findViewById(R.id.tv_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testList();
            }
        });

        findViewById(R.id.tv_list_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "-------最终输出-------");
                for (String key : yearMonthMap.keySet()) {
                    List<String> list = yearMonthMap.get(key);
                    for (String s : list) {
                        Log.i(TAG, key + s);
                    }
                }
            }
        });
        findViewById(R.id.tv_two_list_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
            }
        });
        findViewById(R.id.tv_window_manager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WMActivity.class));
            }
        });
        findViewById(R.id.tv_test_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDialog dialog = new TestDialog();
                dialog.show(getSupportFragmentManager(),"TestDialog");
            }
        });
    }

    private LinkedHashMap<String, List<String>> yearMonthMap = new LinkedHashMap<>();

    private void testList() {
        String[] strings = new String[]{"201807", "201808", "201809", "201810", "201811", "201812", "201901", "201902", "201903", "201904", "201905", "201906", "201907", "201908", "202209", "202210", "202211", "202212", "202301", "202302", "202303", "202304", "202305", "202306", "202307", "202308"};
        List<String> lists = Arrays.asList(strings);
        for (String s : lists) {
            Log.i(TAG, "testList: " + s);
        }
        List<String> list = new ArrayList<>();
        list.addAll(lists);
        addMapMethod(list);
    }

    private List<String> linshi = new ArrayList<>();
    private void addMapMethod(List<String> list) {
        if (list.size() > 0) {
            String year = list.get(0).substring(0, 4);
            for (int i = 0; i < list.size(); i++) {
                List<String> yearMonth = new ArrayList<>();
                if (list.get(i).contains(year)) {
                    if (list.get(i).substring(4, 6).compareTo("09") < 0) {
                        int intYear = Integer.parseInt(year) - 1;
                        yearMonth.add(list.get(i));
                        if (yearMonthMap.containsKey(intYear + "-" + year)) {
                            List<String> hasList = yearMonthMap.get(intYear + "-" + year);
                            hasList.addAll(yearMonth);
                            yearMonthMap.put(intYear + "-" + year, hasList);
                        } else {
                            yearMonthMap.put(intYear + "-" + year, yearMonth);
                        }
                    } else {
                        int intYear = Integer.parseInt(year) + 1;
                        yearMonth.add(list.get(i));
                        if (yearMonthMap.containsKey(year + "-" + intYear)) {
                            List<String> hasList = yearMonthMap.get(year + "-" + intYear);
                            hasList.addAll(yearMonth);
                            yearMonthMap.put(year + "-" + intYear, hasList);
                        } else {
                            yearMonthMap.put(year + "-" + intYear, yearMonth);
                        }
                    }
                    linshi.add(list.get(i));
                }
            }
            list.removeAll(linshi);
            linshi.clear();
            addMapMethod(list);
        }
    }

    private static final String TAG = "MainActivity";
}
