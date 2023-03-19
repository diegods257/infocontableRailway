package com.infocontable.infocontable.service;

import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.model.ReporteContableId;
import com.infocontable.infocontable.model.SecurityUser;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.ReporteContableRepository;
import com.infocontable.infocontable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteContableService {

    @Autowired
    private ReporteContableRepository reporteContableRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReporteContableId reporteContableId;

    public List<ReporteContable> getReporteContableList() {return reporteContableRepository.findAll();
    }

    public ReporteContable getReporteContable(String tipo_soporte, String num_soporte, String id_tercero) {
        reporteContableId.setTipo_soporte(tipo_soporte);
        reporteContableId.setNum_soporte(num_soporte);
        reporteContableId.setId_tercero(id_tercero);
        return reporteContableRepository.buscarReporteContableId(reporteContableId);
    }

    public void addReporteContable(ReporteContable reporteContable) {
        Optional<ReporteContable> rcOptional = reporteContableRepository.findById(reporteContable.getReporteContableId());
        if(rcOptional.isPresent()){
            throw new IllegalStateException("El reporte que desea ingresar ya existe");
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            Optional<User> user = userRepository.buscarPorNit(username);
            reporteContable.setUser(user.get());
        } else {
            String username = principal.toString();
        }

        reporteContableRepository.save(reporteContable);
    }

    public void deleteReporteContable(String tipo_soporte, String num_soporte, String id_tercero) {
        reporteContableId.setTipo_soporte(tipo_soporte);
        reporteContableId.setNum_soporte(num_soporte);
        reporteContableId.setId_tercero(id_tercero);
        boolean exists = reporteContableRepository.existsById(reporteContableId);
        if(!exists){
            throw new IllegalStateException("El reporte " + reporteContableId +" no existe");
        }
        reporteContableRepository.deleteById(reporteContableId);
    }
    @Transactional
    public void updateReporteContable(String tipo_soporte, String num_soporte, String id_tercero, ReporteContable reporteContable) {
        reporteContableId.setTipo_soporte(tipo_soporte);
        reporteContableId.setNum_soporte(num_soporte);
        reporteContableId.setId_tercero(id_tercero);
        reporteContableRepository.deleteById(reporteContableId);
        addReporteContable(reporteContable);


    }
}
