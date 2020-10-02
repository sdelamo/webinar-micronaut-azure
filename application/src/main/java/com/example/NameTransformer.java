package com.example;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.context.annotation.DefaultImplementation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@DefaultImplementation(UpperCaseNameTransformer.class)
public interface NameTransformer {

    @NonNull
    String transform(@NonNull @NotBlank @Pattern(regexp = "sergio") String name);
}
