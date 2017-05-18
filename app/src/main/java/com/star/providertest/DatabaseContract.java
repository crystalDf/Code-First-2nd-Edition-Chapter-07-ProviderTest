package com.star.providertest;


import android.net.Uri;

public final class DatabaseContract {

    public static final String AUTHORITY = "com.star.sqlitebestpractice.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    public static final Uri BOOK_CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "book");

    public static final String TABLE_BOOK = "Book";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_PAGES = "pages";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_FOREIGN_CATEGORY_ID = "category_id";

    public static final String TABLE_CATEGORY = "Category";
    public static final String COLUMN_CATEGORY_ID = COLUMN_ID;
    public static final String COLUMN_CATEGORY_NAME = "category_name";
    public static final String COLUMN_CATEGORY_CODE = "category_code";
}
