package app.portfolio.ordering.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.portfolio.ordering.Adapter.BaseDrawerAdapter;
import app.portfolio.ordering.Adapter.ShoppingCartAdapter;
import app.portfolio.ordering.R;

/**
 * Created by dondi on 4/3/2016.
 */
public class ShoppingCart extends Fragment {
    ArrayList<app.portfolio.ordering.Model.ShoppingCart> shoppingCartArrayList;
    private RecyclerView recyclerViewShoppingCartItems;
    private ShoppingCartAdapter shoppingCartAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private View view;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        context = getActivity().getApplicationContext();
        recyclerViewShoppingCartItems = (RecyclerView) view.findViewById(R.id.recyclerViewShoppingCartItems);
        shoppingCartArrayList = new ArrayList<>();
        shoppingCartArrayList.add(new app.portfolio.ordering.Model.ShoppingCart("Computer", 5));
        shoppingCartArrayList.add(new app.portfolio.ordering.Model.ShoppingCart("Mouse", 4));
        shoppingCartArrayList.add(new app.portfolio.ordering.Model.ShoppingCart("Keyboard", 3));
        shoppingCartArrayList.add(new app.portfolio.ordering.Model.ShoppingCart("Monitor", 2));
        shoppingCartAdapter = new ShoppingCartAdapter(context, shoppingCartArrayList);
        recyclerViewShoppingCartItems.setAdapter(shoppingCartAdapter);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerViewShoppingCartItems.setLayoutManager(mLayoutManager);
        return view;
    }
}
