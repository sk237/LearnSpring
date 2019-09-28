package com.sk237.joong233.Service;

import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordHash userPasswordHash;

    public String joinUser(String userId, String userPw, String userName) {
        if (userId.isEmpty() || userPw.isEmpty() || userName.isEmpty()) {
            return "join";
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserPw(userPasswordHash.getSHA256(userPw));
        user.setUserName(userName);
        userRepository.save(user);

        return "index";
    }

}
