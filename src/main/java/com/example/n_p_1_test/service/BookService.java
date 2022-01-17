package com.example.n_p_1_test.service;

import com.example.n_p_1_test.entity.Book;
import com.example.n_p_1_test.entity.User;
import com.example.n_p_1_test.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> initData(List<User> users) {

        List<Book> books = new ArrayList<>();

        for (User user : users) {
            for (int i=0; i < 5; i++) {
                books.add(new Book(null,user.getName() + "book" + i, user));
            }
        }
        return bookRepository.saveAll(books);
    }
}
