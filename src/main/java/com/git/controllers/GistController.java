package com.git.controllers;

import com.git.config.Configuration;
import com.git.domain.Comment;
import io.restassured.response.Response;
import com.git.specstrategy.SpecStrategy;

import static io.restassured.RestAssured.given;

public class GistController extends BaseController {

    public GistController(SpecStrategy specStrategy) {
        super(specStrategy);
    }

    public Response getAllComments() {
        return given()
                .spec(requestSpecification)
                .get("gists/" + Configuration.gistId + "/comments");
    }

    public Response getComment(int commentId) {
        return given()
                .spec(requestSpecification)
                .get("/gists/" + Configuration.gistId + "/comments/" + commentId);
    }

    public Response postComment(Comment comment) {
        return given()
                .spec(requestSpecification)
                .body(comment)
                .post("/gists/" + Configuration.gistId + "/comments");
    }

    public Response deleteComment(int commentId) {
        return given()
                .spec(requestSpecification)
                .delete("/gists/" + Configuration.gistId + "/comments/" + commentId);
    }
}
