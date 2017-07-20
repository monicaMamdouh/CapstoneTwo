package com.example.monica.capstonetwo.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monica.capstonetwo.R;
import com.example.monica.capstonetwo.dataBase.myContract;
import com.squareup.picasso.Picasso;

/**
 * Created by monica on 7/14/2017.
 */

 /**
     * A simple {@link Fragment} subclass.
     */
    public class FavouriteDetailActivity extends AppCompatActivity {


     private TextView titleTextView;
     private ImageView posterImageView;
     private TextView authorTextView;
     private FloatingActionButton floatingActionButton;
     private int cursorPosition;
     private Cursor cursor;

     public static final String EXTRA_CURSOR_POSITION="position";
     public FavouriteDetailActivity() {

     }

     @Override
     public void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_detail);

         titleTextView=(TextView)findViewById(R.id.title);
         posterImageView=(ImageView)findViewById(R.id.backDrop);
         authorTextView=(TextView)findViewById(R.id.author);

         int positionWidget=getIntent().getIntExtra(EXTRA_CURSOR_POSITION,-1);
         int positionCursor=getIntent().getIntExtra("cursorPosition", -1);
         if( positionWidget > -1)
         {
             cursorPosition=positionWidget;
         }
         else  {
             cursorPosition = positionCursor;
         }




         try {
             cursor = getContentResolver().query(myContract.sunRedditEntry.CONTENT_URI,
                     null,
                     null,
                     null,
                     null);

         } catch (Exception e) {
             e.printStackTrace();
         }


         cursor.moveToPosition(cursorPosition);
         int titleIndex = cursor.getColumnIndex(myContract.sunRedditEntry.COLUMN_SUBRED_TITLE);
         int authorIndex = cursor.getColumnIndex(myContract.sunRedditEntry.COLUMN_SUBRED_AUTHOR);


         String title = cursor.getString(titleIndex);
         String author= cursor.getString(authorIndex);


         Picasso.with(this).load(R.drawable.reddit).into(posterImageView);
       //  Picasso.with(getActivity()).load("https://image.tmdb.org/t/p/w320/" + poster).placeholder(R.drawable.error).error(R.drawable.icon).noFade().into(mPosterImageView);
         titleTextView.setText(title);
         authorTextView.setText(author);


     }



    }


