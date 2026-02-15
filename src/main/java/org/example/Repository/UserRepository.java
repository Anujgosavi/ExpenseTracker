package org.example.Repository;

import org.example.Entity.RefreshToken;
import org.example.Entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {


    public UserInfo findByUserName(String userName);

}
