package eli.cq.springboot.demo.controller;

import eli.cq.springboot.demo.model.Course;
import eli.cq.springboot.demo.service.CourseJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/course")
public class CourseJdbcController {

    @Autowired
    private CourseJdbcService courseJdbcService;

    //works fine tested via post-man
    @GetMapping("/all")
    public List < Course > list(){
        return courseJdbcService.list();
    }
    //works fine tested using postman
    @PostMapping("/add")
    public void create(@RequestBody Course course){
        courseJdbcService.create( course );
    }

    //works fine tested using postman
    @GetMapping("/{id}")
    public Optional <Course> get(@PathVariable int id){
        return courseJdbcService.get( id );
    }

    @RequestMapping(value="/patch/{id}")
    public void update( @PathVariable int id, @RequestBody Course course){
        courseJdbcService.update( id,get( id ).get() );
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
         courseJdbcService.delete( id );
    }

}
