package org.dev.coupons.domain;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String code;        //create custom annotation for checking uniqueness
    @Enumerated(EnumType.STRING)
    private CouponType type;
    @Enumerated(EnumType.STRING)
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
