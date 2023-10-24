package com.hnq40.myapplication.ViewHolder;

import static com.hnq40.myapplication.R.id.cart_item_count;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.textview.MaterialTextView;
import com.hnq40.myapplication.Interface.ItemClickListener;
import com.hnq40.myapplication.Model.Order;
import com.hnq40.myapplication.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txt_card_name, txt_price;
    public MaterialTextView img_cart_count;

    private ItemClickListener itemClickListener;

    public void setTxt_card_name(TextView txt_card_name) {
        this.txt_card_name = txt_card_name;
    }

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_card_name = itemView.findViewById(R.id.cart_item_name);
        txt_price = itemView.findViewById(R.id.cart_item_price);
        img_cart_count = itemView.findViewById(cart_item_count);

    }

    @Override
    public void onClick(View v) {

    }
}


public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{
    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        int quantity = listData.get(position).getQuantity();
        String priceStr = listData.get(position).getPrice();
        int price = Integer.parseInt(priceStr);
        int totalPrice = price * quantity;

        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String formattedPrice = fmt.format(totalPrice);

        holder.img_cart_count.setText(String.valueOf(quantity));
        holder.txt_price.setText(formattedPrice);
        holder.txt_card_name.setText(listData.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
