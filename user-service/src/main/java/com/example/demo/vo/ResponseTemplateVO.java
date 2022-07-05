package com.example.demo.vo;

import com.example.demo.domain.APIResponse;
import com.example.demo.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTemplateVO {

    private Users users;
    private APIResponse department;

}
