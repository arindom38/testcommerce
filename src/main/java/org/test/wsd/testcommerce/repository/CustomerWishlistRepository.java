package org.test.wsd.testcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.wsd.testcommerce.entity.CustomerWishlist;

@Repository
public interface CustomerWishlistRepository extends JpaRepository<CustomerWishlist, Long> {
}
