package kr.readvice.api.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ItemCRUD {
    //Controller(Main Method)
    public static void main(String[] args) {
    }

    //DTO
    @Data @AllArgsConstructor static class Item{
        private int id;
        private String name;
        private int price;
    }

    //Service interface
    interface ItemService{}

    //ServiceImpl
    @RequiredArgsConstructor class ItemServiceImpl implements ItemService{}
}

