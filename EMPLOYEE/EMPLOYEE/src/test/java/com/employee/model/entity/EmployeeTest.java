package com.employee.model.entity;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void testGetterAndSetter() {
        Employee emp = new Employee();

        emp.setId(1L);
        emp.setEmpName("Alok");
        emp.setEmpEmail("alok@test.com");
        emp.setEmpCode("EMP001");
        emp.setCompanyName("TCS");

        assertEquals(1L, emp.getId());
        assertEquals("Alok", emp.getEmpName());
        assertEquals("alok@test.com", emp.getEmpEmail());
        assertEquals("EMP001", emp.getEmpCode());
        assertEquals("TCS", emp.getCompanyName());
    }

    @Test
    void testAllArgsConstructor() {
        Employee emp = new Employee(
                1L,
                "Alok",
                "alok@test.com",
                "EMP001",
                "TCS"
        );

        assertEquals("Alok", emp.getEmpName());
        assertEquals("EMP001", emp.getEmpCode());
        assertEquals("TCS", emp.getCompanyName());
    }

    @Test
    void testToString() {
        Employee emp = new Employee(
                1L,
                "Alok",
                "alok@test.com",
                "EMP001",
                "TCS"
        );

        String result = emp.toString();

        assertTrue(result.contains("Alok"));
        assertTrue(result.contains("EMP001"));
        assertTrue(result.contains("TCS"));
    }

    @Test
    void testDefaultConstructor() {
        Employee emp = new Employee();
        assertNotNull(emp);
    }
}
