package dataaccess.models;

public record Customer(
        int id,
        String firstName,
        String lastName,
        String country,
        String postalCode,
        String phoneNumber,
        String email) {


}
