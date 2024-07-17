package org.example.controller;

import org.example.dto.PageDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
   public PageDto get(){
        return userService.search();
    }
    @PostMapping("/user")
    public PageDto search(@RequestBody UserDto userDto){
        return userService.search(userDto);
    }
    @PostMapping("/user")
    public PageDto add(@RequestBody  UserDto userDto){
        return userService.search(userDto);
    }
    @PutMapping("/user")
    public PageDto update(@RequestBody  UserDto userDto){
        return userService.search(userDto);
    }
    @DeleteMapping("/user")
    public PageDto delete(@RequestBody  UserDto userDto){
        return userService.search(userDto);
    }

    @GetMapping("/search")
    public PageDto searchUsers(UserDto userDto) {
        return userService.searchUser(userDto);
    }


}
