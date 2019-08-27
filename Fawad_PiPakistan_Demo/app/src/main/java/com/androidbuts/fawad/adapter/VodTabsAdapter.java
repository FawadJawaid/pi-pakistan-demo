package com.androidbuts.fawad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidbuts.fawad.R;
import com.androidbuts.fawad.model.VodTab;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by fawadjawaidmalik on 13/10/2016.
 */
public class VodTabsAdapter extends ArrayAdapter<VodTab> {

    List<VodTab> vodTabList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public VodTabsAdapter(Context context, List<VodTab> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        vodTabList = objects;
    }

    @Override
    public VodTab getItem(int position) {
        return vodTabList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final VodTabsAdapter.ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = VodTabsAdapter.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (VodTabsAdapter.ViewHolder) convertView.getTag();
        }

        VodTab item = getItem(position);

        vh.textViewName.setText(item.getVODTabId()+"");
        vh.textViewEmail.setText(item.getVODTabName());
        Picasso.with(context).load(item.getVODTabThumbnailPath()).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewEmail;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static VodTabsAdapter.ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
            return new VodTabsAdapter.ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}

