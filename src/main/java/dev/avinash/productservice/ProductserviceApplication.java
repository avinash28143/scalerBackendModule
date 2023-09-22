package dev.avinash.productservice;

import dev.avinash.productservice.Repositories.CategoryRepository;
import dev.avinash.productservice.Repositories.ProductRepository;
import dev.avinash.productservice.inheritancedemo.mappedsuperclass.Mentor;
//import dev.avinash.productservice.inheritancedemo.singletable.*;
//import dev.avinash.productservice.inheritancedemo.tableperclass.*;
import dev.avinash.productservice.inheritancedemo.joinedtable.*;

import dev.avinash.productservice.models.Category;
import dev.avinash.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;

    private UserRepository userRepository;

    private StudentRepository studentRepository;
    private  TaRepository taRepository;

    public ProductserviceApplication(@Qualifier(value = "jt_mr") MentorRepository mentorRepository,
                                     @Qualifier(value = "jt_ur") UserRepository userRepository,
                                     @Qualifier(value = "jt_sr") StudentRepository studentRepository,
                                     @Qualifier(value = "jt_tr") TaRepository taRepository,
                                     ProductRepository productRepository,
                                     CategoryRepository categoryRepository){
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.taRepository = taRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(ProductserviceApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user = new User();
//        user.setName("Avi");
//        user.setEmail("Avi@Scaler");
//        userRepository.save(user);
//
//        Student student = new Student();
//        student.setName("Arnav");
//        student.setEmail("Arnav@143");
//        student.setAttendance(99.8);
//        student.setPsp(5.6);
//        studentRepository.save(student);
//
//        Mentor mentor = new Mentor();
//        //  mentor.setId(7L);
//        mentor.setName("Avinash");
//        mentor.setEmail("avinash@gmail.com");
//        mentor.setAverageRating(4.5);
//       // mentorRepository.save(mentor);
//
//        TA ta = new TA();
//        ta.setName("Arnav bb");
//        ta.setEmail("Aravbb@143");
//        ta.setAverageRating(7.7);
//        taRepository.save(ta);


    private final ProductRepository productRepository;

    private Product product = new Product();
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category = new Category();
        category.setName("Apple Devices");

        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Apple 15 max pro");
        product.setDescription("Best IPhone ever");
        product.setCategory(savedCategory);
        productRepository.save(product);


        Category category1 = categoryRepository.findById(UUID.fromString("fc396c12-9689-46ca-9644-538ac84a5994")).get();

        System.out.println("Category of the product is : "+ " " + category1.getName());

        System.out.println("Printing all the products in the category");

        for (Product product1 : category1.getProducts()) {
                System.out.println(product1.getTitle());
        }
    }

}

