package com.playingwithee.restapi.books.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;

import java.util.ArrayList;
import java.util.List;


public class BookListVM extends HateoasSupportingVM {

    private List<BookListItemVM> bookList;

    public List<BookListItemVM> getBookList() {
        if (bookList == null){
            bookList = new ArrayList<>();
        }
        return bookList;
    }
}
