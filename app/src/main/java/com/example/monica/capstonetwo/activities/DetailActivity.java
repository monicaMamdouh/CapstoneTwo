package com.example.monica.capstonetwo.activities;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monica.capstonetwo.R;
import com.example.monica.capstonetwo.dataBase.myContract;
import com.example.monica.capstonetwo.model.Data_;
import com.example.monica.capstonetwo.widget.listWidgetService;
import com.example.monica.capstonetwo.widget.monicaWidget;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView posterImageView;
    private TextView authorTextView;
    private FloatingActionButton floatingActionButton;
    private  Data_ data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        data = (Data_) bundle.getSerializable("Object");
        titleTextView=(TextView)findViewById(R.id.title);
        posterImageView=(ImageView)findViewById(R.id.backDrop);
        authorTextView=(TextView)findViewById(R.id.author);

        titleTextView.setText(data.getTitle());
        authorTextView.setText(data.getAuthor());
        Picasso.with(getApplicationContext()).load(R.drawable.reddit).into(posterImageView);

        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(myContract.sunRedditEntry.COLUMN_SUBRED_AUTHOR,data.getAuthor());
                contentValues.put(myContract.sunRedditEntry.COLUMN_SUBRED_TITLE, data.getTitle());

                try {
                    Uri uri =getContentResolver().insert(myContract.sunRedditEntry.CONTENT_URI, contentValues);


                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
                    ComponentName thisAppWidget = new ComponentName(getApplicationContext().getPackageName(), monicaWidget.class.getName());
                    int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
                    appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds,R.id.list_view);

                    if (uri != null) {
                        Toast.makeText(getApplicationContext(), "movie marked as 'FAVOURITE'", Toast.LENGTH_SHORT).show();
                    //    floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.correct));

                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "This Movie is already marked as 'FAVOURITE'", Toast.LENGTH_SHORT).show();
                   // floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.correct));

                }

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here
            Explode enterTransition = new Explode();
            Transition transition=enterTransition.setDuration(500);
            getWindow().setEnterTransition(transition);

        }

    }

}
