package com.renault.gdpr.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PIIUserRepository extends JpaRepository<PIIUser,Integer> {
}
