package com.dems_care.demscare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dems_care.demscare.dao.book.Book;
import com.dems_care.demscare.dao.book.BookItemCollectionDao;
import com.dems_care.demscare.view.BookListItem;


/**
 * Created by Bon on 14/9/2560.
 */
public class BookListAdapter extends BaseAdapter {

    BookItemCollectionDao dao;

    public BookItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(BookItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getBooks() == null)
            return 0;
        return dao.getBooks().size();
    }

    @Override
    public Object getItem(int position) {

        return dao.getBooks().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookListItem item;
        if (convertView != null)
            item = (BookListItem) convertView;
        else
            item = new BookListItem(parent.getContext());

        // get Data from DAO
        Book dao = (Book) getItem(position);
        // set value
        item.setNameTitle(dao.getTitle());
        item.setImageUrl(dao.getImageUrl());

        return item;
    }
}
