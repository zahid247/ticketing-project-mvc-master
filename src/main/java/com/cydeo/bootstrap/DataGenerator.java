package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy", "johgn@cydeo.com",
                "Abc1", true, "1234370988", managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Mike", "Smith", "mike@cydeo.com",
                "asfd4231", true, "41235125515", adminRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Norre", "Delisa", "norre@cydeo.com",
                "Abfdsa34444c1", true, "12343214", managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("John", "Kesy", "johgn@cydeo.com",
                "890089098ghj", true, "1234378", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Cragi", "Jack", "craig@cydeo.com",
                "FVVV2145Abc1", true, "231312455", employeeRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizabeth", "Taylor", "eliza@cydeo.com",
                "fdsafaf", true, "431241245", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria", "Ada", "ada@cydeo.com",
                "23454325", true, "13254376", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill", "Matt", "bill@cydeo.com",
                "5432543dfgh", true, "890876674", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

    }
}
