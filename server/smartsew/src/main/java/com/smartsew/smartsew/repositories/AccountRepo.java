package com.smartsew.smartsew.repositories;

import com.smartsew.smartsew.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsernameAndPassword(String username, String password);
}
