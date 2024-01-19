package co.zhanglintc.ohMySpringBoot.mapper;

import co.zhanglintc.ohMySpringBoot.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    void insertStudent(Student student);
    void deleteStudentById(Long id);
    List<Student> selectStudents();
}
