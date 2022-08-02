package org.example;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
            }
            package org.example;


    /**
     * Hello world!
     *
     */

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

}
