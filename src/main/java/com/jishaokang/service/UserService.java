package com.jishaokang.service;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/**
 * Created by NANA_Final on 2020/3/21.
 */
public interface UserService {
    Result login(User user, HttpSession session) throws NoSuchAlgorithmException;

    Result addUser(User user) throws NoSuchAlgorithmException;

    Result sendVerification(User user) throws IOException;

    Result logout(User user, HttpSession session);

    Result getUserCurrent(HttpSession session);

    Result updateUserPassword(User user) throws NoSuchAlgorithmException;

    Result updatePhone(User user);

    Result updateUsername(User user);

    Result updateUserImage(MultipartFile imageFile, HttpServletRequest request,HttpSession session) throws IOException;


}