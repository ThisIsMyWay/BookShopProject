package com.playingwithee.authors;

import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AuthorsEndpointIT {

    private static final String authorOfId4ExpectedBody = "{\n" +
            "    \"links\": [\n" +
            "        {\n" +
            "            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/10\",\n" +
            "            \"rel\": \"self\",\n" +
            "            \"method\": \"GET\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"authorId\": 10,\n" +
            "    \"name\": \"Gabriel\",\n" +
            "    \"surname\": \"García Márquez\",\n" +
            "    \"birthDate\": \"1927-03-06\",\n" +
            "    \"deathDate\": \"2014-04-14\",\n" +
            "    \"booksOfAuthor\": [\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/10\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"id\": 10,\n" +
            "            \"title\": \"Love in the Time of Cholera\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public void shouldReturnAuthorWithCode200() {

        final ResponseBody bodyToValidate =
                given().
                    pathParam("authorId", 10).
                when().
                    get("http://192.168.99.100:8080/bookshop/rest/authors/{authorId}")
                .then().
                    statusCode(200).
                    extract().response().getBody();

        Assert.assertEquals(authorOfId4ExpectedBody, bodyToValidate.prettyPrint());
    }

    @Test
    public void shouldReturn204BecouseContentNotExists() {
                given().
                    pathParam("authorId", 50).
                when().
                    get("http://192.168.99.100:8080/bookshop/rest/authors/{authorId}").
                then().
                    statusCode(204);
    }


}
