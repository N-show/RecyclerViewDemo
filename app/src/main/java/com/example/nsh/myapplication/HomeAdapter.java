package com.example.nsh.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by NSH on 2016/3/22 21:41.
 */
public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final ArrayList<Integer> mHeights;
    private Context mContext;
    private List<SampleModel> sampleData;
    private LayoutInflater mInflater;

    public HomeAdapter(Context context, List<SampleModel> datas) {
        this.mContext = context;
        this.sampleData = datas;
        this.mInflater = LayoutInflater.from(context);

        mHeights = new ArrayList<>();
        for (int i = 0; i < sampleData.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置瀑布流不同高度
//        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//        params.height = mHeights.get(position);
//        holder.itemView.setLayoutParams(params);
        holder.tv.setText(sampleData.get(position).getSampleText());
//        holder.num.setText((int) Math.random());
    }

    @Override
    public int getItemCount() {
        return sampleData.size();
    }

    public void removeData(int postion) {
        sampleData.remove(postion);
        notifyItemRemoved(postion);
    }

    public void addData(int postionAdd) {
        Random random = new Random();
        int i = random.nextInt(100) + 100;
        sampleData.add(postionAdd, new SampleModel("新的数据<" + i + ">"));
        notifyItemInserted(postionAdd);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView num;
    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv_item);
//        num = (TextView) itemView.findViewById(R.id.tv_item);
    }
}
