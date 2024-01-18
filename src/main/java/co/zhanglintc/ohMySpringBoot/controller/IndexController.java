package co.zhanglintc.ohMySpringBoot.controller;

import co.zhanglintc.ohMySpringBoot.mapper.StudentMapper;
import co.zhanglintc.ohMySpringBoot.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SqlSession sqlSession;

    @Autowired
    Student student;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        restResult.put("Student", student);

        String sql = "select * from Student";
        Object jdbcTemplateResult = jdbcTemplate.queryForList(sql);
        restResult.put("jdbcTemplateResult", jdbcTemplateResult);

        Object mybatisMapperResultBefore = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultBefore", mybatisMapperResultBefore);

        Student student = new Student("tom", 22, "bigboos@tom.com");
        studentMapper.insertStudent(student);

        Object mybatisMapperResultMiddle = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultMiddle", mybatisMapperResultMiddle);

        Object sqlSessionResult = sqlSession.selectList("co.zhanglintc.ohMySpringBoot.mapper.StudentMapper.selectStudents");
        restResult.put("sqlSessionResult", sqlSessionResult);

        studentMapper.deleteStudentById(student.getId());
        Object mybatisMapperResultAfter = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultAfter", mybatisMapperResultAfter);

        return restResult;
    }
}
