package com.lynam.Automated.Cuteness.repo;

import com.lynam.Automated.Cuteness.model.TheModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheRepo extends JpaRepository<TheModel, Long> {

}
