package greendaotest.wq.com.demo.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import greendaotest.wq.com.demo.R;

/**
 * Created by 860617010 on 2018/6/25.
 */

public class TestDialog extends DialogFragment {

    private Dialog dialog;

    @Override
    public void onStart() {
        super.onStart();
        dialog = getDialog();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.test_dialog_backgroun));
        WindowManager.LayoutParams params = window.getAttributes();
        params.dimAmount = 0.6f;
        int screenWidthDp = getResources().getConfiguration().screenWidthDp;
        int screenHightDp = getResources().getConfiguration().screenHeightDp;
        params.width = dip2px((float) (screenWidthDp * 0.7));
        params.height = dip2px((float) (screenHightDp * 0.7));
        window.setAttributes(params);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
//        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
//                if (i == keyEvent.KEYCODE_BACK){
//                    return true;
//                }
//                return false;
//            }
//        });
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.tv_test_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDialogFragment dialog = new TestDialogFragment();
                dialog.show(getChildFragmentManager(),"TestDialogFragment");
            }
        });
    }

    public int dip2px(float dpValue) {
        float scale = dialog.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
