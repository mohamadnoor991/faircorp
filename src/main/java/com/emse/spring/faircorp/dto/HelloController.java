package com.emse.spring.faircorp.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/hello")
@Transactional

public class HelloController {
    @GetMapping("/{name}")
    public MessageDto welcome(@PathVariable String name) {
        return new MessageDto("Hello " + name);
}}
