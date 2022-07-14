package com.metanet.meriteshopbatch.service;

import com.metanet.meriteshopbatch.entity.User;
import com.metanet.meriteshopbatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerivce {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

}
