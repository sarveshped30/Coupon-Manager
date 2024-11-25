package org.dev.coupons.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CouponDTO {

    private String code;
    private String type;
    private String discountType;
    private BigDecimal discountValue;
    private String expiryDate;
    private String description;
}
