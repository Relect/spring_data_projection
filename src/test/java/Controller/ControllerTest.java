package Controller;

import com.example.projection.controller.Controller;
import com.example.projection.model.Department;
import com.example.projection.model.Employee;
import com.example.projection.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private Service service;
    @InjectMocks
    private Controller controller;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getEmployeeByIdTest() throws Exception {
        Department department = new Department(1L, "development");
        Employee employee = new Employee(1L, "Ivan", "Ivanov", "junior", 50000, department);
        Mockito.when(service.getEmployeeById(1L)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/emp/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Ivan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Ivanov"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.position").value("junior"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(50000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.department.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.department.name").value("development"));

        Mockito.verify(service, Mockito.times(1)).getEmployeeById(1);

    }

    @Test
    public void getAllEmployeeTest() throws Exception {
        Employee employee1 = new Employee(1L, "Ivan", "Ivanov", "junior", 50000, null);
        Employee employee2 = new Employee(1L, "Maksim", "Maskimov", "junior", 50000, null);
        Mockito.when(service.getAllEmployee()).thenReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(MockMvcRequestBuilders.get("/emp"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Ivan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("Maksim"));

    }
}
