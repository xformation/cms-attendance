package com.synectiks.attendance.repository.search;

import com.synectiks.attendance.domain.UserPreference;
import com.synectiks.attendance.utils.JPASearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link UserPreference} entity.
 */
public interface UserPreferenceSearchRepository extends JPASearchRepository<UserPreference, Long> {
}
