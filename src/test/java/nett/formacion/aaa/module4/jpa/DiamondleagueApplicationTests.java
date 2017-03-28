package nett.formacion.aaa.module4.jpa;

import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import nett.formacion.aaa.module4.jpa.controller.AtletaController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiamondleagueApplicationTests {

	@Autowired
	AtletaController controller;
	
	@Test
	public void contextLoads() 
	{
		this.addAtletas();
	}
	
	
	public void addAtletas()
	{
		Random r = new Random(UUID.randomUUID().getMostSignificantBits());
		
		AtletaPK pkAtleta = new AtletaPK();
		
		pkAtleta.setIdAtleta(Long.valueOf(r.nextLong()).toString());
		pkAtleta.setNombrePais("Daily Thomshomp");
		
		Atleta atleta = new Atleta();
		atleta.setId(pkAtleta);
		
		Pais p = new Pais();
		p.setNombrePais("USA");
		
		atleta.setPais(p);
		atleta.setRaza("NEGRA");
		
		atleta.setSexo("HOMBRE");
		
		controller.addAtleta(atleta);	
	}
}
