package com.doufu.words.Dao;

import com.doufu.words.Domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer> {

}
