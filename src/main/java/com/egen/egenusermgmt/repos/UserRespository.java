package com.egen.egenusermgmt.repos;

import com.egen.egenusermgmt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by lakinep on 7/16/17.
 */
@Repository
public interface UserRespository extends JpaRepository<User, UUID> {
}
