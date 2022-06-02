package com.example.administrator.administrator.repository;

import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.model.ModelCurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository ("CurseJpaRepository")
public interface CurseJpaRepository extends JpaRepository<Curse, Serializable> {
}
