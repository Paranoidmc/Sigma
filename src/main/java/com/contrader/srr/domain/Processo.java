package com.contrader.srr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Processo {
	public enum ProcessStatus
	{
		DORMANT,
		WAITING,
		READY,
		RUNNING,
		SUSPENDED
	}
	public enum ProcessType
	{
		ONE_SHOT,
		PERIODIC,
	}
    private Integer id;
    private String name;
    private Integer priority;
    private String path;
    private ProcessStatus status;
    private ProcessType type;
    private Integer period;
	
   

}