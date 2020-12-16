package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.User;
import com.jishaokang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    //------------------------------------------
    @RequestMapping(value = "/all/user/login",method = RequestMethod.POST)
    public Result userLogin(@RequestBody User user,HttpSession session) throws NoSuchAlgorithmException {
        return userService.login(user,session);
    }

    @RequestMapping(value = "/all/user/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.addUser(user);
    }
    @RequestMapping(value = "/all/user/sendVerification",method = RequestMethod.POST)
    public Result sendVerification(@RequestBody User user) throws IOException {
        return userService.sendVerification(user);
    }

    @RequestMapping(value = "/user/user/logout",method = RequestMethod.POST)
    public Result userLogout(@RequestBody User user, HttpSession session) {
        return userService.logout(user,session);
    }

    @RequestMapping(value = "/user/user/getUserCurrent",method = RequestMethod.POST)
    public Result getUserCurrent(HttpSession session) {
        return userService.getUserCurrent(session);
    }

    @RequestMapping(value = "/user/user/updateUserPassword",method = RequestMethod.POST)
    public Result updateUserPassword(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.updateUserPassword(user);
    }

    @RequestMapping(value = "/user/user/updatePhone",method = RequestMethod.POST)
    public Result updatePhone(@RequestBody User user){
        return userService.updatePhone(user);
    }

    @RequestMapping(value = "/user/user/updateUsername",method = RequestMethod.POST)
    public Result updateUsername(@RequestBody User user) {
        return userService.updateUsername(user);
    }

    @RequestMapping(value = "/user/user/uploadUserImage",method = RequestMethod.POST)
    public Result updateUserImage(@RequestParam(value = "userImageFile", required = false) MultipartFile imageFile, HttpServletRequest request, HttpSession session) throws IOException {
        return userService.updateUserImage(imageFile,request,session);
    }

}