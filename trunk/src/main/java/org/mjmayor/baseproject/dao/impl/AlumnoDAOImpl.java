package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.utils.ListUtils;
import org.mjmayor.baseproject.view.AlumnoView;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class AlumnoDAOImpl implements AlumnoDAO {

	private LocalSessionFactoryBean sessionFactory;
	
	private AlumnoDAOImpl(LocalSessionFactoryBean sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addAlumno(AlumnoForm alumno) {
		sessionFactory.getCurrentSession().save(alumno);
	}

	@Override
	public List<AlumnoView> getAlumnos() {
		return ListUtils.castList(
				AlumnoDTO.class,
				sessionFactory.getCurrentSession().createQuery("from Alumno").list()
		);
	}

	@Override
	public AlumnoView getAlumno(AlumnoForm alumnoForm) {
		return (AlumnoView)sessionFactory.getCurrentSession().get(AlumnoDTO.class,alumnoForm.getDni());
	}

	@Override
	public void removeAlumno(AlumnoForm alumnoForm) {
		AlumnoDTO alumno=(AlumnoDTO)sessionFactory.getCurrentSession().load(AlumnoDTO.class,alumnoForm.getDni());
		if (alumno!=null){
			sessionFactory.getCurrentSession().delete(alumno);
		}
	}
}
