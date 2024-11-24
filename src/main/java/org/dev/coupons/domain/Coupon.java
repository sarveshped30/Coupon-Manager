package org.dev.coupons.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Coupon {

    @Id
    private String code;
    private CouponType type;
    private DiscountType discountType;
    private BigDecimal discountValue;
    private boolean isUsed;
    private LocalDate expiryDate;
    private LocalDate createDate = LocalDate.now();

    protected Coupon() {

    }

    public Coupon(String code, CouponType type, DiscountType discountType, BigDecimal discountValue,
                  LocalDate expiryDate) {
        this.code = code;
        this.type = type;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.expiryDate = expiryDate;
    }
}
