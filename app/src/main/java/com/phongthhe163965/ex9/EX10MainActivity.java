package com.phongthhe163965.ex9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class EX10MainActivity extends AppCompatActivity {
    private TextView tvStyleID, tvBrand, tvPrice, tvAddInfo;
    private ImageView img;
    Intent intent;
    Product product;
    Ex10CartManager cartManager;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_main);
        img = findViewById(R.id.Ex10ImageView1);
        tvStyleID = findViewById(R.id.Ex10TvStyleID);
        tvBrand = findViewById(R.id.Ex10TvBrand);
        tvPrice = findViewById(R.id.Ex10TvPrice);
        tvAddInfo = findViewById(R.id.Ex10TvAddInfo);
        btn = findViewById(R.id.Ex10BtnAddToCart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCartClicked();
            }
        });
        //
        cartManager = Ex10CartManager.getInstance();
        //
        intent = getIntent();
        product = intent.getParcelableExtra("PRODUCT");
        if(product != null){
            Picasso.get().load(product.getSearchImage()).into(img);
            tvStyleID.setText(product.getStyleId());
            tvBrand.setText(product.getBrand());
            tvPrice.setText(product.getPrice());
            tvAddInfo.setText(product.getInfo());
        }
    }
    private void addToCartClicked(){
        Intent intent1 = getIntent();
        Product product1 = intent1.getParcelableExtra("PRODUCT");
        if(product1 != null){
            cartManager.addProductToCart(product1);// them sp vao gio hang
            //mo cart activity
            Intent intent2 = new Intent(this, Ex10CartActivity.class);
            startActivity(intent2);
        }
    }
}