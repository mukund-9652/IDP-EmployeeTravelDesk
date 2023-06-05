package com.cognizant.employeetraveldesk.humanresources.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.humanresources.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
