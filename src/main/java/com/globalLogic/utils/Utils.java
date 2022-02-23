package com.globalLogic.utils;

import com.globalLogic.models.Basket;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Utils {

    public static String getProperty(String name) {
        SystemEnvironmentVariables envList = (SystemEnvironmentVariables) SystemEnvironmentVariables.createEnvironmentVariables();
        return envList.getProperty(name);
    }

    public static Basket basket;

}