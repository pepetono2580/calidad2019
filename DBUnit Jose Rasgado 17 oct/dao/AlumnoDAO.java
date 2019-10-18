package com.mayab.calidad.mockito.dao;

public interface AlumnoDAO {
	public void addAlumno(Alumno alumno);
	public void removeAlumno(Alumno alumno);
	public void updatePromedio(Alumno alumno);
	public void getAll();
}
