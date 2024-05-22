package com.test.andy.springboottest.controller.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Tag(name = "測試用")
public class TestController {

    @Operation(summary = "打招呼", description = "greetings API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Error")})
    @Parameter()
    @GetMapping(value = "/hi/{name}")
    public ResponseEntity<String> test(@PathVariable("name") String name) {
        String greetings = "Hi, nice to meet you, " + name;
        return ResponseEntity.ok(greetings);
    }
}
