package org.mar_3.shoppingapp;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

public class CatParentAdapter extends RecyclerView.Adapter<CatParentAdapter.ViewHolder> {
    private ArrayList<String> categories;
    private ItemList itemList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public CatParentAdapter(ItemList i) {
        this.categories = i.getCategories();
        this.itemList = i;
    }
    @NonNull
    @NotNull
    @Override
    public CatParentAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view, parent, false);
        return new CatParentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CatParentAdapter.ViewHolder holder, int position) {

        String categoryName = categories.get(position);
        ItemList itemsByCategory = itemList.getItemsByCategory(categoryName);
        if (itemsByCategory == null) {
            return;
        }

        holder.catName.setText(categoryName);

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.catItemsRV.getContext(),
                LinearLayoutManager.VERTICAL, false);


        layoutManager.setInitialPrefetchItemCount(itemsByCategory.getSize());

        CatChildAdapter catChildAdapter = new CatChildAdapter(itemsByCategory);
        holder.catItemsRV.setLayoutManager(layoutManager);
        holder.catItemsRV.setAdapter(catChildAdapter);
        holder.catItemsRV.setRecycledViewPool(viewPool);


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView catName;
        RecyclerView catItemsRV;

        public ViewHolder(View itemView) {
            super(itemView);
            this.catName = itemView.findViewById(R.id.categoryNameTextView);
            this.catItemsRV = itemView.findViewById(R.id.itemsByCategoryRecyclerView);

        }
    }
}
