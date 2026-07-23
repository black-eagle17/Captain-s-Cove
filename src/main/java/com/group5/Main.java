package com.group5;


public class Main {
    static void main() {
        //Application class handles game loop and overall game logic, loads scenes and handle quit or win.
        Application app = new Application(new IntroScene());
        app.run();

    }
}
