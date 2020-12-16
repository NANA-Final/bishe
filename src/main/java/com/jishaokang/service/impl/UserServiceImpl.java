package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.UserDAO;
import com.jishaokang.model.dto.User;
import com.jishaokang.service.UserService;
import com.jishaokang.util.EncyptUtil;
import com.jishaokang.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private VerificationUtil verificationUtil;

    @Override
    public Result login(User user, HttpSession session) throws NoSuchAlgorithmException {
        String passwordInDB = userDAO.selectPasswordByPhone(user.getPhone());
        if (passwordInDB == null) {
            return ResultCache.getDataError(501,"用户不存在");
        }else if (EncyptUtil.encyptPassword(user.getPassword()).equals(passwordInDB)){
            User userInDB = userDAO.selectByPhone(user.getPhone());
            session.setAttribute("userId",userInDB.getUserId());
            return ResultCache.getDataOk(userInDB);
        }else{
            return ResultCache.getDataError(502,"用户名或密码错误");
        }
    }

    @Override
    public Result addUser(User user) throws NoSuchAlgorithmException {
        if (!verificationUtil.checkVerification(user.getPhone(),user.getVerification())) {
            return ResultCache.getDataError(501, "验证码错误");
        }
        user.setPassword(EncyptUtil.encyptPassword(user.getPassword()));
        userDAO.insert(user);
        return ResultCache.OK;
    }

    @Override
    public Result sendVerification(User user) throws IOException {
        verificationUtil.sendVerification(user.getPhone());
        return ResultCache.OK;
    }

    @Override
    public Result logout(User user, HttpSession session) {
        session.removeAttribute("userId");
        return ResultCache.OK;
    }

    @Override
    public Result getUserCurrent(HttpSession session) {
        if (session.getAttribute("userId") == null) return ResultCache.FAILURE;
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user = userDAO.selectByUserId(userId);
        return ResultCache.getDataOk(user);
    }

    @Override
    public Result updateUserPassword(User user) throws NoSuchAlgorithmException {
        if (!verificationUtil.checkVerification(user.getPhone(),user.getVerification())) {
            return ResultCache.getDataError(501, "验证码错误");
        }
        user.setPassword(EncyptUtil.encyptPassword(user.getPassword()));
        userDAO.updatePassword(user);
        return ResultCache.OK;
    }


    @Override
    public Result updatePhone(User user) {
        if (!verificationUtil.checkVerification(user.getPhone(),user.getVerification())){
            return ResultCache.getDataError(501,"验证码输入错误");
        }
        userDAO.updatePhone(user);
        return ResultCache.OK;
    }

    @Override
    public Result updateUsername(User user) {
        userDAO.updateUsername(user);
        return ResultCache.OK;
    }


    public static final String KEYSTRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int len = KEYSTRING.length();

    @Override
    public Result updateUserImage( MultipartFile imageFile, HttpServletRequest request,HttpSession session) throws IOException {

        Random random = new Random();
        StringBuilder sb = new StringBuilder(new Date().getTime()+"");
        for (int i = 0;i < 50;i++ )
            sb = sb.append(KEYSTRING.charAt(random.nextInt(len)));
        sb.append(".");
        sb.append(imageFile.getOriginalFilename().split("\\.")[1]);
        String path = request.getServletContext().getRealPath("/upload/userImage/");
        String fileName = sb.toString();
        File targetFile = new File(path, fileName);
        System.out.println(path+"   "+fileName);
        targetFile.createNewFile();
        try {
            imageFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User();
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        user.setUserId(userId);
        user.setUserImage("upload/userImage/"+fileName);
        userDAO.updateUserImage(user);
        return ResultCache.OK;
    }


}