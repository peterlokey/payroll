package com.lokey.payroll.Models.Data;

import com.lokey.payroll.Models.Shift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShiftDao extends CrudRepository<Shift, Integer> {
}