package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student Thestudent) {
        entityManager.persist(Thestudent);

    }

    @Override
//    @Transactional
    public Student findbyID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateMultipleRows(List<Student> Students) {
        int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName = 'misra'").executeUpdate();
        //can be used to delete multiple rows as well
        System.out.println(numRowsUpdated);
        return numRowsUpdated;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(rowsDeleted);
        return rowsDeleted;
    }

    @Override
    public List<Student> findByFirstName(String theFirstName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("" +
                "FROM Student where firstName=:theData", Student.class);

        theQuery.setParameter("theData", theFirstName);
        return theQuery.getResultList();
    }
}
