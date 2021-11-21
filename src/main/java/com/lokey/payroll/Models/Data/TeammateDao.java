package com.lokey.payroll.Models.Data;

import com.lokey.payroll.Models.Teammate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeammateDao extends CrudRepository<Teammate, Integer> {
}