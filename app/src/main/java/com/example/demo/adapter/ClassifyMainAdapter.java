package com.example.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.R;

import java.util.List;
import java.util.Map;

public class ClassifyMainAdapter extends Adapter<ClassifyMainAdapter.ClassifyMainAdapterViewHolder> {

  private Context context;
  private List<Map<String, Object>> list;
  private int position = 0;
  private boolean islodingimg = true;

  public ClassifyMainAdapter(Context context, List<Map<String, Object>> list) {
    this.context = context;
    this.list = list;
  }

  public ClassifyMainAdapter(Context context, List<Map<String, Object>> list, boolean islodingimg) {
    this.context = context;
    this.list = list;
    this.islodingimg = islodingimg;
  }


  @NonNull
  @Override
  public ClassifyMainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_classify_mainlist, viewGroup, false);
    ClassifyMainAdapterViewHolder classifyMainAdapterViewHolder = new ClassifyMainAdapterViewHolder(view);
    return classifyMainAdapterViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ClassifyMainAdapterViewHolder holder, int position) {
    holder.txt.setText(list.get(position).get("txt").toString());
    holder.layout.setBackgroundColor(0xFFEBEBEB);
  }

  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public void setSelectItem(int position) {
    this.position = position;
    notifyDataSetChanged();
  }

  public int getSelectItem() {
    return position;
  }

  public class ClassifyMainAdapterViewHolder extends RecyclerView.ViewHolder {

    LinearLayout layout;
    ImageView img;
    TextView txt;

    public ClassifyMainAdapterViewHolder(@NonNull View view) {
      super(view);
      txt = (TextView) view.findViewById(R.id.mainitem_txt);
      img = (ImageView) view.findViewById(R.id.mainitem_img);
      layout = (LinearLayout) view.findViewById(R.id.mainitem_layout);
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
          }
        }
      });

    }
  }


  private OnItemClickListener onItemClickListener;

  public interface OnItemClickListener {
    /**
     * Called when a view has been clicked.
     *
     * @param v               The view that was clicked.
     * @param adapterPosition
     */
    void onItemClick(View v, int adapterPosition);
  }

  public void setOnItemClickListener(@Nullable OnItemClickListener l) {
    this.onItemClickListener = l;
  }

}
