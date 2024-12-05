package org.dev.coupons.service;

import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.exception.ResourceNotFoundException;
import org.dev.coupons.vo.CouponVO;
import java.util.List;

public interface CouponManager {

   CouponVO create(CouponDTO couponDTO) throws PersistenceException;

   List<CouponVO> findAllCoupons();

   List<CouponVO> findAllActiveCoupons();

   CouponVO findByCode(String code) throws ResourceNotFoundException;

   void delete(String code) throws ResourceNotFoundException;

}
