package model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

	private int id;
	private String photo;
	private String name;
	private LocalDate birthDate;
	private Gender gender;
	private Ocupation ocupation;

	public Person(int id, String photo, String name, String birthDate, String gender, String ocupation) throws ParseException {
		this.id = id;
		this.photo = photo;
		this.name = name;
		setBirthDate(birthDate);
		if (gender.equals(Gender.Masculino.toString())) {
			this.gender = Gender.Masculino;
		} else {
			this.gender = Gender.Femenino;
		}
		if (ocupation.equals(Ocupation.Estudia.toString())) {
			this.ocupation = Ocupation.Estudia;
		} else {
			this.ocupation = Ocupation.Trabaja;
		}
	}

	private void setBirthDate(String date) throws ParseException {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		birthDate = LocalDate.parse(date, fmt);
	}

	public int getId() {
		return id;
	}
	
	public String getPhoto() {
		return photo;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return birthDate.format(dtf);
	}

	public int calculateAge() {
		LocalDate today = LocalDate.now();
		Period period = Period.between(birthDate, today);
		return period.getYears();
	}

	public Gender getGender() {
		return gender;
	}

	public Ocupation getOcupation() {
		return ocupation;
	}
}