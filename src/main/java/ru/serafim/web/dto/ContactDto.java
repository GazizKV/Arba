package ru.serafim.web.dto;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactDto {
    private String email;
    private List<Address> addressList;
    private List<Phone> phoneList;

    public static ContactDto from(Contact contact) {
        if(contact == null) return null;
        return ContactDto.builder()
                .email(contact.getEmail())
                .addressList(contact.getAddressList())
                .phoneList(contact.getPhoneList())
                .build();
    }

    public static List<ContactDto> from(List<Contact> contactList) {
        return contactList.stream()
                .map(ContactDto::from)
                .collect(Collectors.toList());
    }
}
