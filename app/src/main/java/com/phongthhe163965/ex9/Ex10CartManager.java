package com.phongthhe163965.ex9;

import java.util.ArrayList;
import java.util.List;

public class Ex10CartManager {
    private static Ex10CartManager instance;// bien toan cuc = gio hang
    private List<Product> cartItems;// danh sach mat hang o trong gio hang
    Ex10CartManager(){
        cartItems = new ArrayList<>();
    } // khoi tao
    // phuong thuc xu ly bien tinh -> xu ly du lieu khong mat khi di chuyen form
    public static synchronized Ex10CartManager getInstance(){
        if(instance == null){
            instance = new Ex10CartManager();
        }
        return instance;
    }
    // them san vao gio hang
    public void addProductToCart(Product product){
        cartItems.add(product);
    }
    //lay ve 1 item trong gio hang
    public List<Product> getCartItems(){
        return cartItems;
    }
}
