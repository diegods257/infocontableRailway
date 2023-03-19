package com.infocontable.infocontable.repository;

import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteContableRepository extends JpaRepository<ReporteContable, ReporteContableId> {

    @Query("Select r FROM ReporteContable r WHERE r.reporteContableId = :reporteContableId")
    public ReporteContable buscarReporteContableId(@Param("reporteContableId") ReporteContableId reporteContableId);
}
