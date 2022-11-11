package com.management.cgmanagement.service.tuition;

import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.service.GenericService;
import org.springframework.data.domain.Page;

public interface ITuitionService extends GenericService<Tuition> {

    Page<Tuition> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

