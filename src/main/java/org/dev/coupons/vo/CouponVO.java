package org.dev.coupons.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.dev.coupons.domain.Coupon;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class CouponVO {

    private String code;
    private String type;
    private String discountType;
    private BigDecimal discountValue;
    private String expiryDate;
    private String description;

    public CouponVO(String code, CouponType type, DiscountType discountType, BigDecimal discountValue,
                    LocalDate expiryDate, String description) {
        this.code = code;
        this.type = type.name();
        this.discountType = discountType.name();
        this.discountValue = discountValue;
        this.expiryDate = expiryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.description = description;
    }

    public CouponVO(Coupon coupon) {
        this(coupon.getCode(), coupon.getType(), coupon.getDiscountType(), coupon.getDiscountValue(),
                coupon.getExpiryDate(), coupon.getDescription());
    }
}
