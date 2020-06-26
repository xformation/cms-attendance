package com.synectiks.attendance.repository.search;

import com.synectiks.attendance.domain.User;
import com.synectiks.attendance.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends JPASearchRepository<User, Long> {
}
