package com.example.es4;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "get name", description = "return name and reverse name")
public class Controller {
    @Operation(summary = "Return name", description = "Return name and reverse name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found ")
    })

    @GetMapping("/name")
    public String name(@RequestParam String name) {
        return name;
    }

    @PostMapping("/reverse-name")
    public String reverseName(@RequestParam String name) {
        return new StringBuilder(name).reverse().toString();
    }
}

