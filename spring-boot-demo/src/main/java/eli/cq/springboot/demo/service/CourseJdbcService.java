package eli.cq.springboot.demo.service;

import eli.cq.springboot.demo.dao.CourseJdbcDao;
import eli.cq.springboot.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class CourseJdbcService {
    @Autowired
    private CourseJdbcDao courseJdbcDao;

    public List < Course > list(){
        return courseJdbcDao.list();
    }

    public void create(Course course){
        courseJdbcDao.create( course );
    }

    public Optional <Course> get( int id){
        return courseJdbcDao.get( id );
    }

    public void update(int id,Course course){
        courseJdbcDao.update( id,course );
    }

    public void delete(int id){
         courseJdbcDao.delete( id );
    }

}
