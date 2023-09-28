package org.mar_3.shoppingapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import org.jetbrains.annotations.NotNull;

public class StartFragment extends Fragment {

    public StartFragment() {
        super(R.layout.fragment_start);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button newListButton = view.findViewById(R.id.new_list_button);

        newListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getParentFragmentManager()
                       .beginTransaction()
                       .setReorderingAllowed(true)
                       .replace(R.id.fragmentContainerView, NewListFragment.class, null)
                       .addToBackStack(null)
                       .commit();
            }
        });
    }
}