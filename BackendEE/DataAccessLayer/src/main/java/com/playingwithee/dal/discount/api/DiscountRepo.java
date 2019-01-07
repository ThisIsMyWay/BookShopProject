package com.playingwithee.dal.discount.api;

import com.playingwithee.dal.discount.api.dto.DiscountData;

import java.io.Serializable;

public interface DiscountRepo extends Serializable {

    public void addDiscount(DiscountData discountData);
}
