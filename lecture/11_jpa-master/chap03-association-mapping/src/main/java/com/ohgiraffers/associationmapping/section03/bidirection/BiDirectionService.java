package com.ohgiraffers.associationmapping.section03.bidirection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiDirectionService {

    private BiDirectionRepository bidirectionRepository;

    public BiDirectionService(BiDirectionRepository biDirectionRepository) {
        this.bidirectionRepository = biDirectionRepository;
    }

    public Menu findMenu(int menuCode){
        return bidirectionRepository.findMenu(menuCode);
    }

    @Transactional
    public Category findCategory(int categoryCode){
        Category category = bidirectionRepository.findCategory(categoryCode);
        System.out.println(category.getMenuList());
        System.out.println(category.getMenuList().get(0).getCategory());
        return category;
    }

}
