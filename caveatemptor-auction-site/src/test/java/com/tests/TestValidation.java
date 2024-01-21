//package com.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Date;
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//import org.junit.Test;
//
//import com.raza.entity.Item;
//
//public class TestValidation {
//	@Test
//	public void testValidation() {
//		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
//		Validator validator = validationFactory.getValidator();
//		Item item = new Item();
//		item.setName("Test1");
//		item.setAuctionEnd(new Date());
//
//		Set<ConstraintViolation<Item>> constraintViolations = validator.validate(item);
//		assertEquals(1, constraintViolations.size());
//
//	}
//}
