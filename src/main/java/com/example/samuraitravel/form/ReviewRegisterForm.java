package com.example.samuraitravel.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRegisterForm {
    @NotBlank(message = "評価してください。")
    private String rating;
        
    private MultipartFile imageFile;
    
    @NotBlank(message = "コメントしてください")
    private String description;
    
    private Integer houseId; // HouseのIDを追加

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
