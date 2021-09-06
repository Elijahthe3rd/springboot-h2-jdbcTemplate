package eli.cq.springboot.demo;

import eli.cq.springboot.demo.dao.Dao;
import eli.cq.springboot.demo.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootDemoApplication {
//	private static Dao<Course> daoCourse;
//
//	public SpringBootDemoApplication(Dao<Course>daoCourse) {
//	this.daoCourse=daoCourse;
//	}


	public static void main( String[] args ) {
        SpringApplication.run( SpringBootDemoApplication.class, args );
//		System.out.println("\ncreate course\n");
//		Course jsReact=new Course("ReactJs","A JavaScript library for building user interfaces","https://reactjs.org/");
//		daoCourse.create( jsReact );
//
//		System.out.println("\nAll original courses\n");
//		List<Course> courses=daoCourse.list();
//		courses.forEach( System.out::println );
//		System.out.println("\n----------------------------------------------\n");
//
//		System.out.println("\nget a specific user by id:\n");
//		Optional <Course> singleCourse= daoCourse.get( 4 );
//		System.out.println(singleCourse)
//		;
//		System.out.println("\n----------------------------------------------\n");
////		courses.forEach( System.out::println );
//		String deleted=daoCourse.delete( 1 );
//		System.out.println(deleted);
//		System.out.println("\n----------------------------------------------\n");
//		System.out.println("\nAll After Deletion\n");
//
//		courses.forEach( System.out::println );
//		System.out.println("\n----------------------------------------------\n");

	}

}
