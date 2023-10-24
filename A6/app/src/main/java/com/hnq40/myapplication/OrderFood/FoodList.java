package com.hnq40.myapplication.OrderFood;

import static com.hnq40.myapplication.R.layout.food_item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hnq40.myapplication.Interface.ItemClickListener;
import com.hnq40.myapplication.Model.Category;
import com.hnq40.myapplication.Model.Food;
import com.hnq40.myapplication.R;
import com.hnq40.myapplication.ViewHolder.FoodViewHolder;
import com.hnq40.myapplication.ViewHolder.MenuViewHolder;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference foodList;

    String categoryId ="";
    FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Foods");
        recyclerView = findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty() && categoryId != null) {
            loadListFood(categoryId);
        }
    }

    private void loadListFood(String categoryId) {
        FirebaseRecyclerOptions<Food> options =
                new FirebaseRecyclerOptions.Builder<Food>()
                        .setQuery(foodList.orderByChild("MenuId").equalTo(categoryId), Food.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(options) {
                    @Override
                    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(food_item, parent, false);
                        return new FoodViewHolder(view);
                    }

                    @Override
                    protected void onBindViewHolder(FoodViewHolder viewHolder, int position, Food model) {
                        viewHolder.food_name.setText(model.getName());
                        Picasso.get().load(model.getImage()).into(viewHolder.food_image);

                        final Food local = model;
                        viewHolder.setItemClickListener(new ItemClickListener() {
                            @Override
                            public void onClick(View view, int position, boolean isLongClick) {
                                Intent foodDetail = new Intent(FoodList.this, FoodDetail.class);
                                foodDetail.putExtra("FoodId", adapter.getRef(position).getKey());
                                startActivity(foodDetail);
                            }
                        });
                    }
                };
        Log.d("TAG", ""+adapter.getItemCount());
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}
