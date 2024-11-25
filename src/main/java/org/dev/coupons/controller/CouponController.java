package org.dev.coupons.controller;

import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.service.CouponManager;
import org.dev.coupons.vo.CouponVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    public final CouponManager couponManager;

    public CouponController(CouponManager couponManager) {
        this.couponManager = couponManager;
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<CouponVO> create(@RequestBody CouponDTO couponDTO) throws PersistenceException {
        return ResponseEntity.ok(couponManager.create(couponDTO));
    }


}
