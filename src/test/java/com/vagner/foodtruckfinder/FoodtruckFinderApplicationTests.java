package com.vagner.foodtruckfinder;

import com.vagner.foodtruckfinder.container.ContainersEnvironment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FoodtruckFinderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FoodtruckFinderApplicationTests extends ContainersEnvironment {

	@Test
	void contextLoads() {
	}

}
