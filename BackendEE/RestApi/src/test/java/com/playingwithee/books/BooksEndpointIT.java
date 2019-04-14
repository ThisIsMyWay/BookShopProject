package com.playingwithee.books;

import io.restassured.response.ResponseBody;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BooksEndpointIT {


    @Test
    public void shouldReturnBooksWithCode200() throws IOException {

        final ResponseBody bodyToValidate =
                given().
                        when().
                        get("http://192.168.99.100:8080/bookshop/rest/books")
                        .then().
                        statusCode(200).
                        extract().response().getBody();

        final String booksExpectedBody =  IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("com/playingwithee/books/ExpectedBodyForShouldReturnBooksWithCode200.json")),"UTF-8");

        Assert.assertEquals(booksExpectedBody, bodyToValidate.prettyPrint());
    }

    @Test
    public void shouldReturnOneBookWithCode200() throws IOException {
        final ResponseBody bodyToValidate =
                given().
                        pathParam("bookId", 1).
                        when().
                        get("http://192.168.99.100:8080/bookshop/rest/books/{bookId}").
                        then().
                        statusCode(200).
                        extract().response().getBody();

        final String bookOfId1ExpectedBody =  IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("com/playingwithee/books/ExpectedBodyForShouldReturnOneBookWithCode200.json")),"UTF-8");

        Assert.assertEquals(bookOfId1ExpectedBody, bodyToValidate.prettyPrint());
    }
}
