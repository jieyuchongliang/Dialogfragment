package greendaotest.wq.com.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import greendaotest.wq.com.demo.R;
import greendaotest.wq.com.demo.bean.Animal;

/**
 * Created by 860617010 on 2018/6/22.
 */

public class TwoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Animal> animals;
    private Context mContext;
    private View itemView;

    public TwoListAdapter(List<Animal> animals, Context mContext) {
        this.animals = animals;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_list_outer, parent, false);
            return new OuterViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_list_inner, parent, false);
            return new InnerViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OuterViewHolder) {
            ((OuterViewHolder) holder).textView.setText(animals.get(position).getName());
            this.itemView = ((OuterViewHolder) holder).itemView;
            ((OuterViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String belong = animals.get(position).getName();
                    for (int i = 0; i < animals.size(); i++) {
                        if (belong.equals(animals.get(i).getBelong())){
                            Animal animal = animals.get(i);
                            boolean showOrNot = animal.getShowOrNot();
                            animal.setShowOrNot(!showOrNot);
                        }
                    }
                    notifyDataSetChanged();
                }
            });
        }
        if (holder instanceof InnerViewHolder) {
            ((InnerViewHolder) holder).textView.setText(animals.get(position).getName());
            this.itemView = ((InnerViewHolder) holder).itemView;
            if (animals.get(position).getShowOrNot()){
                setVisibility(true);
            }else {
                setVisibility(false);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return animals.get(position).getType() == 0 ? 0 : 1;
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class OuterViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public OuterViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_outer);
        }
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public InnerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_inner);
        }
    }

    public void setVisibility(boolean isVisible) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        if (isVisible) {
            param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            itemView.setVisibility(View.VISIBLE);
        } else {
            itemView.setVisibility(View.GONE);
            param.height = 0;
            param.width = 0;
        }
        itemView.setLayoutParams(param);
    }
}
