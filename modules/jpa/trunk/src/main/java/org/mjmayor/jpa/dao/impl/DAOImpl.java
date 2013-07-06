package org.mjmayor.jpa.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.mjmayor.jpa.assembler.support.Assembler;
import org.mjmayor.jpa.dao.DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOImpl<FORM, DTO> implements DAO<FORM, DTO> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private SessionFactory sessionFactory;

	private Assembler<FORM, DTO> assembler;

	public DAOImpl(SessionFactory sessionFactory, Assembler<FORM, DTO> assembler) {
		this.sessionFactory = sessionFactory;
		this.assembler = assembler;
	}

	public void add(FORM form) {
		logger.debug("DAOImpl - add");
		DTO dto = assembler.assemble(form);
		sessionFactory.getCurrentSession().save(dto);
	}

	public void removeById(int id) {
		DTO dto = getById(id);
		if (dto != null) {
			sessionFactory.getCurrentSession().delete(dto);
		}

	}

	public void removeByField(String field, Object value) {
		List<DTO> listDto = getByField(field,value);
		if (listDto != null && listDto.size()>0) {
			for (DTO dto:listDto){
			sessionFactory.getCurrentSession().delete(dto);
			}
		}
	}

	public void removeLikeField(String field, Object value) {
		List<DTO> listDto = getLikeField(field,value);
		if (listDto != null && listDto.size()>0) {
			for (DTO dto:listDto){
			sessionFactory.getCurrentSession().delete(dto);
			}
		}
	}

	public List<DTO> getAll() {
		//return ListUtils.castList(DTO.class, sessionFactory.getCurrentSession().createQuery(Constants.Database.Queries.FIND_ALL).list());
		return null;
	}

	public DTO getById(int id) {
		return (DTO) sessionFactory.getCurrentSession().get(DTO.class, id);
	}

	public List<DTO> getByField(String field, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO> getLikeField(String field, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO> getLikeAllFields(FORM form) {
		// TODO Auto-generated method stub
		return null;
	}
}
