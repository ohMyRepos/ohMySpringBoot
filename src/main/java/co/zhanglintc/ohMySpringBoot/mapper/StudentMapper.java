package co.zhanglintc.ohMySpringBoot.mapper;

import co.zhanglintc.ohMySpringBoot.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {
    void insertStudent(Student student);
    void deleteStudentById(int id);
    List<Student> selectStudents();
}
