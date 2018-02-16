package com.star.providertest;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Button mInsertDataButton;
    private Button mUpdateDataButton;
    private Button mDeleteDataButton;
    private Button mQueryDataButton;

    private long mNewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInsertDataButton = findViewById(R.id.insert_data);
        mInsertDataButton.setOnClickListener(v -> {
            Uri uri = DatabaseContract.BOOK_CONTENT_URI;

            ContentValues contentValues = new ContentValues();

            contentValues.put(DatabaseContract.BOOK_COLUMN_NAME, "A Clash of Kings");
            contentValues.put(DatabaseContract.BOOK_COLUMN_AUTHOR, "George Martin");
            contentValues.put(DatabaseContract.BOOK_COLUMN_PAGES, 1040);
            contentValues.put(DatabaseContract.BOOK_COLUMN_PRICE, 22.85);

            Uri newUri = getContentResolver().insert(uri, contentValues);

            if (newUri != null) {
                mNewId = Long.parseLong(newUri.getPathSegments().get(1));
            }
        });

        mUpdateDataButton = findViewById(R.id.update_data);
        mUpdateDataButton.setOnClickListener(v -> {
            Uri uri = ContentUris.withAppendedId(DatabaseContract.BOOK_CONTENT_URI, mNewId);

            ContentValues contentValues = new ContentValues();

            contentValues.put(DatabaseContract.BOOK_COLUMN_NAME, "A Storm of Swords");
            contentValues.put(DatabaseContract.BOOK_COLUMN_PAGES, 1216);
            contentValues.put(DatabaseContract.BOOK_COLUMN_PRICE, 24.05);

            getContentResolver().update(uri, contentValues, null, null);
        });

        mDeleteDataButton = findViewById(R.id.delete_data);
        mDeleteDataButton.setOnClickListener(v -> {
            Uri uri = ContentUris.withAppendedId(DatabaseContract.BOOK_CONTENT_URI, mNewId);

            getContentResolver().delete(uri, null, null);
        });

        mQueryDataButton = findViewById(R.id.query_data);
        mQueryDataButton.setOnClickListener(v -> {
            Uri uri = DatabaseContract.BOOK_CONTENT_URI;

            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            if (cursor != null) {

                while (cursor.moveToNext()) {

                    String name = cursor.getString(cursor.getColumnIndex(
                            DatabaseContract.BOOK_COLUMN_NAME));
                    String author = cursor.getString(cursor.getColumnIndex(
                            DatabaseContract.BOOK_COLUMN_AUTHOR));
                    int pages = cursor.getInt(cursor.getColumnIndex(
                            DatabaseContract.BOOK_COLUMN_PAGES));
                    double price = cursor.getDouble(cursor.getColumnIndex(
                            DatabaseContract.BOOK_COLUMN_PRICE));

                    Log.d(TAG, "Book name is " + name);
                    Log.d(TAG, "Book author is " + author);
                    Log.d(TAG, "Book pages is " + pages);
                    Log.d(TAG, "Book price is " + price);

                }

                cursor.close();
            }
        });
    }
}
