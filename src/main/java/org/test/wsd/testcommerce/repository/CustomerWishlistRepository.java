package org.test.wsd.testcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.wsd.testcommerce.entity.CustomerWishlist;

import java.util.List;

@Repository
public interface CustomerWishlistRepository extends JpaRepository<CustomerWishlist, Long> {
    List<CustomerWishlist> findAllByCustomerId(Long customerId);

    CustomerWishlist findByCustomerIdAndItemId(Long customerId, Long itemId);
}
