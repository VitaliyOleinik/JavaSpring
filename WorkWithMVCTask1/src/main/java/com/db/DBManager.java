package com.db;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Books>allBooks = new ArrayList<>();
    public static Long id = 5L;

    static {
        allBooks.add(new Books(1L, "Rich dad and poor dad", "R.Kiyosaki", 50));
        allBooks.add(new Books(2L, "JavaEE", "Herbert Shield", 100));
        allBooks.add(new Books(3L, "Java", "Vitaliy Oleinik", 75));
        allBooks.add(new Books(4L, "Abay’s road", "Mukhtar Auezov", 80));
    }

    public static void addBook(Books book){
        book.setId(id);
        allBooks.add(book);
        id++;
    }

    public static ArrayList<Books>getAllBooks(){
        return allBooks;
    }

    public static ArrayList<Books> getBookByName(String name){
        ArrayList<Books>searchedBooks = new ArrayList<>();
        for(Books book: allBooks){
            if(book.getName().equals(name)){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }
}
