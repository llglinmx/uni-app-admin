package com.doufu.words.Service;

import com.doufu.words.Controller.DTO.OrderParameter;
import com.doufu.words.Model.vo.Result;

public interface OrdersService {
    Result createOrder(OrderParameter orderParameter);
}
