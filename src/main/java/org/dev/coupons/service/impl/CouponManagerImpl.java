package org.dev.coupons.service.impl;

import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.domain.Coupon;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;
import org.dev.coupons.repository.CouponRepository;
import org.dev.coupons.service.CouponManager;
import org.dev.coupons.vo.CouponVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CouponManagerImpl implements CouponManager {

    private final CouponRepository couponRepository;

    public CouponManagerImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public CouponVO create(CouponDTO couponDTO) throws PersistenceException {
        Coupon coupon = Coupon.builder()
                .code(couponDTO.getCode())
                .type(CouponType.valueOf(couponDTO.getType()))
                .discountType(DiscountType.valueOf(couponDTO.getDiscountType()))
                .discountValue(couponDTO.getDiscountValue())
                .expiryDate(LocalDate.parse(couponDTO.getExpiryDate()))
                .description(couponDTO.getDescription())
                .build();
        Coupon saved = Optional.of(couponRepository.save(coupon)).orElseThrow(() ->
                new PersistenceException("Unable to persist coupon data, please try after sometime."));
        return new CouponVO(saved);
    }
}
