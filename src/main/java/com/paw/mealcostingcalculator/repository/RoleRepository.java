package com.paw.mealcostingcalculator.repository;

import com.paw.mealcostingcalculator.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(RoleEntity.ERole name);
}
