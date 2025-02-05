package com.gabo.spring_boot_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.gabo.spring_boot_demo.components.ThanosComponent;
import com.gabo.spring_boot_demo.components.ThanosComponent;
import com.gabo.spring_boot_demo.models.PowerStone;
import com.gabo.spring_boot_demo.models.SpaceStone;
import com.gabo.spring_boot_demo.models.Stone;
import com.gabo.spring_boot_demo.services.GaunletService;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	//DI, properties, configs and env variables, and java methods
	// @Value(value = "#{T(java.time.LocalDateTime).now()}")
	// @Value(value = "${stones.power.create}")
	// @Value("${stones.soul.enabled}")
	// private Boolean soulEnabled;
	
	@Autowired
	private ThanosComponent thanos;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		thanos.snap();
	}
	
}
