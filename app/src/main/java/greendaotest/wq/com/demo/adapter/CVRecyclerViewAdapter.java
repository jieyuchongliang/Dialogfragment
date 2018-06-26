package greendaotest.wq.com.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import greendaotest.wq.com.demo.R;

/**
 * Created by 860617010 on 2018/6/26.
 */

public class CVRecyclerViewAdapter extends RecyclerView.Adapter<CVRecyclerViewAdapter.MyViewHolder> {

    private Context mContent;
    private MyViewHolder holder;

    public CVRecyclerViewAdapter(Context mContent) {
        this.mContent = mContent;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.cv_recyclerview, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 200;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_content);
            int screenWidthDp = mContent.getResources().getConfiguration().screenWidthDp;
            float imageRealWidthDp = (screenWidthDp - 52) / 3;
            ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
            layoutParams.height = dip2px(imageRealWidthDp);
            iv.setLayoutParams(layoutParams);

        }
    }

    public int dip2px(float dpValue) {
        float scale = mContent.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
