package org.dev.coupons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.dev.coupons.annotations.ValidEnum;
import org.dev.coupons.enums.CouponType;
import org.dev.coupons.enums.DiscountType;

import java.math.BigDecimal;

@Data
public class UpdateCouponDTO {

    @NotBlank
    private String code;
    @ValidEnum(enumClass = CouponType.class, message = "Invalid couponType")
    private String type;
    @ValidEnum(enumClass = DiscountType.class, message = "Invalid DiscountType")
    private String discountType;
    private BigDecimal discountValue;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "Expiry date must be in format of YYYY-MM-DD")
    private String expiryDate;
    private String description;
}
