package com.example.SepatuRecommendations.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString

public class RecommendDto {
    String category;
    List<ProductL1Dto> recommedations;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecommedations(List<ProductL1Dto> recommedations) {
        this.recommedations = recommedations;
    }
}
