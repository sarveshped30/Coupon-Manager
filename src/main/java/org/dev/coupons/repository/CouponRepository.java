package org.dev.coupons.repository;

import org.dev.coupons.domain.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, String> {

}
