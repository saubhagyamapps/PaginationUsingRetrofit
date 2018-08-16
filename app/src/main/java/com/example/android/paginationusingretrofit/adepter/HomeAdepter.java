package com.example.android.paginationusingretrofit.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.paginationusingretrofit.R;
import com.example.android.paginationusingretrofit.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdepter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private List<HomeModel.DataBean> dataBean;
    private Context context;

    private boolean isLoadingAdded = false;

    public HomeAdepter(Context context) {
        this.context = context;
        dataBean = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.list, parent, false);
        viewHolder = new MovieVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final HomeModel.DataBean result = dataBean.get(position);

        switch (getItemViewType(position)) {
            case ITEM:
                final MovieVH movieVH = (MovieVH) holder;

                movieVH.txtQoutes.setText(result.getQuotes());

                Glide.with(context).load("http://rajviinfotech.in/quotes/public/uploads/" + result.getQuotes_image())
                        .thumbnail(0.5f)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(movieVH.imgQuotes);

                break;

            case LOADING:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataBean == null ? 0 : dataBean.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == dataBean.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    public void add(HomeModel.DataBean r) {
        dataBean.add(r);
        notifyItemInserted(dataBean.size() - 1);
    }

    public void addAll(List<HomeModel.DataBean> Results) {
        for (HomeModel.DataBean result : Results) {
            add(result);
        }
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new HomeModel.DataBean());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = dataBean.size() - 1;
        HomeModel.DataBean result = getItem(position);

        if (result != null) {
            dataBean.remove(position);
            notifyItemRemoved(position);
        }
    }

    public HomeModel.DataBean getItem(int position) {
        return dataBean.get(position);
    }


    protected class MovieVH extends RecyclerView.ViewHolder {
        ImageView imgQuotes;
        private TextView txtQoutes;

        public MovieVH(View itemView) {
            super(itemView);

            txtQoutes = (TextView) itemView.findViewById(R.id.text);
            imgQuotes = (ImageView) itemView.findViewById(R.id.bcgrnd_img);

        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


}
