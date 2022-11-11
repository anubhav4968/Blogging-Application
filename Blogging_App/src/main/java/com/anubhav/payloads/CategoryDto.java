package com.anubhav.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	
	@NotEmpty
	@Size(min=4,message="title must be 4 cahr")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=10,message="Discription must be 10 char")
	private String categoryDiscription;
}
