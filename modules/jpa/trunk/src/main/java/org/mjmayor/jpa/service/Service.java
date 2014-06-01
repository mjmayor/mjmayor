package org.mjmayor.jpa.service;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;

public interface Service<ENTITY extends Serializable, DTO> {

	CriteriaBuilder getCriteriaBuilder();

	/**
	 * Persist operation
	 * 
	 * @param dto
	 *            DTO with data to persist
	 * @throws ConstraintViolationException
	 *             Thrown for a constraint error
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 */
	void add(DTO dto) throws ConstraintViolationException, JPAPersistenceException;

	/**
	 * Update operation
	 * 
	 * @param dto
	 *            DTO with data to update
	 * @throws ConstraintViolationException
	 *             Thrown for a constraint error
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 */
	void update(DTO dto) throws JPAPersistenceException;

	/**
	 * Delete an object by id
	 * 
	 * @param id
	 *            Id from object to delete
	 */
	void delete(Long id);

	/**
	 * Delete all objects which their field value is equal than the given one
	 * 
	 * @param field
	 *            Field to compare for deletion
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 * @throws FieldNotFoundException
	 *             Thrown if the given field cannot be found
	 */
	void delete(Field field) throws JPAPersistenceException, FieldNotFoundException;

	/**
	 * Delete all objects which their field value is like the given one
	 * 
	 * @param field
	 *            Field to compare for deletion
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 * @throws FieldNotFoundException
	 *             Thrown if the given field cannot be found
	 */
	void deleteLike(Field field) throws JPAPersistenceException, FieldNotFoundException;

	/**
	 * Get an object by id
	 * 
	 * @param id
	 *            Id of the object to recover
	 * @return Object with the given id
	 */
	DTO get(Long id);

	/**
	 * Get a object list by a Criteria Query
	 * 
	 * @param criteriaQuery
	 *            Query to recover the elements
	 * @param criteria
	 *            Criteria to filter the result list
	 * @return Object list by the given query
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 */
	PageResult<DTO> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException;

	/**
	 * Count the number of objects returned by a given Criteria Query
	 * 
	 * @param criteriaQuery
	 *            Query which wants to be counted
	 * @param criteria
	 *            Criteria to filter the result list to count (null to not filter)
	 * @return Number of elements returned by the given query
	 */
	Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria);

	/**
	 * Get a object list by a HQL Query
	 * 
	 * @param hqlQuery
	 *            Query to recover the elements
	 * @param criteria
	 *            Criteria to filter the result list
	 * @return Object list by the given query
	 * @throws JPAPersistenceException
	 *             Thrown for a reading / writing error
	 */
	PageResult<DTO> get(String hqlQuery, Criteria criteria) throws JPAPersistenceException;

	/**
	 * Count the number of objects returned by a given HQL Query
	 * 
	 * @param hqlQuery
	 *            Query which wants to be counted
	 * @param criteria
	 *            Criteria to filter the result list to count (null to not filter)
	 * @return Number of elements returned by the given query
	 */
	Long count(String hqlQuery, Criteria criteria);

	
	
	/**
	 * Get all objects which their field value is equal than the given one
	 * 
	 * @param field Field to compare for recovering
	 * @param criteria Criteria to filter the result list to count (null to not filter)
	 * @return Object list which field value is equal than the given one
	 * @throws FieldNotFoundException
	 *             Thrown if the given field cannot be found
	 */
	PageResult<DTO> get(Field field, Criteria criteria) throws FieldNotFoundException;

	/**
	 * Get all objects which their field value is like the given one
	 * 
	 * @param field Field to compare for recovering
	 * @param criteria Criteria to filter the result list to count (null to not filter)
	 * @return Object list which field value is like the given one
	 * @throws FieldNotFoundException
	 *             Thrown if the given field cannot be found
	 */
	PageResult<DTO> getLike(Field field, Criteria criteria) throws FieldNotFoundException;
}
