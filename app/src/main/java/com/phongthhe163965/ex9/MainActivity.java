package com.phongthhe163965.ex9;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Ex9Adapter adapter;
    private List<Product> list;
    Ex10CartManager cartManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ex9Listview);
        cartManager = Ex10CartManager.getInstance();
        list = new ArrayList<>();
        adapter = new Ex9Adapter(this, list);
        listView.setAdapter(adapter);
        new FetchProduct().execute();
    }

    private class FetchProduct extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            try {
                URL url = new URL("https://hungnttg.github.io/shopgiay.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.isEmpty()) {
                try {
                    JSONObject json = new JSONObject(s);
                    JSONArray productArray = json.getJSONArray("products");
                    for (int i = 0; i < productArray.length(); i++) {
                        JSONObject pObject = productArray.getJSONObject(i);
                        String styleId = pObject.getString("styleid");
                        String brand = pObject.getString("brands_filter_facet");
                        String price = pObject.getString("price");
                        String info = pObject.getString("product_additional_info");
                        String searchImage = pObject.getString("search_image");
                        Product product = new Product(styleId, brand, price, info, searchImage);
                        list.add(product);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
