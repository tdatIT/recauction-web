package com.ec.recauctionec.service.impl;

import com.ec.recauctionec.entity.Category;
import com.ec.recauctionec.repositories.CategoryRepo;
import com.ec.recauctionec.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
