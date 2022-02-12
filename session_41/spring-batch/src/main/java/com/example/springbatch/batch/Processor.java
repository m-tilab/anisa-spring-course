package com.example.springbatch.batch;

import com.example.springbatch.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class Processor implements ItemProcessor<User, User> {

    public static Map<String, String> DEPT_NAMES = new HashMap<>();

    public Processor() {

        DEPT_NAMES = Map.of("001", "Technology", "002", "Operations", "003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception {

        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        user.setDept(dept);
        user.setDateTime(ZonedDateTime.now());

        log.info(String.format("Converted from [%s] to [%s]", deptCode, dept));

        return user;
    }
}
