package com.aleksei.api.todoapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/activity")
@Tag(name = "Activity Controller", description = "To-Do API")
public class ActivityController {

}

