package online.aquan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
    private Integer approvalStatus;
    private String name;
    private Date birth;
    private Long pid;
    @TableField(exist = false)
    private String professionName;
    private String className;
    private Date entranceTime;
    private Date leaveTime;
    private String employmentUnit;
    private String location;
    private String phoneNumber;
    private String email;
    private Date lastLogin;
    private Integer loginTimes;
}
