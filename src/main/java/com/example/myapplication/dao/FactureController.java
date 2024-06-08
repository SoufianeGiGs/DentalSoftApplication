package com.example.myapplication.dao;

import org.springframework.ui.Model;

import com.example.myapplication.entities.Consultation;
import com.example.myapplication.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicalRecord/{idDM}/facture")
public class FactureController {

    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping("/{consultationId}")
    public String generateFacture(@PathVariable("idDM") Long idDM,
                                  @PathVariable("consultationId") Long consultationId,
                                  Model model) {
        // Retrieve consultation information
        Consultation consultation = consultationRepository.findById(consultationId).orElseThrow();

        // Pass consultation information to the facture template
        model.addAttribute("consultation", consultation);

        return "medicalRecord/facture";
    }
}
