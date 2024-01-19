package co.zhanglintc.ohMySpringBoot;

import co.zhanglintc.ohMySpringBoot.mapper.StudentMapper;
import co.zhanglintc.ohMySpringBoot.pojo.Student;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class OhMySpringBootApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();

        studentMapper.selectStudents();

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id").eq("id", 1);
        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println(students);
    }

}
