package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.Entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	String[] typeOfGender = {
			"Male",
			"Female"
	};

	String[] nameOfManager = {
			"Pin",
			"Manny",
			"King"
	};


	String[] typeOfTypeMusic = {
			"POP",
			"ROCK",
			"HIPHOP",
			"JAZZ",
			"R&B",
			"CLASSIC",
			"Country"
	};

	String [] nameOfBand = {
			"IKON",
			"WINNER",
			"BLACKPING"
	};

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(ArtistsRepository artistsRepository, GenderRepository genderRepository,
						   ManagerRepository managerRepository, BandRepository bandRepository, TypeMusicRepository typeMusicRepository) {
		return args -> {
			Stream.of(typeOfGender).forEach(gender -> {
				Gender newGender = new Gender();
				newGender.setGender(gender);
				genderRepository.save(newGender);
			});
			genderRepository.findAll().forEach(System.out::println);

			Stream.of(nameOfManager).forEach(username -> {
				Manager manager = new Manager();
				manager.setUsername(username);
				managerRepository.save(manager);
			});
			managerRepository.findAll().forEach(System.out::println);


			Stream.of(nameOfBand).forEach(bandname -> {
				Band band = new Band();
				band.setBandname(bandname);
				bandRepository.save(band);
			});
			bandRepository.findAll().forEach(System.out::print);

			Stream.of(typeOfTypeMusic).forEach(typemusics -> {
				TypeMusic typeMusic = new TypeMusic();
				typeMusic.setTypemusics(typemusics);
				typeMusicRepository.save(typeMusic);
			});
			typeMusicRepository.findAll().forEach(System.out::print);
		};
	}
}
