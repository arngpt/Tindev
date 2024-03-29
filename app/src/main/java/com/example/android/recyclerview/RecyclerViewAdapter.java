package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private RecycleViewclickListener recycleViewclickListener;
    private ArrayList<String> mImageNames= new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<>();
    private ArrayList<String> mprojectName=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(RecycleViewclickListener recycleViewclickListener,ArrayList<String> imageName, ArrayList<String> image, ArrayList<String> projectName, Context mContext) {
        this.recycleViewclickListener = recycleViewclickListener;
        mImageNames = imageName;
        mImages = image;
        mprojectName = projectName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .load(mImages.get(position))
                .into(holder.image);
        holder.imageName.setText(mImageNames.get(position));
        holder.projectName.setText(mprojectName.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        TextView projectName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            imageName=itemView.findViewById(R.id.uname);
            projectName=itemView.findViewById(R.id.projectname);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewclickListener.myFunction(v,getAdapterPosition());

                }
            });



        }
    }
}
