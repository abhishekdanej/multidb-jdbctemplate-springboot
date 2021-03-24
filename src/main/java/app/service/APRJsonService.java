package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.APRJsonDaoImpl;
import app.model.APRJson;

@Service
public class APRJsonService {

	@Autowired
	private APRJsonDaoImpl aprJsonDao;
	
	public List<APRJson> getAllJson() {
		return aprJsonDao.getAllJson();
	}
}
