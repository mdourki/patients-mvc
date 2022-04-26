package com.dourki.patientsmvc;

import com.dourki.patientsmvc.entities.Patient;
import com.dourki.patientsmvc.repositories.PatientRepository;
import com.dourki.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Simo",new Date(),false,150));
            patientRepository.save(new Patient(null,"Mohamed",new Date(),false,110));
            patientRepository.save(new Patient(null,"Jingo",new Date(),true,120));
            patientRepository.save(new Patient(null,"Pablo",new Date(),false,130));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("Simo","1234","1234");
            securityService.saveNewUser("Mohamed","1234","1234");

            securityService.saveNewRole("USER", "Utilisateur");
            securityService.saveNewRole("ADMIN", "Administrateur");

            securityService.addRoleToUser("Simo" , "USER");
            securityService.addRoleToUser("Simo" , "ADMIN");
            securityService.addRoleToUser("Mohamed" , "USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
