package nett.formacion.aaa.module4.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;

import nett.formacion.aaa.module4.jpa.Atleta;
import nett.formacion.aaa.module4.jpa.repo.AtletaRepository;

public class AtletaController 
{

	@Autowired
	private AtletaRepository repo;
	
	public AtletaController()
	{
		super();
	}
	
	public void addAtleta(Atleta atleta)
	{
		this.repo.saveAndFlush(atleta);
	}
	
	public void deleteAtleta(Atleta atleta)
	{
		if (atleta != null && atleta.getId() != null)
		{
			this.deleteAtleta(Long.valueOf((atleta.getId().getIdAtleta())));
		}
	}
	
	public void deleteAtleta(Long atletaId)
	{
		this.repo.delete(atletaId);
	}
}
