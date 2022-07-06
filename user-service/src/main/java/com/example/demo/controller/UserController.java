
package com.example.demo.controller;

import com.example.demo.domain.APIResponse;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import com.example.demo.util.Constants;
import com.example.demo.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.USER_REQ_MAPPING)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public APIResponse createUser(@RequestBody Users users){
        Users user = userService.createUser(users);
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.SUCCESS_MASSAGE)
                .data(user)
                .build();

    }

    @GetMapping("/users")
    public APIResponse getAllUsers(){
        List<Users> allUsers = userService.getAllUsers();
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.GET_MESSAGE)
                .data(allUsers)
                .build();

    }

    @GetMapping("/users/{userID}")
    public APIResponse getAllUserDetailsByUserID(@PathVariable("userID") Long userID){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseTemplateVO allUsers = userService.getAllUserDetailsByUserID(userID);
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.GET_MESSAGE)
                .data(allUsers)
                .build();

    }


}
