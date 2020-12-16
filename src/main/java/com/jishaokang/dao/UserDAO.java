package com.jishaokang.dao;

import com.jishaokang.model.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2020/4/21.
 */
@Repository
public interface UserDAO {
    String selectPasswordByPhone(String phone);

    User selectByPhone(String phone);

    void insert(User user);

    User selectByUserId(int userId);

    void updatePassword(User user);

    void updatePhone(User user);

    void updateUsername(User user);

    void updateUserImage(User user);


}
