package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
