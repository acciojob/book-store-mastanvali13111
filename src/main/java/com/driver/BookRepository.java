package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository(){

    }
    private int id=1;
    HashMap<Integer,Book> db=new HashMap<>();

    public Book save(Book book){
        book.setId(id);
        db.put(id,book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        return db.get(id);
    }

    public List<Book> findAll(){
        List<Book> books=new ArrayList<>();
        for(Integer i: db.keySet()){
            books.add(db.get(i));
        }
        return books;
    }

    public void deleteBookById(int id){
        if(db.containsKey(id))
            db.remove(id);
        return;
    }

    public void deleteAll(){
        db.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books=new ArrayList<>();
        for(Integer i: db.keySet()){
            if(db.get(i).getAuthor().equals(author)){
                books.add(db.get(i));
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books=new ArrayList<>();
        for(Integer i: db.keySet()){
            if(db.get(i).getGenre().equals(genre)){
                books.add(db.get(i));
            }
        }
        return books;
    }
}