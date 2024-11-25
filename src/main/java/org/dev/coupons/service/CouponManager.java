package org.dev.coupons.service;

import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.vo.CouponVO;

public interface CouponManager {

   CouponVO create(CouponDTO couponDTO) throws PersistenceException;
}
