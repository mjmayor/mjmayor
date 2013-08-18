package org.mjmayor.jpa.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;

@Transactional(readOnly = true)
public class DAOImpl<FORM, DTO> implements DAO<FORM, DTO> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Clase sobre la que se realizara la persistencia (clase del objeto sobre el que interactuar)
	 */
	private Class<DTO> persistentClass;

	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		if (getClass().getSuperclass().equals((DAOImpl.class))) {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		} else {
			persistentClass = (Class<DTO>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(DTO dto) throws ConstraintViolationException, JPAPersistenceException {
		logger.debug("DAOImpl - add");
		try {
			entityManager.persist(dto);
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeById(int id) throws JPAPersistenceException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - removeById");
		DTO dto = getById(id);
		if (dto != null) {
			try {
				entityManager.remove(dto);
			} catch (Exception e) {
				throw new JPAPersistenceException(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(DTO dto) throws JPAPersistenceException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - update");
		try {
			entityManager.merge(dto);
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - removeByField");
		List<DTO> listDto = getByField(field, value);
		if (listDto != null && listDto.size() > 0) {
			for (DTO dto : listDto) {
				try {
					entityManager.remove(dto);
				} catch (Exception e) {
					throw new JPAPersistenceException(e);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - removeLikeField");
		List<DTO> listDto = getLikeField(field, value);
		if (listDto != null && listDto.size() > 0) {
			for (DTO dto : listDto) {
				entityManager.remove(dto);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DTO> getAll() {
		logger.debug("DAOImpl - getAll");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<DTO> countCriteria = builder.createQuery(persistentClass);
		countCriteria.from(persistentClass);
		return entityManager.createQuery(countCriteria).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long countAll() {
		logger.debug("DAOImpl - countAll");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		countCriteria.from(persistentClass);
		Root<?> entityRoot = countCriteria.getRoots().iterator().next();
		countCriteria.select(builder.count(entityRoot));
		return entityManager.createQuery(countCriteria).getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DTO getById(int id) {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getById");
		return entityManager.find(persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DTO> getByField(String field, Object value) throws FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getByField");
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
	@Override
	public List<DTO> getLikeField(String field, String value) throws FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getLikeField");
		// Criteria criteria = session.createCriteria(persistentClass);
		// criteria.add(Restrictions.like(field, value, MatchMode.ANYWHERE));
		// List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		// session.close();
		// return listDTO;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DTO> getLikeAllFields(FORM form) throws FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getLikeAllFields");
		// Criteria criteria = session.createCriteria(persistentClass);
		// addRestrictions(criteria, form);
		// List<DTO> listDTO = ListUtils.castList(persistentClass, criteria.list());
		// session.close();
		// return listDTO;
		return null;
	}

	/**
	 * 
	 * @param criteria
	 * @param form
	 */
	private void addRestrictions(Criteria criteria, FORM form) throws FieldNotFoundException {

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
				throw new FieldNotFoundException(e);
			} catch (IllegalAccessException e) {
				throw new FieldNotFoundException(e);
			}
		}
	}
}
