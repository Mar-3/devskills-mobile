package org.mar_3.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private String[] categoriesList;
    private ItemList itemList;
    private RecyclerView.RecycledViewPool viewPool
            = new RecyclerView.RecycledViewPool();



    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View categoriesView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_view,
                        parent, false);

        return new ViewHolder(categoriesView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        TextView categoryTextView = holder.categoryNameTextView;
        RecyclerView itemsByCategoryRecyclerView = holder.itemsByCategoryRecyclerView;

        categoryTextView.setText(categoriesList[position]);
        ItemList itemsByCategory = itemList.getItemsByCategory(categoriesList[position]);
        if (itemsByCategory == null) {
            return;
        }


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(
                        itemsByCategoryRecyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false
        );
        layoutManager.setInitialPrefetchItemCount(
                itemList.getSize()
        );
        ItemsAdapter itemsByCategoryAdapter = new ItemsAdapter(itemsByCategory);
        itemsByCategoryRecyclerView.setLayoutManager(layoutManager);
        itemsByCategoryRecyclerView.setAdapter(itemsByCategoryAdapter);
        itemsByCategoryRecyclerView.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return this.categoriesList.length;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryNameTextView;
        public RecyclerView itemsByCategoryRecyclerView;
        public ViewHolder (View itemView) {
            super(itemView);
            categoryNameTextView = (TextView) itemView.findViewById(R.id.categoryNameTextView);
            itemsByCategoryRecyclerView = (RecyclerView) itemView.findViewById(R.id.itemsByCategoryRecyclerView);
        }

    }

    public CategoriesAdapter(ItemList i, String[] c) {
        this.itemList = i;
        this.categoriesList = c;
    }

}
