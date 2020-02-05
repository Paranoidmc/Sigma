package com.contrader.srr.controllers;

import com.contrader.srr.domain.Processo;
import com.contrader.srr.domain.Processo.ProcessStatus;
import com.contrader.srr.domain.Processo.ProcessType;
import com.contrader.srr.services.ProcessoService;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessoController {
	private List<Processo> db;
    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public String getAll() {
        return processoService.transform(Processo());
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id) {
    	
        return processoService.getById(id, Processo());
    }
    private List<Processo> Processo() {
    	
        db = Lists.newArrayList(
                new Processo(Integer.valueOf(1),"primo",1,"primo",ProcessStatus.DORMANT,ProcessType.ONE_SHOT,1),
                new Processo(Integer.valueOf(2),"primo",1,"primo",ProcessStatus.DORMANT,ProcessType.ONE_SHOT,1),
                new Processo(Integer.valueOf(3),"primo",1,"primo",ProcessStatus.DORMANT,ProcessType.ONE_SHOT,1 )

        );
        return db;
    }


  
}
