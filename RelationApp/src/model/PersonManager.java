package model;

import java.util.ArrayList;
import java.util.StringTokenizer;

import control.ConstantList;

public class PersonManager {

	private ArrayList<Person> personGroup;

	public PersonManager() {
		personGroup = new ArrayList<Person>();
	}

	public void addPerson(Person person) {
		personGroup.add(person);
	}
	
	public double afinity(Person firstPerson, Person secondPerson) {
		double afinity = ageAfinity(firstPerson.calculateAge(), secondPerson.calculateAge());
		return afinity + ocupationAfinity(firstPerson.getOcupation(), secondPerson.getOcupation()) ;
	}
	
	public double ageAfinity(int ageOne, int ageTwo) {
		int difference = ageOne - ageTwo;
		int afinityAge = 0;
		if (difference < 0) {
			difference *= -1;
		}
		if (difference <= ConstantList.AGE_FIRST_LIM) {
			afinityAge = 100;
		} else if (difference <= ConstantList.AGE_SECOND_LIM) {
			afinityAge = 50;
		}
		return afinityAge *= ConstantList.PERCENT;
	}
	
	public double ocupationAfinity(Ocupation ocupationOne, Ocupation ocupationTwo) {
		if (ocupationOne.equals(ocupationTwo)) {
			return 100*ConstantList.PERCENT;
		}
		return 0;
	}
	
	public Person searchPerson(String user) {
		StringTokenizer st = new StringTokenizer(user, "-");
		int id = Integer.parseInt(st.nextToken());
		for (Person person : personGroup) {
			if (id == person.getId()) {
				return person;
			}
		}
		return null;
	}
	
	public ArrayList<Person> getPersonGroup() {
		return personGroup;
	}
}