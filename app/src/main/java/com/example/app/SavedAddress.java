package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class SavedAddress extends AppCompatActivity {

    private RecyclerView addressesRecyclerView;
    private static AddressesAdapter addressesAdapter;
    private ImageView back_saved_address;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_address);

        back_saved_address =(ImageView) findViewById(R.id.back_saved_address);
        back_saved_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AddAddress.class);
                startActivity(intent);
                finish();
            }
        });

        addressesRecyclerView = findViewById(R.id.addresses_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        addressesRecyclerView.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Prateek Kumar","aaaaabbb","302024",true));
        addressesModelList.add(new AddressesModel("Prateek Singh","aaaaabbbcccc","302023",false));
        addressesModelList.add(new AddressesModel("Prateek Sharma","aaaaabbbccddd","302025",false));
        addressesModelList.add(new AddressesModel("Prateek Chandra","aaaaabbbcdef","302026",false));
        addressesModelList.add(new AddressesModel("Prateek Khandelwal","aaaaabbbefef","302027",false));

        addressesAdapter = new AddressesAdapter(addressesModelList);
        addressesRecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)addressesRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect, int select){
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);
    }
}
