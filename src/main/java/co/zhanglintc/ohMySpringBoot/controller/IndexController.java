package co.zhanglintc.ohMySpringBoot.controller;

import co.zhanglintc.ohMySpringBoot.mapper.StudentMapper;
import co.zhanglintc.ohMySpringBoot.pojo.Student;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
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

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        // 删除表中全部数据
        studentMapper.delete(null);

        // 普通Bean
        restResult.put("Student", student);

        // jdbcTemplate
        String sql = "select * from Student";
        Object jdbcTemplateResult = jdbcTemplate.queryForList(sql);
        restResult.put("jdbcTemplateResult", jdbcTemplateResult);

        // selectStudents
        Object mybatisMapperResultBefore = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultBefore", mybatisMapperResultBefore);

        // insertStudent
        Student student = new Student("tom", 22, "bigboos@tom.com");
        studentMapper.insertStudent(student);

        // 确认结果
        Object mybatisMapperResultMiddle = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultMiddle", mybatisMapperResultMiddle);

        // sqlSession
        Object sqlSessionResult = sqlSession.selectList("co.zhanglintc.ohMySpringBoot.mapper.StudentMapper.selectStudents");
        restResult.put("sqlSessionResult", sqlSessionResult);

        // 创建queryWrapper
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");

        // selectMaps与selectList
        List<Map<String, Object>> selectMapsResult = studentMapper.selectMaps(queryWrapper);
        restResult.put("selectMapsResult", selectMapsResult);
        List<Student> selectListResult = studentMapper.selectList(queryWrapper);
        restResult.put("selectListResult", selectListResult);

        // deleteStudentById并确认结果
        studentMapper.deleteStudentById(student.getId());
        Object mybatisMapperResultAfter = studentMapper.selectStudents();
        restResult.put("mybatisMapperResultAfter", mybatisMapperResultAfter);

        return restResult;
    }

    @RequestMapping("/filterAndInterceptor")
    public Object filterAndInterceptor() {
        System.out.println("in function filterAndInterceptor");
        System.out.println(env.getProperty("student.name"));
        return "filter & interceptor";
    }
}
