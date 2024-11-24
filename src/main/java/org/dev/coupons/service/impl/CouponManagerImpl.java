package org.dev.coupons.service.impl;

import org.dev.coupons.domain.Coupon;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;
import org.dev.coupons.repository.CouponRepository;
import org.dev.coupons.service.CouponManager;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CouponManagerImpl implements CouponManager {

    private final CouponRepository couponRepository;

    public CouponManagerImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void create(CouponDTO couponDTO) {
        Coupon coupon = Coupon.builder()
                .code(couponDTO.getCode())
                .type(CouponType.valueOf(couponDTO.getType()))
                .discountType(DiscountType.valueOf(couponDTO.getDiscountType()))
                .discountValue(couponDTO.getDiscountValue())
                .expiryDate(LocalDate.parse(couponDTO.getExpiryDate()))
                .build();
        couponRepository.save(coupon);
    }
}
