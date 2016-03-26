package com.example.nsh.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by NSH on 2016/3/22 21:41.
 */
public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<SampleModel> sampleData;
    private LayoutInflater mInflater;

    public HomeAdapter(Context context, List<SampleModel> datas) {
        this.mContext = context;
        this.sampleData = datas;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(sampleData.get(position).getSampleText());
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
        sampleData.add(postionAdd, new SampleModel("新的数据<"+ 1 +">"));
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv_item);
    }
}
