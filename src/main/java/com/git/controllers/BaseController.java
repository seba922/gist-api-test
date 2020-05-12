package com.git.controllers;

import io.restassured.specification.RequestSpecification;
import com.git.specstrategy.SpecStrategy;

public abstract class BaseController {
    protected RequestSpecification requestSpecification;

    public BaseController(SpecStrategy specStrategy) {
        this.requestSpecification = specStrategy.requestSpecification();
    }
}
