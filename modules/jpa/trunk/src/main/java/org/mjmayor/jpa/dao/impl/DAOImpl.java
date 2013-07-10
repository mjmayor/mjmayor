package org.mjmayor.jpa.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mjmayor.jpa.assembler.Assembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.utils.list.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.StringUtils;

public class DAOImpl<FORM, DTO> implements DAO<FORM, DTO> {

	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private Class<DTO> persistentClass;

	private SessionFactory sessionFactory;

	private Assembler<FORM, DTO> assembler;

	private Session session;

	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager entityManager, Assembler<FORM, DTO> assembler) {
		this.entityManager = entityManager;
		// this.session = sessionFactory.openSession();
		this.assembler = assembler;

		if (getClass().getSuperclass().equals((DAOImpl.class))) {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} else {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void add(FORM form) {
		logger.debug("DAOImpl - add");
		DTO dto = assembler.assemble(form);
		entityManager.merge(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeById(int id) {
		DTO dto = getById(id);
		if (dto != null) {
			session.delete(dto);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeByField(String field, Object value) {
		List<DTO> listDto = getByField(field, value);
		if (listDto != null && listDto.size() > 0) {
			for (DTO dto : listDto) {
				session.delete(dto);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeLikeField(String field, String value) {
		List<DTO> listDto = getLikeField(field, value);
		if (listDto != null && listDto.size() > 0) {
			for (DTO dto : listDto) {
				session.delete(dto);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getAll() {
//		return ListUtils.castList(persistentClass, session.createQuery("from " + persistentClass.getSimpleName()).list());
		List<DTO> a=new ArrayList<DTO>();
		a.add(entityManager.find(persistentClass, 1));
		return a;
	}

	/**
	 * {@inheritDoc}
	 */
	public DTO getById(int id) {
		 return entityManager.find(persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getByField(String field, Object value) {
//		String a = "from " + persistentClass.getSimpleName() + " where %s = :value";
//		String queryString = String.format(a, field);
//		Query query = session.createQuery(queryString);
//		query.setParameter("value", value);
//		return ListUtils.castList(persistentClass, query.list());
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getLikeField(String field, String value) {
		Criteria criteria = session.createCriteria(persistentClass);
		criteria.add(Restrictions.like(field, value, MatchMode.ANYWHERE));
		List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		session.close();
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getLikeAllFields(FORM form) {
		Criteria criteria = session.createCriteria(persistentClass);
		addRestrictions(criteria, form);
		List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		session.close();
		return listDTO;
	}

	private void addRestrictions(Criteria criteria, FORM form) {

		Field[] fields = form.getClass().getDeclaredFields();
		for (Field field : fields) {
			Class<?> type = field.getType();
			try {
				if (type.equals("java.lang.String")) {
					String name = field.getName();
					String value = (String) field.get(form);
					if (!StringUtils.isNullOrEmpty(value)) {
						criteria.add(Restrictions.like(name, value, MatchMode.ANYWHERE));
					}
				}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
