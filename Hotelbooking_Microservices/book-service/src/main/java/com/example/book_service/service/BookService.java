package com.example.book_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBooking(Book booking) {
        return bookRepository.save(booking);
    }
}
