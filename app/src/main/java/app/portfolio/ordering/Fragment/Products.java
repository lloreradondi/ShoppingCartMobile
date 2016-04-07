package app.portfolio.ordering.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.portfolio.ordering.Adapter.ProductsCardViewAdapter;
import app.portfolio.ordering.R;

/**
 * Created by dione on 04/04/2016.
 */
public class Products extends Fragment {
    private RecyclerView recyclerViewProducts;
    RecyclerView.LayoutManager mLayoutManager;
    ProductsCardViewAdapter productsCardViewAdapter;
    ArrayList<app.portfolio.ordering.Model.Products> productsArrayList;
    View view;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products, container, false);
        context = getActivity().getApplicationContext();
        recyclerViewProducts = (RecyclerView) view.findViewById(R.id.recyclerViewProducts);
        productsArrayList = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(context);
        productsArrayList.add(new app.portfolio.ordering.Model.Products("Jelly Ace", R.mipmap.ic_cart));
        productsArrayList.add(new app.portfolio.ordering.Model.Products("Lollipop", R.mipmap.ic_cart));
        productsArrayList.add(new app.portfolio.ordering.Model.Products("Laptop", R.mipmap.ic_cart));
        productsArrayList.add(new app.portfolio.ordering.Model.Products("Monitor", R.mipmap.ic_cart));
        productsArrayList.add(new app.portfolio.ordering.Model.Products("Mouse", R.mipmap.ic_cart));
        productsCardViewAdapter = new ProductsCardViewAdapter(context, productsArrayList);
        recyclerViewProducts.setAdapter(productsCardViewAdapter);
        recyclerViewProducts.setLayoutManager(mLayoutManager);
        return view;
    }
}
