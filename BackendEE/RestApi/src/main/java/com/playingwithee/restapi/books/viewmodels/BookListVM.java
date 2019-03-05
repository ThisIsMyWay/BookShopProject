package com.playingwithee.restapi.books.viewmodels;

import com.playingwithee.restapi.hateoas.HateoasSupportingVM;

import java.util.HashSet;
import java.util.Set;


public class BookListVM extends HateoasSupportingVM {

    private Set<BookListItemVM> bookList;

    public Set<BookListItemVM> getBookList() {
        if (bookList == null){
            bookList = new HashSet<>();
        }
        return bookList;
    }
}
