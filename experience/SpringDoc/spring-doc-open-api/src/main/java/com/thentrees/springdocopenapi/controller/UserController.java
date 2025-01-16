package com.thentrees.springdocopenapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "CURD REST APIs for User resource",
        description = "CURD REST APIs - Create User, Update User, Delete User, Get User and Get All Users"
)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // Tóm tắt: Tạo một API để tạo mới một User
    @Operation(
            summary = "Create a new User", // tóm tắt api này dùng để làm gì
            description = "Create a new User used to save user in db" // mô tả chi tiết hơn về api này
    )
    @ApiResponse(
            responseCode = "201",
            description = "User created successfully"
    )
    @PostMapping
    public String createUser() {
        return "Create User API";
    }

}
