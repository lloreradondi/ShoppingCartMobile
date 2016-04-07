package app.portfolio.ordering.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.portfolio.ordering.Interface.DrawerCallBack;
import app.portfolio.ordering.R;

/**
 * Created by dondi on 4/3/2016.
 */
public class BaseDrawerAdapter extends RecyclerView.Adapter<BaseDrawerAdapter.ViewHolder> {
    private DrawerCallBack drawerCallBack;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];

    private String name;
    private int profile;
    private String email;
    private LinearLayout drawerContent;
    Context context;

    public BaseDrawerAdapter(Context context, String Titles[], int Icons[], String Name, String Email, int Profile, DrawerCallBack drawerCallBack){
        this.mNavTitles = Titles;
        mIcons = Icons;
        this.name = Name;
        this.email = Email;
        this.profile = Profile;
        this.context = context;
        this.drawerCallBack = drawerCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item_row,parent,false);
            ViewHolder vhItem = new ViewHolder(v,viewType);
            return vhItem;
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header,parent,false);
            ViewHolder vhHeader = new ViewHolder(v,viewType);
            return vhHeader;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(holder.Holderid ==1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
            holder.drawerContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerCallBack.onDrawerItemClicked(position);
                }
            });
        }
        else{
            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;
        LinearLayout drawerContent;

        public ViewHolder(View itemView, int ViewType) {
            super(itemView);
            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                drawerContent = (LinearLayout) itemView.findViewById(R.id.drawerContent);
                Holderid = 1;
            }
            else{
                Name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                Holderid = 0;
            }
        }
    }

}
