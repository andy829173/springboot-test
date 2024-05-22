package com.test.andy.springboottest.controller;

import com.test.andy.springboottest.controller.test.CalculationController;
import com.test.andy.springboottest.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


//@SpringBootTest // 用於進行完整的集成測試，啟動整個應用程式上下文。
//@AutoConfigureMockMvc //自動配置 MockMvc，通常與 @SpringBootTest 一起使用。

@WebMvcTest(CalculationController.class) //只加載指定的控制器及其相關的 Web 組件，不啟動嵌入式伺服器。
@Import(CalculatorService.class) //顯式導入控制器所依賴的其他 bean，使得這些 bean 能在測試中使用。
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(get("/calculation/add").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(get("/calculation/subtract").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(get("/calculation/multiply").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(get("/calculation/divide").param("a", "6").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        mockMvc.perform(get("/calculation/divide").param("a", "6").param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Divisor cannot be 0"));
    }

}
