package org.mar_3.shoppingapp;

import android.content.Context;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ItemList itemList;

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ArrayList<Item> items = itemList.getItems();
        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(items.get(position).getName());

        TextView amountTextView = holder.amountTextView;
        amountTextView.setText(String.valueOf(items.get(position).getAmount()));
        System.out.println(items.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return this.itemList.getSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView amountTextView;
        public ViewHolder (View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.itemNameTextView);
            amountTextView = (TextView) itemView.findViewById(R.id.itemAmountTextView);
        }

    }
    public ItemsAdapter(ItemList i) {
        this.itemList = i;
    }
    public int getCount() {
        return this.itemList.getSize();
    }

    public Item getItem(int position) {
        return this.itemList.getItems().get(position);
    }


}
