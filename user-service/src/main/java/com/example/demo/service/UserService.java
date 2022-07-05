package com.example.demo.service;

import com.example.demo.domain.APIResponse;
import com.example.demo.entity.Users;
import com.example.demo.repo.UserRepo;
import com.example.demo.util.Constants;
import com.example.demo.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepo userRepo, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
    }

    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public ResponseTemplateVO getAllUserDetailsByUserID(Long userID) {
        Users users;
        APIResponse apiResponse;
        Optional<Users> userById = userRepo.findById(userID);
        users = userById.orElse(null);
        log.info("DepartmentID : {}", userById.get().getDepartmentID());
        /*
        *   apiResponse = restTemplate.getForObject("http://localhost:9002/department/departments/" +
                       userById.get().getDepartmentID(),
               APIResponse.class);*/
        apiResponse = userById.map(value ->
                restTemplate.getForObject(Constants.HTTP_PROTOCOL
                                .concat(Constants.DEPARTMENT_SERVICE)
                                .concat("/department/departments/")
                                .concat(value.getDepartmentID()),
                        APIResponse.class)).orElse(null);


        assert apiResponse != null;
        return ResponseTemplateVO.builder()
                .users(users)
                .department(apiResponse)
                .build();

    }
}
