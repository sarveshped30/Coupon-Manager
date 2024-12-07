package org.dev.coupons.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.dev.coupons.dto.UpdateCouponDTO;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;
import org.springframework.data.annotation.LastModifiedDate;

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
    @LastModifiedDate
    private LocalDate updateDate;
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

    public Coupon update(UpdateCouponDTO update) {
        this.type = update.getType() != null ? CouponType.valueOf(update.getType()) : type;
        this.discountType = update.getDiscountType() != null ? DiscountType.valueOf(update.getType()) : discountType;
        this.discountValue = update.getDiscountValue() != null ? update.getDiscountValue() : discountValue;
        this.expiryDate = update.getExpiryDate() != null ? LocalDate.parse(update.getExpiryDate()) : expiryDate;
        this.description = update.getDescription() != null ? update.getDescription() : description;
        return this;
    }
}
