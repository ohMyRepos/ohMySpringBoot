package co.zhanglintc.ohMySpringBoot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "student")
@Alias("Student")
@TableName("Student")
public class Student {
    private Long id;
    private String name;
    private Integer age;

    @Email
    @TableField("e_mail")
    private String email;

    public Student() {}

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
