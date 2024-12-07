package org.dev.coupons.service.impl;

import org.dev.coupons.dto.UpdateCouponDTO;
import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.domain.Coupon;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;
import org.dev.coupons.exception.ResourceNotFoundException;
import org.dev.coupons.repository.CouponRepository;
import org.dev.coupons.service.CouponManager;
import org.dev.coupons.vo.CouponVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<CouponVO> findAllCoupons() {
        List<CouponVO> couponVOS = new ArrayList<>();
        couponRepository.findAll().forEach(coupon -> couponVOS.add(new CouponVO(coupon)));
        return couponVOS;
    }

    @Override
    public List<CouponVO> findAllActiveCoupons() {
        List<CouponVO> couponVOS = new ArrayList<>();
        couponRepository.findAllActiveCoupons().forEach(coupon -> couponVOS.add(new CouponVO(coupon)));
        return couponVOS;
    }

    @Override
    public CouponVO findByCode(String code) throws ResourceNotFoundException {
        Coupon coupon = couponRepository.findByCode(code).orElseThrow(
                () -> new ResourceNotFoundException("Coupon Not Found for given code : " + code));
        return new CouponVO(coupon);
    }

    @Override
    public void delete(String code) throws ResourceNotFoundException {
        Coupon coupon = couponRepository.findByCode(code).orElseThrow(
                () -> new ResourceNotFoundException("Coupon Not Found for given code : " + code));
        couponRepository.delete(coupon);
    }

    @Override
    public CouponVO update(UpdateCouponDTO couponDTO) throws ResourceNotFoundException, PersistenceException {
        Coupon coupon = couponRepository.findByCode(couponDTO.getCode())
                .orElseThrow(() -> new ResourceNotFoundException("Coupon Not Found for given code : " + couponDTO.getCode()));
        return new CouponVO(Optional.of(couponRepository.save(coupon.update(couponDTO))).orElseThrow(() ->
                new PersistenceException("Unable to update coupon data, please try after sometime.")));
    }
}
