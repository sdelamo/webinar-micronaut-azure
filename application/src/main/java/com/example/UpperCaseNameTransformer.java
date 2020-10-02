package com.example;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Singleton
public class UpperCaseNameTransformer implements NameTransformer {
    @NotNull
    @Override
    public String transform(@NotNull @NotBlank @Pattern(regexp = "sergio") String name) {
        return name.toUpperCase();
    }
}
