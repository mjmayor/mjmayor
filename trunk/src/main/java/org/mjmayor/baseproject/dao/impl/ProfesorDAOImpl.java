package org.mjmayor.baseproject.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class ProfesorDAOImpl /*implements ProfesorDAO*/ {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void addProfesor(Profesor profesor) {
//	sessionFactory.getCurrentSession().save(profesor);
//    }
//
//    @Override
//    public List<Profesor> getProfesores() {
//	return ListUtils.castList(Profesor.class, sessionFactory.getCurrentSession().createQuery("from Profesor").list());
//    }
//
//    @Override
//    public Profesor getProfesor(int id) {
//	return (Profesor) sessionFactory.getCurrentSession().get(Profesor.class, id);
//    }
//
//    @Override
//    public void removeProfesor(int id) {
//	Profesor profesor = (Profesor) sessionFactory.getCurrentSession().load(Profesor.class, id);
//	if (profesor != null) {
//	    sessionFactory.getCurrentSession().delete(profesor);
//	}
//    }
}
