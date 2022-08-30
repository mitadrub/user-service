package com.user.userservice.valueobject;

import com.user.userservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private UserEntity user;
    private Department department;
}
