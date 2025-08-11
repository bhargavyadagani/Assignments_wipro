package com.example.book_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.model.Book;
import com.example.book_service.service.BookService;

@RestController
@RequestMapping("/bookings")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBooking(@RequestBody Book booking) {
        return bookService.saveBooking(booking);
    }
}