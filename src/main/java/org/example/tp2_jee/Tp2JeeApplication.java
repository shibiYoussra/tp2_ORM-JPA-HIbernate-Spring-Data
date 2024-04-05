package org.example.tp2_jee;

import org.example.tp2_jee.entities.Medecin;
import org.example.tp2_jee.entities.Patient;
import org.example.tp2_jee.entities.Product;
import org.example.tp2_jee.repository.MedecinRepository;
import org.example.tp2_jee.repository.PatientRepository;
import org.example.tp2_jee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2JeeApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2JeeApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Computer",5000,4));
        productRepository.save(new Product(null, "Smart Phone",8000,26));
        productRepository.save(new Product(null, "Pinter",2000,12));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(2)).get();
        System.out.println("***************************************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("***************************************");

        System.out.println("********* Methode Search (FindByNameConatins) *********");
        List<Product> productList=productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("********* Methode Search (Query) *********");
        List<Product> productListSearch=productRepository.search("%C%");
        productListSearch.forEach(p->{
            System.out.println(p);
        });
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Youssra","Aya","Aliae").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(true);
                patientRepository.save(patient);
            });
            Stream.of("Aya","YAYA","Aliae").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecinRepository.save(medecin);
            });

        };
    }
}
