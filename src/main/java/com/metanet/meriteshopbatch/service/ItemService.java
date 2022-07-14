package com.metanet.meriteshopbatch.service;

import com.metanet.meriteshopbatch.entity.Item;
import com.metanet.meriteshopbatch.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findTop5OrderByRateDesc() {
        return itemRepository.findTop5ByOrderByRateDesc();
    }
}
