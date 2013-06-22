package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.prueba.universidad.model.Asignatura;
import org.prueba.universidad.model.dao.interfaces.AsignaturaDAO;
import org.prueba.universidad.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsignaturaDAOImpl implements AsignaturaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAsignatura(Asignatura asignatura) {
	sessionFactory.getCurrentSession().save(asignatura);
    }

    @Override
    public List<Asignatura> getAsignaturas() {
	return ListUtils.castList(Asignatura.class, sessionFactory.getCurrentSession().createQuery("from Asignatura").list());
    }

    @Override
    public Asignatura getAsignatura(int id) {
	return (Asignatura) sessionFactory.getCurrentSession().get(Asignatura.class, id);
    }

    @Override
    public void removeAsignatura(int id) {
	Asignatura asignatura = (Asignatura) sessionFactory.getCurrentSession().load(Asignatura.class, id);
	if (asignatura != null) {
	    sessionFactory.getCurrentSession().delete(asignatura);
	}
    }
}
