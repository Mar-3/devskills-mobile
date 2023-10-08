package org.mar_3.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ItemList itemList;
    private OnClickListener onClickListener;

    public ItemsAdapter(ItemList i) {
        this.itemList = i;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_row, parent, false);

        ViewHolder viewHolder = new ItemsAdapter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ArrayList<Item> items = itemList.getItems();
        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(items.get(position).getName());

        TextView amountTextView = holder.amountTextView;
        amountTextView.setText(String.valueOf(items.get(position).getAmount()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.getItems().size();
    }

    public void setOnClickListener(ItemsAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView amountTextView;
        public ViewHolder (View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.catItemNameTextView);
            amountTextView = (TextView) itemView.findViewById(R.id.catItemAmountTextView);
        }

    }

    public interface OnClickListener {
        void onClick(int position);
    }

    public Item getItem(int position) {
        return this.itemList.getItems().get(position);
    }


}
