package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class CategoryTest {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@ParameterizedTest
	@CsvSource(value = "Food")
	void test1(String name) {
		var cat = categoryRepo.create(new Category(name));
		System.out.println("Category ID %d".formatted(cat.getId()));
	}
}
