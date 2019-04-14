package com.playingwithee.authors;

import io.restassured.response.ResponseBody;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AuthorsEndpointIT {

    @Test
    public void shouldReturnAuthorWithCode200() throws IOException {

        final ResponseBody bodyToValidate =
                given().
                    pathParam("authorId", 10).
                when().
                    get("http://192.168.99.100:8080/bookshop/rest/authors/{authorId}")
                .then().
                    statusCode(200).
                    extract().response().getBody();

        final String authorOfId4ExpectedBody =  IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("com/playingwithee/authors/ExpectedBodyForShouldReturnAuthorWithCode200.json")),"UTF-8");
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
