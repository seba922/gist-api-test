package com.git.specstrategy;

import io.restassured.specification.RequestSpecification;

public interface SpecStrategy {
    RequestSpecification requestSpecification();
}
