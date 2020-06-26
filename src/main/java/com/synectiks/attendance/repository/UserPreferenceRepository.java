package com.synectiks.attendance.repository;

import com.synectiks.attendance.domain.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the UserPreference entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {

}
