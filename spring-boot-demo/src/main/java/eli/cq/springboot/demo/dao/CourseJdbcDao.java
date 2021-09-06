package eli.cq.springboot.demo.dao;

import eli.cq.springboot.demo.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public class CourseJdbcDao implements Dao< Course >{

    private static  final Logger logger= LoggerFactory.getLogger( CourseJdbcDao.class );

    private JdbcTemplate jdbcTemplate;

    public CourseJdbcDao( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper=(rs,rowNum)-> {
        Course course = new Course();
        course.setId( rs.getInt( "course_id" ) );
        course.setTitle( rs.getString( "title" ) );
        course.setDescription( rs.getString( "description" ) );
        course.setLink( rs.getString( "link" ) );
        return course;
    };

    @Override
    public List < Course > list() {
        String sql="select * from course";
        return jdbcTemplate.query( sql,rowMapper);
    }

    @Override
    public void create( Course course ) {
        String sql="insert into course(title,description,link) values(?,?,?)";
        int rowInsert=jdbcTemplate.update( sql,course.getTitle(),course.getDescription(), course.getLink() );
        if(rowInsert==1){
            logger.info( "New Course create: "+course.getTitle() );
        }
    }

    @Override
    public Optional < Course > get( int id ) {
        String sql="SELECT * FROM course WHERE course_id = ?";
        Course course=null;
        try{
            course=jdbcTemplate.queryForObject( sql,rowMapper,id );
        }catch(DataAccessException e){
            logger.info(e.getMessage());
        }
        return  Optional.ofNullable(course);
    }

    @Override
    public void update( int id, Course course ) {
        String sql="update course set title=?, description=?, link=? where course_id=?";
        int update= jdbcTemplate.update(sql,course.getTitle(),course.getDescription(), course.getLink(),id);
        if((update==1))
            logger.info( "Course updated:"+ course.getTitle() );
        else
            logger.info("Attempt to update"+course +" with id:"+id+" was not update successfully "  );

    }

    @Override
    public void delete( int id ) {
        jdbcTemplate.update("delete from course where course_id = ?",id );
    }
}
