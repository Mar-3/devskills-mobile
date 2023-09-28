package org.mar_3.shoppingapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

public class NewListFragment extends Fragment {

    public NewListFragment() {
        super(R.layout.fragment_new_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView currentItemsRecyclerView = (RecyclerView) view.findViewById(R.id.currentItemsRecyclerView);

        ItemList currentItemList = new ItemList("");
        currentItemList.addItem(new Item("ASDf", 12, "Tech"));
        ItemsAdapter adapter = new ItemsAdapter(currentItemList);
        currentItemsRecyclerView.setAdapter(adapter);
        currentItemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button addItemButton = (Button) view.findViewById(R.id.add_item_button);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newItemNameEditText = (EditText) view.findViewById(R.id.newItemNameEditText);
                EditText newItemAmountEditNumber = (EditText) view.findViewById(R.id.newItemAmountEditNumber);

                String newItemName = newItemNameEditText.getText().toString();
                int newItemAmount = Integer.parseInt(newItemAmountEditNumber.getText().toString());
                Item newItem = new Item(newItemName, newItemAmount, "Tech");
                currentItemList.addItem(newItem);
                adapter.notifyItemChanged(currentItemList.getSize());

                newItemNameEditText.setText("");
                newItemAmountEditNumber.setText("");
            }
        });
    }

}