package com.phongthhe163965.ex9;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Ex10CartActivity extends AppCompatActivity {
    private ListView listView;
    private Ex10CartAdpter adapter;
    Ex10CartManager cartManager;
    List<Product> cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_cart);
        listView = findViewById(R.id.Ex10_CartActivity_Listview);
        cartManager = Ex10CartManager.getInstance();
        cartItems = cartManager.getCartItems();
        adapter = new Ex10CartAdpter(this, cartItems);
        listView.setAdapter(adapter);
    }
}