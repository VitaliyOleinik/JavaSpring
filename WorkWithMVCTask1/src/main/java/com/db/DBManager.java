package com.db;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Books>allBooks = new ArrayList<>();
    public static Long id = 1L;

    public static void addBook(Books book){
        book.setId(id);
        allBooks.add(book);
        id++;
    }

    public static ArrayList<Books>getAllBooks(){
        return allBooks;
    }

    public static Books getBookByName(String name){
        for(Books book: allBooks){
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }
}
