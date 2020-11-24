package com.doufu.words.Dao;

import com.doufu.words.Domain.VipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VipTypeRepository extends JpaRepository<VipType, Integer> {
    VipType findAllById(Integer id);
}
