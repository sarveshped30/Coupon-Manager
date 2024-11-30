package org.dev.coupons.controller;

import jakarta.validation.Valid;
import org.dev.coupons.exception.PersistenceException;
import org.dev.coupons.dto.CouponDTO;
import org.dev.coupons.exception.ResourceNotFoundException;
import org.dev.coupons.service.CouponManager;
import org.dev.coupons.vo.CouponVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    public final CouponManager couponManager;

    public CouponController(CouponManager couponManager) {
        this.couponManager = couponManager;
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<CouponVO> create(@RequestBody @Valid CouponDTO couponDTO) throws PersistenceException {
        return ResponseEntity.ok(couponManager.create(couponDTO));
    }

    @GetMapping(path = "/fetchAll", produces = "application/json")
    public ResponseEntity<List<CouponVO>> fetchAll() {
        return ResponseEntity.ok(couponManager.findAllCoupons());
    }

    @GetMapping(path = "/fetchAllActive", produces = "application/json")
    public ResponseEntity<List<CouponVO>> fetchAllActive() {
        return ResponseEntity.ok(couponManager.findAllActiveCoupons());
    }

    @GetMapping(path = "/fetch/{code}")
    public ResponseEntity<CouponVO> fetchByCode(@PathVariable String code) throws ResourceNotFoundException {
        return ResponseEntity.ok(couponManager.findByCode(code));
    }

}
