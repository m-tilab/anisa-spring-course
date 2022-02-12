package com.example.springbatch.batch;

import com.example.springbatch.domain.User;
import com.example.springbatch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    public DBWriter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends User> users) throws Exception {

        log.info("Data saved for users " + users);
        userRepository.saveAll(users);
    }
}
