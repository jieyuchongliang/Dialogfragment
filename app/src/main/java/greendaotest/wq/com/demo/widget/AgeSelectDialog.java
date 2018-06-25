package greendaotest.wq.com.demo.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import greendaotest.wq.com.demo.R;


/**
 * Created by 860617010 on 2018/6/22.
 */

public class AgeSelectDialog extends DialogFragment implements View.OnClickListener {

    private LinearLayout one, two, three, four, five, six, seven, eight, nine;
    private ImageView ivOne,ivTwo,ivThree,ivFour,ivFive,ivSix,ivSeven,ivEight,ivNine;
    private String selectType = "";
    private TextView tvOk;
    private Dialog dialog;

    @Override
    public void onStart() {
        super.onStart();
        dialog = getDialog();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent_background));
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.6f;
        int height = getResources().getConfiguration().screenHeightDp;
        int width = getResources().getConfiguration().screenWidthDp;
        int layoutWidth = dip2px((int) (width * 0.8));
        int layoutHeight = dip2px((int) (height * 0.6));
        windowParams.width = layoutWidth;
        windowParams.height = layoutHeight;
        window.setAttributes(windowParams);
    }

    public int dip2px(float dpValue) {
        float scale = dialog.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.age_selector, container);
        initView(view);
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK){
                    return true;
                }
                return false;
            }
        });
        return view;
    }

    private void initView(View view) {
        one = (LinearLayout) view.findViewById(R.id.ll_one);
        two = (LinearLayout) view.findViewById(R.id.ll_two);
        three = (LinearLayout) view.findViewById(R.id.ll_three);
        four = (LinearLayout) view.findViewById(R.id.ll_four);
        five = (LinearLayout) view.findViewById(R.id.ll_five);
        six = (LinearLayout) view.findViewById(R.id.ll_six);
        seven = (LinearLayout) view.findViewById(R.id.ll_seven);
        eight = (LinearLayout) view.findViewById(R.id.ll_eight);
        nine = (LinearLayout) view.findViewById(R.id.ll_nine);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ivOne = (ImageView)view.findViewById(R.id.iv_one);
        ivTwo = (ImageView)view.findViewById(R.id.iv_two);
        ivThree = (ImageView)view.findViewById(R.id.iv_three);
        ivFour = (ImageView)view.findViewById(R.id.iv_four);
        ivFive = (ImageView)view.findViewById(R.id.iv_five);
        ivSix = (ImageView)view.findViewById(R.id.iv_six);
        ivSeven = (ImageView)view.findViewById(R.id.iv_seven);
        ivEight = (ImageView)view.findViewById(R.id.iv_eight);
        ivNine = (ImageView)view.findViewById(R.id.iv_nine);
        tvOk = (TextView)view.findViewById(R.id.tv_ok);
        tvOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                submit();
                break;
            case R.id.ll_one:
                selectType = "7-12";
                setImageBackground(1);
                break;
            case R.id.ll_two:
                selectType = "13-24";
                setImageBackground(2);
                break;
            case R.id.ll_three:
                selectType = "25-34";
                setImageBackground(3);
                break;
            case R.id.ll_four:
                selectType = "2-3";
                setImageBackground(4);
                break;
            case R.id.ll_five:
                selectType =  "3-4";
                setImageBackground(5);
                break;
            case R.id.ll_six:
                selectType = "4-5";
                setImageBackground(6);
                break;
            case R.id.ll_seven:
                selectType = "5-6";
                setImageBackground(7);
                break;
            case R.id.ll_eight:
                selectType = "6-7";
                setImageBackground(8);
                break;
            case R.id.ll_nine:
                selectType = "7-8";
                setImageBackground(9);
                break;
        }
    }

    private void submit() {
        if (selectType.equals("")){
            Toast.makeText(getContext(),"请选择宝宝的年龄", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getContext(),"提交年龄", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    private void setImageBackground(int position) {
        if (position == 1){
            ivOne.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivOne.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 2){
            ivTwo.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivTwo.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 3){
            ivThree.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivThree.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 4){
            ivFour.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivFour.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 5){
            ivFive.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivFive.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 6){
            ivSix.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivSix.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 7){
            ivSeven.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivSeven.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 8){
            ivEight.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivEight.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
        if (position == 9){
            ivNine.setImageDrawable(getResources().getDrawable(R.drawable.age_select));
        }else {
            ivNine.setImageDrawable(getResources().getDrawable(R.drawable.age_nomal));
        }
    }
}
