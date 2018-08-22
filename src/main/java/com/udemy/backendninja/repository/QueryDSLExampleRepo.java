package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public Course find(boolean exists) {
		JPAQuery<Course> query = new JPAQuery<Course>(em);

		// Example 1
		// Get course with id 23.
		// Course course1 =
		// query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		// Example 2
		// Get all courses with 2-50 hours.
		// List<Course> courses =
		// query.select(qCourse).from(qCourse).where(qCourse.hours.between(2,
		// 50)).fetch();

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

		// Predicate predicate1 = qCourse.description.endsWith("OP");

		if (exists) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.and(predicate3);
		}
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
}
