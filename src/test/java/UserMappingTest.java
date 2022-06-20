import entitiesAndMappings.User;
import entitiesAndMappings.UserMapping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.EntityManager;


public class UserMappingTest {

    private final EntityManager entityManager = new EntityManager();

    @Test
    public void checkIfUserLoginsRight() {
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User("root", "toor")));

        Assertions.assertTrue(entityManager.userMapping.checkIfLogged(entityManager.getConnection()));
    }

    @Test
    public void checkIfUsernameAndPasswordAreWrong() {
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User("", "")));

        Assertions.assertFalse(entityManager.userMapping.checkIfLogged(entityManager.getConnection()));
    }

    @Test
    public void checkIfUserIsAddedToDatabaseAfterRegistration() {
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User("what", "what")));
        boolean registered = entityManager.userMapping.checkIfRegistered(entityManager.getConnection());

        entityManager.closeConnection();
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User("what", "what")));
        Assertions.assertTrue(registered & entityManager.userMapping.checkIfLogged(entityManager.getConnection()));
    }
}
