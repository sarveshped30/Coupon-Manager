package org.dev.coupons.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Coupon {

    @Id
    private String code;        //create custom annotation for checking uniqueness
    private CouponType type;
    private DiscountType discountType;
    private BigDecimal discountValue;
    private boolean isUsed;
    private LocalDate expiryDate;       //create custom annotation for checking expiryDate
    private final LocalDate createDate = LocalDate.now();
    private String description;

    protected Coupon() {

    }

    @Builder
    public Coupon(String code, CouponType type, DiscountType discountType, BigDecimal discountValue,
                  LocalDate expiryDate, String description) {
        this.code = code;
        this.type = type;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.expiryDate = expiryDate;
        this.description = description;
    }
}
