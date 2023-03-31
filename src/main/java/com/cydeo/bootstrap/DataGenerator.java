package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Jack", "Nick", "johgn@cydeo.com",
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
                "5432543dfgh", true, "890876674", managerRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001",
                user1, LocalDate.now(), LocalDate.now().plusDays(25),
                "Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002",
                user3, LocalDate.now(), LocalDate.now().plusDays(10),
                "Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003",
                user4,LocalDate.now(), LocalDate.now().plusDays(32),
                "Creating Controllers", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

    }
}
