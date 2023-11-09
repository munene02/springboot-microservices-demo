package com.matrinmunene.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Martin Munene
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
