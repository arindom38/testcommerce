package org.test.wsd.testcommerce.service;

import org.test.wsd.testcommerce.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllByIdIn(List<Long> itemIds);

    Item findById(long id);

    Item save(Item item);
}
