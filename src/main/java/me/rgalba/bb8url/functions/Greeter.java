package me.rgalba.bb8url.functions;

import java.util.function.Function;

public class Greeter implements Function<String, String> {

    @Override
    public String apply(String s) {
        return "Hello " + s + ", and welcome to BB8 URL shortener!!!";
    }
}
