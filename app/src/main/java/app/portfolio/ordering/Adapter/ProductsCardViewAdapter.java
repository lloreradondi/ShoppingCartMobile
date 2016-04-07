package app.portfolio.ordering.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.portfolio.ordering.Model.Products;
import app.portfolio.ordering.R;

/**
 * Created by dione on 04/04/2016.
 */
public class ProductsCardViewAdapter extends  RecyclerView.Adapter<ProductsCardViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Products> productsArrayList;
    public ProductsCardViewAdapter(Context context, ArrayList<Products> productsArrayList){
        this.context = context;
        this.productsArrayList = productsArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view_item_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.productImage.setImageResource(productsArrayList.get(position).getProductImage());
        holder.productName.setText(productsArrayList.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.imageViewProductImage);
            productName = (TextView) itemView.findViewById(R.id.textViewProductName);
        }
    }

}
