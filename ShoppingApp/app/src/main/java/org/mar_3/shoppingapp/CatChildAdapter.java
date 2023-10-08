package org.mar_3.shoppingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class CatChildAdapter extends RecyclerView.Adapter<CatChildAdapter.ViewHolder> {
    private ItemList items;
    CatChildAdapter(ItemList i) {
        this.items = i;
    }
    @NonNull
    @NotNull
    @Override
    public CatChildAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_category, parent, false);
        return new CatChildAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CatChildAdapter.ViewHolder holder, int position) {
        String catChildName = items.getItems().get(position).getName();
        String catItemAmount = String.valueOf(items.getItems().get(position).getAmount());

        holder.catItemName.setText(catChildName);
        holder.catItemAmount.setText(catItemAmount);

    }

    @Override
    public int getItemCount() {
        return items.getSize();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catItemName;
        public TextView catItemAmount;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.catItemName = itemView.findViewById(R.id.catItemNameTextView);
            this.catItemAmount = itemView.findViewById(R.id.catItemAmountTextView);
        }
    }
}
