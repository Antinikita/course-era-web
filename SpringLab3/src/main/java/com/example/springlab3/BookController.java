package com.example.springlab3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    public static class Book {
        private String title;
        private String author;
        private String status;

        // Getters и Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    // Endpoint, который принимает POST-запрос с JSON
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        // Устанавливаем статус "received"
        book.setStatus("received");

        // Возвращаем обновленный объект книги
        return book;
    }
}
