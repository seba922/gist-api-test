package com.git.steps;

import com.git.config.Configuration;
import com.git.controllers.GistController;
import com.git.domain.Comment;
import com.git.domain.CommentResponse;
import com.git.specstrategy.DefaultSpecStrategy;
import com.git.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class GistSteps {
    GistController gistController = new GistController(new DefaultSpecStrategy());
    CommentResponse[] commentResponseList;
    CommentResponse commentResponse;
    Response response;
    private int addedCommentId;

    @When("IO gets all comments")
    public void io_gets_all_comments() {
        System.out.println("HALOOOOOO " + Configuration.gistId);
        response = this.gistController.getAllComments();
        commentResponseList = Helper.convertResponseBodyToClass(response, CommentResponse[].class);
    }

    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode, "Incorrect status code");
    }

    @Then("List of all comments is bigger than {int}")
    public void listOfAllCommentsIsBiggerThan(int value) {
        Assert.assertTrue(commentResponseList.length > value, "List of comments is less than 1");
    }

    @Then("IO get added comment")
    public void ioGetAddedComment() {
        response = gistController.getComment(commentResponse.getId());
        commentResponse = Helper.convertResponseBodyToClass(response, CommentResponse.class);
    }

    @And("Comment id is correct")
    public void commentIdIsCorrect() {
        int commentIdFromGet = commentResponse.getId();
        Assert.assertEquals(addedCommentId, commentIdFromGet, "Incorrect comment id");
    }

    @And("IO remove added comment")
    public void ioRemoveAddedComment() {
        response = gistController.deleteComment(addedCommentId);
    }

    @When("IO add comment {string}")
    public void ioAddComment(String commentMessage) {
        Comment comment = new Comment();
        comment.setBody(commentMessage);
        response = gistController.postComment(comment);
        commentResponse = Helper.convertResponseBodyToClass(response, CommentResponse.class);
        addedCommentId = commentResponse.getId();
    }

    @And("Response has comment {string}")
    public void responseHasComment(String expectedComment) {
        Assert.assertEquals(commentResponse.getBody(), expectedComment, "Incorrect comment in response");
    }

    @When("IO add comment with null value in body")
    public void ioAddCommentWithNullValueInBody() {
        Comment comment = new Comment();
        response = gistController.postComment(comment);
    }
}
