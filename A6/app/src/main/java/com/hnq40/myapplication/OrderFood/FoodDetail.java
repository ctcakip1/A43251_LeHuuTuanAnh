package com.hnq40.myapplication.OrderFood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hnq40.myapplication.Database.Database;
import com.hnq40.myapplication.Model.Food;
import com.hnq40.myapplication.Model.Order;
import com.hnq40.myapplication.R;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {
    private TextView valueTextView;
    private int value = 1;
    TextView food_name, food_price, food_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    String foodId = "";
    FirebaseDatabase database;
    DatabaseReference foods;

    Food currentFood;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");
        btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new Database(getBaseContext()).addToCart(new Order(
                            foodId,
                            currentFood.getName(),
                            value,
                            currentFood.getPrice(),
                            currentFood.getDiscount()
                    ));
                    Toast.makeText(FoodDetail.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        food_description = findViewById(R.id.food_description);
        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        food_image = findViewById(R.id.img_food);
        collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        valueTextView = findViewById(R.id.value_textview);
        updateValueTextView();

        if (getIntent() != null)
            foodId = getIntent().getStringExtra("FoodId");
        if (!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }
    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentFood = dataSnapshot.getValue(Food.class);
                if (currentFood != null) {
                    Picasso.get().load(currentFood.getImage()).into(food_image);
                    collapsingToolbarLayout.setTitle(currentFood.getName());
                    food_price.setText(currentFood.getPrice());
                    food_name.setText(currentFood.getName());
                    food_description.setText(currentFood.getDescription());
                }
            }
            
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void decreaseValue(View view) {
        if (value > 1) {
            value--;
            updateValueTextView();
        }
    }
    public void increaseValue(View view) {
        if (value < 20) {
            value++;
            updateValueTextView();
        }
    }

    private void updateValueTextView() {
        valueTextView.setText(String.valueOf(value));
    }

}