package ma.enset.tp1springboot;

import ma.enset.tp1springboot.entities.Patient;
import ma.enset.tp1springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp1SpringBootApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1SpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    //patientRepository.save(new Patient(null,"Pat1",new Date(),true,1));
    //patientRepository.save(new Patient(null,"Pat2",new Date(),false,3));
    //patientRepository.save(new Patient(null,"Pat3",new Date(),true,4));

    List<Patient> patients = patientRepository.findAll();
    patients.forEach(p ->{
        System.out.println(p.toString());
    } );

    Patient patient=patientRepository.findById(Long.valueOf(1)).get();

    System.out.println("==========================");
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissance());
        System.out.println(patient.getScore());

    System.out.println("==========================");
    patientRepository.deleteById(Long.valueOf(20));

        List<Patient> patients2 = patientRepository.findAll();
        patients2.forEach(p ->{
            System.out.println(p.toString());
        } );

    System.out.println("==========================");
    patientRepository.updatePatient(Long.valueOf(5),"Pat50", 15, new Date(),true);
        List<Patient> patients3 = patientRepository.findAll();
        patients3.forEach(p ->{
            System.out.println(p.toString());
        } );

    }
}
