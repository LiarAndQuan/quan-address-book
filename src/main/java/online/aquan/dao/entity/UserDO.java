package online.aquan.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private Long id;
    private String userName;
    private String password;
    private Integer approvalStatus;
    private String name;
    private Date birth;
    private Long pid;
    private String className;
    private Date entranceTime;
    private Date leaveTime;
    private String employmentUnit;
    private String location;
    private String photo;
    private String phoneNumber;
    private String email;
    private Date lastLogin;
    private Integer loginTimes;
    private String description;
}
