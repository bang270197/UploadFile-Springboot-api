package com.codegym.testuploadfileapi.Repository;

import com.codegym.testuploadfileapi.Model.Human;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends PagingAndSortingRepository<Human,Long> {
}
