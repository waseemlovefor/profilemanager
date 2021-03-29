package com.profile.workmanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.Inflater;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> implements Filterable {
    Context context;
    List<SongList> songlist=new ArrayList<>();
    List<SongList> fullsonglist=new ArrayList<>();

    public SongAdapter(Context context, List<SongList> songlist) {
        this.context = context;
        this.songlist = songlist;
        this.fullsonglist=songlist;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewsong,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
      SongList list=songlist.get(position);
      holder.textView.setText(list.getName());
      holder.imageView.setImageResource(list.getId());
    }

    @Override
    public int getItemCount() {
        return songlist.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        // background thread
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SongList> filterlist=new ArrayList<>();
            if (constraint.toString().isEmpty()){
                filterlist.addAll(fullsonglist);
            }else {
             for (SongList waseem:fullsonglist){
                if (waseem.toString().toLowerCase().contains(constraint.toString().toLowerCase())){
                    filterlist.add(waseem);
                }
             }
            }
            FilterResults results=new FilterResults();
            results.values=filterlist;
            return results;
        }
     // run ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
          songlist.clear();
          songlist.addAll((Collection<? extends SongList>) results.values);
          notifyDataSetChanged();
        }
    };

    class SongViewHolder extends RecyclerView.ViewHolder{
 ImageView imageView;
 TextView textView;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            textView=itemView.findViewById(R.id.textview);
        }
    }
}
