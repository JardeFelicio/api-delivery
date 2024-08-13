package com.jardefelicio.api_orders.modules.company.controllers;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.modules.company.dtos.CompanyUpdateDTO;
import com.jardefelicio.api_orders.modules.company.services.CompanyFindAllService;
import com.jardefelicio.api_orders.modules.company.services.CompanyFindByIdService;
import com.jardefelicio.api_orders.modules.company.services.CompanyUpdateService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "company")
public class CompanyController {
    @Autowired
    private CompanyFindAllService companyFindAll;
    @Autowired
    private CompanyFindByIdService companyFindById;
    @Autowired
    private CompanyUpdateService companyUpdate;

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> findAll() {
        List<CompanyResponseDTO> result = this.companyFindAll.execute();
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponseDTO> findById(@PathVariable(value = "id") Long companyId) {
        CompanyResponseDTO result = this.companyFindById.execute(companyId);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('COMPANY')")
    @PutMapping
    public ResponseEntity<CompanyResponseDTO> update(
            @RequestBody @Valid CompanyUpdateDTO data,
            HttpServletRequest request){
        var companyId = request.getAttribute("id");
        Long companyIdLong = Long.parseLong(companyId.toString());
        CompanyResponseDTO result = this.companyUpdate.execute(data, companyIdLong);
        return ResponseEntity.ok(result);
    }
}
