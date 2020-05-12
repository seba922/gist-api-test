package com.git.specstrategy;

import com.git.config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DefaultSpecStrategy implements SpecStrategy {

    @Override
    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setContentType(ContentType.JSON)
                .setBaseUri(Configuration.url)
                .build();
    }
}
