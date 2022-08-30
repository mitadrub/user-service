package com.user.userservice.service;

import com.user.userservice.entity.UserEntity;
import com.user.userservice.repository.UserRepository;
import com.user.userservice.valueobject.Department;
import com.user.userservice.valueobject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        log.info("Inside saveUser of UserController");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        UserEntity user = userRepository.findByUserId(userId);
        Department department = restTemplate.
                getForObject("http://localhost:8001/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
