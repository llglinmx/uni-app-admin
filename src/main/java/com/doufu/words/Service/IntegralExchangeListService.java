package com.doufu.words.Service;

import com.doufu.words.Controller.DTO.IntegralParameter;
import com.doufu.words.Model.vo.Result;

public interface IntegralExchangeListService {
    Result getExchangeList(IntegralParameter integralParameter);

    Result exchangeVip(IntegralParameter integralParameter);
}
