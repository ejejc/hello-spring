package hello.hellospring.ddd.converter;

import hello.hellospring.ddd.domain.Email;
import hello.hellospring.ddd.domain.EmailSet;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null) return null;
        return attribute.getEmails().stream()
                .map(vo -> vo.getAddress())
                .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String[] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
                .map(vo -> new Email(vo))
                .collect(Collectors.toSet());
        return new EmailSet(emailSet);
    }
}
