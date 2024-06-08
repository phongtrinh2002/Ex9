package com.phongthhe163965.ex9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Ex10CartAdpter extends ArrayAdapter<Product> {
    private Context mContext;

    public Ex10CartAdpter( Context context,  List<Product> products) {
        super(context, 0, products);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.ex10_cart_items, parent, false);
        }
        Product currenProduct = getItem(position);
        TextView productName = listItem.findViewById(R.id.ex10_cartItem_tvProductName);
        productName.setText(currenProduct.getStyleId());
        TextView productQuantity = listItem.findViewById(R.id.ex10_cartItem_tvProductQuantity);
        productQuantity.setText("Quantity: " + 1);
        return listItem;
    }
}
