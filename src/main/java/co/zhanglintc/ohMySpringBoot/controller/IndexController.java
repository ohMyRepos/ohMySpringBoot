package co.zhanglintc.ohMySpringBoot.controller;

import co.zhanglintc.ohMySpringBoot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Person person;

    @RequestMapping("/")
    public Object index() {
        String sql = "select * from Student";
        // Object object = jdbcTemplate.queryForList(sql);
        return person;
    }
}
