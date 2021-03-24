package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.PersonDaoImpl;
import app.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDaoImpl personDao;
	
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}
}
