package org.app;

import static org.junit.Assert.assertTrue;

import org.app.data_base.DataBase;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        DataBase dataBase = new DataBase();
        dataBase.deleteUser("admin1");
        dataBase.deleteUser("maksimka");
//        dataBase.addUser("admin1", "admin");
//        dataBase.addUser("admin1", "admin", "admin");
//        dataBase.addUser("admin2", "admin", "admin");
//        System.out.println(dataBase.getAllUserData());
    }
}
