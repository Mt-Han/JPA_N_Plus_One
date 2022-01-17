package com.example.n_p_1_test.service;

import com.example.n_p_1_test.entity.User;
import com.example.n_p_1_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> initData() {

        List<User> users = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            users.add(new User(null, "user" + i, "email" + i, null));
        }
        return userRepository.saveAll(users);
    }
}
