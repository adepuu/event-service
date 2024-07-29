package com.adepuu.eventservice.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.Instant;
import java.time.format.DateTimeParseException;

@Configuration
public class GraphQLConfig {
  // This one is for enabling DateTime as scalar type in GraphQL
  // https://github.com/graphql-java/graphql-java-extended-scalars
  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.DateTime).scalar(instantScalar());
  }

  @Bean
  public GraphQLScalarType instantScalar() {
    return GraphQLScalarType.newScalar()
            .name("Instant")
            .description("Java Instant as scalar")
            .coercing(new Coercing<Instant, String>() {
              @Override
              public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                if (dataFetcherResult instanceof Instant) {
                  return ((Instant) dataFetcherResult).toString();
                } else {
                  throw new CoercingSerializeException("Expected a Instant object.");
                }
              }

              @Override
              public Instant parseValue(Object input) throws CoercingParseValueException {
                try {
                  if (input instanceof String) {
                    return Instant.parse((String) input);
                  } else {
                    throw new CoercingParseValueException("Expected a String");
                  }
                } catch (DateTimeParseException e) {
                  throw new CoercingParseValueException(String.format("Not a valid Instant: '%s'.", input), e);
                }
              }

              @Override
              public Instant parseLiteral(Object input) throws CoercingParseLiteralException {
                if (!(input instanceof String)) {
                  throw new CoercingParseLiteralException("Expected a StringValue.");
                }
                try {
                  return Instant.parse((String) input);
                } catch (DateTimeParseException e) {
                  throw new CoercingParseLiteralException(String.format("Not a valid Instant: '%s'.", input));
                }
              }
            }).build();
  }
}
