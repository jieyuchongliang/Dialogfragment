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

public class TestDialogFragment extends DialogFragment {

    private Dialog dialog;

    @Override
    public void onStart() {
        super.onStart();
        dialog = getDialog();
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.test_dialog_backgroun));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        int screenWidthDp = getResources().getConfiguration().screenWidthDp;
        int screenHeightDp = getResources().getConfiguration().screenHeightDp;
        attributes.width = dip2px((float) (screenWidthDp * 0.6));
        attributes.height = dip2px((float) (screenHeightDp * 0.6));
        window.setAttributes(attributes);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_dialog_fragment,container);
        return view;
    }

    public int dip2px(float dpValue) {
        float scale = dialog.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
