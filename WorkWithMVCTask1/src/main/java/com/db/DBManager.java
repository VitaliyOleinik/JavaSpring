package com.db;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Books>allBooks = new ArrayList<>();
    public static Long id = 5L;

    static {
        allBooks.add(new Books(1L, "Rich dad and poor dad", "R.Kiyosaki", 50));
        allBooks.add(new Books(2L, "Java EE", "Herbert Shield", 100));
        allBooks.add(new Books(3L, "Java EE", "Vitaliy Oleinik", 75));
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

    public static Books getBookByName(String name){
        for(Books book: allBooks){
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }
}
