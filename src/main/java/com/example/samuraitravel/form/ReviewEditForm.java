package com.example.samuraitravel.form;

public class ReviewEditForm {
	private Integer id;	
	private String name;
	private String description;
	private int rating;
	private Integer houseId; // HouseのIDを追加

	public Integer getId() { // Long型に変更
		return id;
	}

	public void setId(Integer id) {  // Long型に一致
		this.id = id;
	}

	// フィールド名とメソッド名を統一
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
}
