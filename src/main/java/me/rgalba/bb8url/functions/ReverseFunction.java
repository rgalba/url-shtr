package me.rgalba.bb8url.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReverseFunction {

    @Bean("reverse")
    public Function<String, String> reverse() {
        return value -> new StringBuilder(value).reverse().toString();
    }
}
