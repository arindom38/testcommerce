package org.test.wsd.testcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.wsd.testcommerce.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByIdIn(List<Long> itemIds);

    Item findById(long id);
}
