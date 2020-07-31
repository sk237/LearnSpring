package com.sk237.joong233.Service;

import com.sk237.joong233.Model.User;
import com.sk237.joong233.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String userId, String userPw) {

        if (userId.isEmpty() || userPw.isEmpty()) {
            return null;
        }

        return userRepository.findByUserIdAndUserPw(userId, getSHA256(userPw));

    }

    public String joinUser(String userId, String userPw, String userName) {
        if (userId.isEmpty() || userPw.isEmpty() || userName.isEmpty()) {
            return "join";
        }

        User user = User.builder()
                .userId(userId)
                .userPw(getSHA256(userPw))
                .userName(userName)
                .build();

        userRepository.save(user);

        return "index";
    }

    private String getSHA256(String plainText) {
        String shaString = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(plainText.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                stringBuffer.append(Integer.toString(byteData[i] + 0x100, 16)).substring(1);
            }
            shaString = stringBuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            shaString = null;
        }
        return shaString;
    }


}
