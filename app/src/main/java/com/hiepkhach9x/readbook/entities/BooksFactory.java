package com.hiepkhach9x.readbook.entities;

/**
 * Created by HungHN on 2/1/2016.
 */
public class BooksFactory {

    public static final int TXT_BOOK = 1000;
    public static final int EPUB_BOOK = 1001;

    public static BooksFactory getInstance(){
        return new BooksFactory();
    }

    private Books getBooks(int type){
        switch (type){
            case TXT_BOOK:
                return new TxtBook();
            case EPUB_BOOK:
                return new EpubBook();
            default:
                return null;
        }
    }
}
