
package com.dems_care.demscare.dao.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookItemCollectionDao {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("books")
    @Expose
    private List<Book> books = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
