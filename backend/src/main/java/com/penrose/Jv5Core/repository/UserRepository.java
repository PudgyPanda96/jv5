package com.penrose.Jv5Core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penrose.Jv5Core.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	// List<T> findAll()
	// List<T> findAll(Sort sort)
	// List<T> findAllById(Iterable<ID> ids)
	// <S extends T> List<S> saveAll(Iterable<S> entities)
	// void flush()
	// <S extends T> S saveAndFlush(S entity)
	// void deleteInBatch(Iterable<T> entities)
	// void deleteAllInBatch()
	// T getOne(ID id) 
	// <S extends T> List<S> findAll(Example<S> example)
	// <S extends T> List<S> findAll(Example<S> example, Sort sort)

}
