package org.mar_3.shoppingapp;

import android.os.Bundle;
import android.os.Parcelable;
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

public class NewListFragment extends Fragment {
    public NewListFragment() {
        super(R.layout.fragment_new_list);
    }
    public ItemList currentItemList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView currentItemsRecyclerView = (RecyclerView) view.findViewById(R.id.currentItemsRecyclerView);

        currentItemList = new ItemList("");
        currentItemList.addItem(new Item("Apples", 12, "Food"));


        ItemsAdapter adapter = new ItemsAdapter(currentItemList);
        currentItemsRecyclerView.setAdapter(adapter);
        currentItemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set the onclicklistener to remove clicked items from list

        adapter.setOnClickListener(new ItemsAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {

                currentItemList.removeItemByPosition(position);

                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, currentItemList.getSize());


            }
        });

        Button addItemButton = (Button) view.findViewById(R.id.add_item_button);
        Button saveListButton = (Button) view.findViewById(R.id.save_list_button);

        Spinner categoriesSpinner = (Spinner) view.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this.getContext(),
                R.array.categories_array,
                android.R.layout.simple_spinner_item
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriesSpinner.setAdapter(spinnerAdapter);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newItemNameEditText = (EditText) view.findViewById(R.id.newItemNameEditText);
                EditText newItemAmountEditNumber = (EditText) view.findViewById(R.id.newItemAmountEditNumber);

                // Check for empty input
                if (newItemNameEditText.getText().toString().isEmpty() ||
                    newItemAmountEditNumber.getText().toString().isEmpty()) {
                    return;
                }
                String newItemName = newItemNameEditText.getText().toString();
                int newItemAmount = Integer.parseInt(newItemAmountEditNumber.getText().toString());
                Item newItem = new Item(newItemName, newItemAmount, categoriesSpinner.getSelectedItem().toString());
                currentItemList.addItem(newItem);
                adapter.notifyItemInserted(currentItemList.getSize()-1);

                newItemNameEditText.setText("");
                newItemAmountEditNumber.setText("1");
            }
        });

        saveListButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle args = new Bundle();
                args.putSerializable("itemList", currentItemList);
                ShoppingListFragment nextFragment = new ShoppingListFragment();
                nextFragment.setArguments(args);

                getParentFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView, nextFragment, "")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}