package com.lokey.payroll.models.Data;

import com.lokey.payroll.models.Shift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShiftDao extends CrudRepository<Shift, Integer> {
}