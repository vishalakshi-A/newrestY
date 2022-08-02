package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.entity.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Hello World!");

        public void deleteUsersTest() {
            Response responseUserCreation =
                    requestSpecification.body(createUser()).expect().statusCode(HttpStatus.SC_CREATED).log().ifError()
                            .when().post("https://gorest.co.in/public/v2/users/");

            User userForDeletion = responseUserCreation.as(User.class);
            requestSpecification.expect().statusCode(HttpStatus.SC_NO_CONTENT).log().ifError()
                    .when().delete("https://gorest.co.in/public/v2/users/" + userForDeletion.getId());
            Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                    .when().get("https://gorest.co.in/public/v2/users");
            List<User> users = response.jsonPath().getList("", User.class);
            Assert.assertFalse(users.contains(userForDeletion), "Expected users list doesn't contain deleted element");
        }



        /*Random random = new Random();
        User userToCreate = new User();
        userToCreate.setName("Test name " + random.nextInt());
        userToCreate.setEmail("test_email" + random.nextInt() + "@gmail.com");
        userToCreate.setGender("Male");
        userToCreate.setStatus("active");
*/

    }
}
