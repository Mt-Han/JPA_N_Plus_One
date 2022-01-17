package com.example.n_p_1_test.runner;

import com.example.n_p_1_test.entity.Book;
import com.example.n_p_1_test.entity.User;
import com.example.n_p_1_test.service.BookService;
import com.example.n_p_1_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Order(2)
@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final UserService userService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        List<User> users = userService.findAll();

        for (User user : users) {
            for (Book book : user.getBooks()) {
                // ... 비지니스 로직 ...
            }
        }
    }
}
