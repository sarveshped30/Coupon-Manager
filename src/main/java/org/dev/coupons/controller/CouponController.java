package org.dev.coupons.controller;

import netscape.javascript.JSObject;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.service.CouponManager;
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
    public ResponseEntity<JSObject> create(@RequestBody CouponDTO couponDTO) {
        couponManager.create(couponDTO);
        return ResponseEntity.ok(null);
    }


}
