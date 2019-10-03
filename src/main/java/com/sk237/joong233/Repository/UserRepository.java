package com.sk237.joong233.Repository;

import com.sk237.joong233.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserIdAndUserPw(String userId, String userPw);

}
