package com.service.service;

import com.service.ValueObjects.Department;
import com.service.ValueObjects.ResponseTemplateVO;
import com.service.entity.UserEntity;
import com.service.repository.UserRepository;
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

    public UserEntity saveUser(UserEntity department) {
        log.info("Inside saveDepartment of DepartmentService");
        return userRepository.save(department);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
         ResponseTemplateVO vo = new ResponseTemplateVO();
         UserEntity user = userRepository.findByUserId(userId);
        System.out.println("user in service"+user);
        System.out.println("department id is :"+user.getDepartmentId());
        Department department = restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(),Department.class);
        //vo.setUser(user);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
