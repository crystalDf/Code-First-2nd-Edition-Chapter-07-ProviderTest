package com.star.providertest;


import android.net.Uri;

public final class DatabaseContract {

    public static final String TABLE_BOOK_NAME = "Book";
    public static final String BOOK_COLUMN_ID = "_id";
    public static final String BOOK_COLUMN_AUTHOR = "author";
    public static final String BOOK_COLUMN_PRICE = "price";
    public static final String BOOK_COLUMN_PAGES = "pages";
    public static final String BOOK_COLUMN_NAME = "name";
    public static final String BOOK_COLUMN_CATEGORY_ID = "category_id";

    public static final String TABLE_CATEGORY_NAME = "Category";
    public static final String CATEGORY_COLUMN_ID = "_id";
    public static final String CATEGORY_COLUMN_NAME = "category_name";
    public static final String CATEGORY_COLUMN_CODE = "category_code";

    public static final String AUTHORITY = "com.star.sqlitebestpractice.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    public static final Uri BOOK_CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI,
            TABLE_BOOK_NAME.toLowerCase());

}
