package com.example.n_p_1_test.runner;

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

@Component
@Order(1)
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final UserService userService;
    private final BookService bookService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = userService.initData();
        bookService.initData(users);

    }
}
