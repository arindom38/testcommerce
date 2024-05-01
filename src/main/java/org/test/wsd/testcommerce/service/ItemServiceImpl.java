package org.test.wsd.testcommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.wsd.testcommerce.entity.Item;
import org.test.wsd.testcommerce.repository.ItemRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public List<Item> findAllByIdIn(List<Long> itemIds) {
        return itemRepository.findAllByIdIn(itemIds);
    }

    @Override
    public Item findById(long id) {
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
