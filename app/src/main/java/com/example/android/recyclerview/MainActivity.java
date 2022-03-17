package com.example.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<String> mPNames=new ArrayList<>();
    private ArrayList<String> mImageUrls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/1.png");
        mNames.add("Prajwal Kotian");
        mPNames.add("Competitive Programming");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/4.jpg");
        mNames.add("Jyeshtha Vartak");
        mPNames.add("Deep Learning");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/2.jpg");
        mNames.add("Akshay Bhatt");
        mPNames.add("Neural Networks");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/2.png");
        mNames.add("Hitansh Shah");
        mPNames.add("Data Analytics");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/3.jpg");
        mNames.add("Jash Gopani");
        mPNames.add("Developing Apps");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/3.png");
        mNames.add("Chetan Kachaliya");
        mPNames.add("Relativity");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(new RecycleViewclickListener() {
            @Override
            public void myFunction(View v, int position) {
                Toast.makeText(MainActivity.this, mImageUrls.get(position), Toast.LENGTH_SHORT).show();
            }
        },mNames, mImageUrls, mPNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
