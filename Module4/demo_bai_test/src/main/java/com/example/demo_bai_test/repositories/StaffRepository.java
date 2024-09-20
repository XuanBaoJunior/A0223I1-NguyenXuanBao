package com.example.demo_bai_test.repositories;

import com.example.demo_bai_test.models.Staffs;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staffs, String> {
}
