package org.mar_3.shoppingapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShoppingListFragment extends Fragment {
    private ItemList shoppingItemList;
    public ShoppingListFragment() {
        super(R.layout.fragment_shopping_list);



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            this.shoppingItemList = args.getSerializable("itemList", ItemList.class);
        }

        RecyclerView categoriesRecyclerView = (RecyclerView) view.findViewById(R.id.categoriesRecyclerView);
        if (this.shoppingItemList == null) {
            return;
        }

        CatParentAdapter adapter = new CatParentAdapter(shoppingItemList);
        categoriesRecyclerView.setAdapter(adapter);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }
}
