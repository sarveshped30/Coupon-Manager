package org.dev.coupons.repository;

import org.dev.coupons.domain.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, String> {

    @Query("select c from Coupon c where c.isUsed = false")
    List<Coupon> findAllActiveCoupons();

    Optional<Coupon> findByCode(String code);
}
