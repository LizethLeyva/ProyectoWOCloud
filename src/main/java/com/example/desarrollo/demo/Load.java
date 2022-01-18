package com.example.desarrollo.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

import com.example.desarrollo.demo.hospital.Area;
import com.example.desarrollo.demo.hospital.Consulta;
import com.example.desarrollo.demo.hospital.Medico;
import com.example.desarrollo.demo.hospital.MedicoUser;
import com.example.desarrollo.demo.hospital.Paciente;
import com.example.desarrollo.demo.hospital.Role;
import com.example.desarrollo.demo.repository.MedicoUserRepository;
import com.example.desarrollo.demo.repository.RoleRepository;
import com.example.desarrollo.demo.service.Implements.AreaServiceImpl;
import com.example.desarrollo.demo.service.Implements.ConsultaServiceImpl;
import com.example.desarrollo.demo.service.Implements.MedicoServiceImpl;
import com.example.desarrollo.demo.service.Implements.PacienteServiceImpl;

@Configuration
class Load {

	@Bean
	CommandLineRunner Pacient(PacienteServiceImpl pacienteServiceImpl) {
		return args -> {

			Paciente e1 = new Paciente();
			e1.setCedula((long) 1012463969);
			e1.setNombre("Lizeth");
			e1.setApellido("Leyva");
			e1.setDiagnostico("Hipertension");
			e1.setEdad(22);
			e1.setTriage(2);
			e1.setSexo(false);
			pacienteServiceImpl.save(e1);

			Paciente e2 = new Paciente();
			e2.setCedula((long) 80276837);
			e2.setNombre("Fernando");
			e2.setApellido("Lozano");
			e2.setDiagnostico("Fractura");
			e2.setEdad(15);
			e2.setTriage(1);
			e2.setSexo(true);
			pacienteServiceImpl.save(e2);

			Paciente e3 = new Paciente();
			e3.setCedula((long) 80276837);
			e3.setNombre("Sebastian");
			e3.setApellido("Saavedra");
			e3.setDiagnostico("Amputacion");
			e3.setEdad(45);
			e3.setTriage(1);
			e3.setSexo(false);
			pacienteServiceImpl.save(e3);

		};
	}

	@Bean
	CommandLineRunner Medic(MedicoServiceImpl medicoServiceImpl) {
		return arg -> {

			Medico med1 = new Medico();
			med1.setCedula((long) 39736600);
			med1.setNombre("Geovanny");
			med1.setApellido("Monsalve");
			med1.setEspecialidad("cardiólogo");
			medicoServiceImpl.save(med1);

			Medico med2 = new Medico();
			med2.setCedula((long) 1016096181);
			med2.setNombre("Alejandra");
			med2.setApellido("Perdomo");
			med2.setEspecialidad("Oncologia");
			medicoServiceImpl.save(med2);

			Medico med3 = new Medico();
			med3.setCedula((long) 80276837);
			med3.setNombre("Hernando");
			med3.setApellido("Leyva");
			med3.setEspecialidad("Ginecologia");
			medicoServiceImpl.save(med3);

		};

	}

	@Bean
	CommandLineRunner Consult(ConsultaServiceImpl consultaServiceImpl) {
		return arg -> {

			Consulta cons1 = new Consulta();
			cons1.setTipocons("prioritaria");
			cons1.setNumcons(201);
			cons1.setEstado(false);
			cons1.setFechacons(new Date());
			consultaServiceImpl.save(cons1);

			Consulta cons2 = new Consulta();
			cons2.setTipocons("urgencias");
			cons2.setNumcons(310);
			cons2.setEstado(true);
			cons2.setFechacons(new Date());
			consultaServiceImpl.save(cons2);

			Consulta cons3 = new Consulta();
			cons3.setTipocons("programada");
			cons3.setNumcons(105);
			cons3.setEstado(false);
			cons3.setFechacons(new Date());
			consultaServiceImpl.save(cons3);

		};

	}

	@Bean
	CommandLineRunner Usuar(MedicoUserRepository medicoUserRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		return args -> {

			Role adminRole = new Role();
			adminRole.setName("ADMIN");
			roleRepository.save(adminRole);

			Role viewerRole = new Role();
			viewerRole.setName("VIEWER");
			roleRepository.save(viewerRole);

			Role customerRole = new Role();
			customerRole.setName("CUSTOMER");
			roleRepository.save(customerRole);

			MedicoUser admin = new MedicoUser();
			admin.setUsuario("admin");
			admin.setPassword(bCryptPasswordEncoder.encode("12345"));
			admin.setRol(adminRole);
			medicoUserRepository.save(admin);

			MedicoUser visitor = new MedicoUser();
			visitor.setUsuario("visitor");
			visitor.setPassword(bCryptPasswordEncoder.encode("12345"));
			visitor.setRol(viewerRole);
			medicoUserRepository.save(visitor);

			MedicoUser customer = new MedicoUser();
			customer.setUsuario("customer");
			customer.setPassword(bCryptPasswordEncoder.encode("12345"));
			customer.setRol(customerRole);
			medicoUserRepository.save(customer);

		};
	}

	@Bean
	CommandLineRunner Are(AreaServiceImpl areaServiceImpl) {
		return arg -> {

			Area area1 = new Area();
			area1.setNombreesp("CARDIOLOGÍA");
			area1.setTipoesp("ÁREAS MÉDICAS");
			areaServiceImpl.save(area1);

			Area area2 = new Area();
			area2.setNombreesp("GINECOLOGÍA Y OBSTETRICIA");
			area2.setTipoesp("ÁREAS QUIRÚRGICAS");
			areaServiceImpl.save(area2);

			Area area3 = new Area();
			area3.setNombreesp("LABORATORIOS CLÍNICOS");
			area3.setTipoesp("ÁREAS DE DIAGNÓSTICO Y APOYO CLÍNICO");
			areaServiceImpl.save(area3);

		};

	}

}
