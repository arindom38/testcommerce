package org.test.wsd.testcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.wsd.testcommerce.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
