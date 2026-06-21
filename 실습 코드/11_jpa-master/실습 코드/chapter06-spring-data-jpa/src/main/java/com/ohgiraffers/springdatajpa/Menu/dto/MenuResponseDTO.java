package com.ohgiraffers.springdatajpa.Menu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Service
@ToString
@NoArgsConstructor
public class MenuResponseDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private String orderableStatus;
    private CategoryDTO category;

}
