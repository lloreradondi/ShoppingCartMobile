package app.portfolio.ordering.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import app.portfolio.ordering.Model.ShoppingCart;
import app.portfolio.ordering.R;

/**
 * Created by dondi on 4/3/2016.
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ShoppingCart> shoppingCartArrayList;
    public ShoppingCartAdapter(Context context, ArrayList<ShoppingCart> shoppingCartArrayList){
        this.context = context;
        this.shoppingCartArrayList = shoppingCartArrayList;
    }
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_shopping_cart_item_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingCartAdapter.ViewHolder holder, int position) {
        holder.itemName.setText(shoppingCartArrayList.get(position).getItemName());
        holder.itemQuantity.setText(String.valueOf(shoppingCartArrayList.get(position).getItemQuantity()));
    }

    @Override
    public int getItemCount() {
        return shoppingCartArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.tvShoppingCartItemName);
            itemQuantity = (TextView) itemView.findViewById(R.id.tvShoppingCartItemQuantity);
        }
    }
}
