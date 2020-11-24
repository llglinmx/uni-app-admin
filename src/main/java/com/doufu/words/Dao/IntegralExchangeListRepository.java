package com.doufu.words.Dao;

import com.doufu.words.Domain.IntegralExchangeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntegralExchangeListRepository extends JpaRepository<IntegralExchangeList, Integer> {
    List<IntegralExchangeList> findAll();

    IntegralExchangeList findAllById(Integer integralId);
}
