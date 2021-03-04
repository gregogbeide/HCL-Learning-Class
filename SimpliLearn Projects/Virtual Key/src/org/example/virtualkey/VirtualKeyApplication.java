package org.example.virtualkey;

import java.io.File;
import org.example.virtualkey.services.ScreenService;

public class VirtualKeyApplication {

    public static void main(String[] args) {

        ScreenService.getCurrentScreen().Show();
    }
}