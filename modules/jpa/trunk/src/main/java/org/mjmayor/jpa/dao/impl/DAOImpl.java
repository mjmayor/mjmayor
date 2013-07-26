package org.mjmayor.jpa.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.utils.list.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.StringUtils;

public class DAOImpl<FORM, DTO> implements DAO<FORM, DTO> {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private Class<DTO> persistentClass;

	private SessionFactory sessionFactory;

	private Session session;

	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		// this.session = sessionFactory.openSession();

		if (getClass().getSuperclass().equals((DAOImpl.class))) {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		} else {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void add(DTO dto) throws JPAPersistenceException {
		logger.debug("DAOImpl - add");
		entityManager.persist(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeById(int id) throws JPAPersistenceException {
		DTO dto = getById(id);
		if (dto != null) {
			session.delete(dto);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException {
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
	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException {
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
		// return ListUtils.castList(persistentClass, session.createQuery("from " + persistentClass.getSimpleName()).list());
		List<DTO> a = new ArrayList<DTO>();
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
	public List<DTO> getByField(String field, Object value) throws FieldNotFoundException {
		// String a = "from " + persistentClass.getSimpleName() + " where %s = :value";
		// String queryString = String.format(a, field);
		// Query query = session.createQuery(queryString);
		// query.setParameter("value", value);
		// return ListUtils.castList(persistentClass, query.list());
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getLikeField(String field, String value) throws FieldNotFoundException {
		Criteria criteria = session.createCriteria(persistentClass);
		criteria.add(Restrictions.like(field, value, MatchMode.ANYWHERE));
		List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		session.close();
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DTO> getLikeAllFields(FORM form) throws FieldNotFoundException {
		Criteria criteria = session.createCriteria(persistentClass);
		addRestrictions(criteria, form);
		List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		session.close();
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public long getTotal() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		countCriteria.from(persistentClass);
		Root<?> entityRoot = countCriteria.getRoots().iterator().next();
		countCriteria.select(builder.count(entityRoot));
		return entityManager.createQuery(countCriteria).getSingleResult();
	}

	private void addRestrictions(Criteria criteria, FORM form) {

		Field[] fields = form.getClass().getDeclaredFields();
		for (Field field : fields) {
			Class<?> type = field.getType();
			try {
				if ("java.lang.String".equals(type)) {
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
