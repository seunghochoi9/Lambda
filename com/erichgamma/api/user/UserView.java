package com.erichgamma.api.user;

import com.erichgamma.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scanner) throws SQLException {
        while (UserRouter.routing(scanner));
    }
}