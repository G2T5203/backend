package com.G2T5203.wingit.repository;

import com.G2T5203.wingit.model.WingitUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WingitUser, Integer> {

}
