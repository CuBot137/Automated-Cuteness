package com.lynam.Automated.Cuteness.repo;

import com.lynam.Automated.Cuteness.model.TheModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TheRepo extends JpaRepository<TheModel, Long> {
}
