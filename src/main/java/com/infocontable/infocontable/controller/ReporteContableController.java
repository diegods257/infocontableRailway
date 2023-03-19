package com.infocontable.infocontable.controller;


import com.infocontable.infocontable.model.ReporteContable;
import com.infocontable.infocontable.service.ReporteContableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/reportes")
public class ReporteContableController {

    @Autowired
    private ReporteContableService reporteContableService;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("listarReportes")
    public String listarReportesContables(Model model){
        model.addAttribute("reportes", reporteContableService.getReporteContableList());
        return "menuPrincipalCliente";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("buscarReporte/{tipo}/{num}/{id}")
    public ReporteContable buscarReporteContable(@PathVariable("tipo") String tipo_soporte, @PathVariable("num") String num_soporte, @PathVariable("id") String id_tercero){
        return reporteContableService.getReporteContable(tipo_soporte,num_soporte,id_tercero);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("ingresarReporte")  //Dirige hacia el formulario para crear reporte contable.
    public String formIngresarReporte(ReporteContable reporteContable){
        return "crearReporteContable";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("crearReporte")    //Persiste la creacion del reporte contable.
    public String crearReporteContable(ReporteContable reporteContable){
        reporteContableService.addReporteContable(reporteContable);
        return "redirect:listarReportes";
    }

    // TODO: ELIMINAR REPORTE Y ACTUALIZAR.
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("eliminarReporte/{tipo}/{num}/{id}") //Elimina un reporte contable por su ID.
    public String eliminarReporteContable(@PathVariable("tipo") String tipo_soporte, @PathVariable("num") String num_soporte, @PathVariable("id") String id_tercero){
//        ReporteContableId reporteContableId = new ReporteContableId(tipo_soporte,num_soporte,id_tercero);
        reporteContableService.deleteReporteContable(tipo_soporte,num_soporte,id_tercero);
        return "redirect:/api/reportes/listarReportes";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("editarReporte/{tipo}/{num}/{id}")
    public String editarReporteContable(@PathVariable("tipo") String tipo_soporte, @PathVariable("num") String num_soporte, @PathVariable("id") String id_tercero, Model model){
//        ReporteContableId reporteContableId = new ReporteContableId(tipo_soporte,num_soporte,id_tercero);

        model.addAttribute("reporte", reporteContableService.getReporteContable(tipo_soporte,num_soporte,id_tercero));
        return "modificarReporteUsuario";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("actualizarReporte/{tipo}/{num}/{id}")
    public String actualizarReporteContable(@PathVariable("tipo") String tipo_soporte, @PathVariable("num") String num_soporte, @PathVariable("id") String id_tercero, ReporteContable reporteContable){
//        ReporteContableId reporteContableId = new ReporteContableId(tipo_soporte,num_soporte,id_tercero);

        reporteContableService.updateReporteContable(tipo_soporte,num_soporte,id_tercero, reporteContable);
        return "redirect:/api/reportes/listarReportes";
    }
}
