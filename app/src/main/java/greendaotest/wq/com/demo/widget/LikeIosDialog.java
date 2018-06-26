package greendaotest.wq.com.demo.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import greendaotest.wq.com.demo.R;

/**
 * Created by 860617010 on 2018/6/26.
 */

public class LikeIosDialog extends DialogFragment {

    private TextView tvTop, tvBottomLeft, tvBottomRight;
    private String top, bottomLeft, bottomRight;

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.transparent_background));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.like_ios_dialog, container);
        Bundle arguments = getArguments();
        top = arguments.getString("top");
        bottomLeft = arguments.getString("bottomLeft");
        bottomRight = arguments.getString("bottomRight");
        initView(view);
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == keyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;

            }
        });
        return view;
    }

    private void initView(View view) {
        tvTop = (TextView) view.findViewById(R.id.tv_top);
        tvBottomLeft = (TextView) view.findViewById(R.id.tv_bottom_left);
        tvBottomRight = (TextView) view.findViewById(R.id.tv_bottom_right);
        tvTop.setText(top);
        tvBottomLeft.setText(bottomLeft);
        tvBottomRight.setText(bottomRight);
        tvBottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
