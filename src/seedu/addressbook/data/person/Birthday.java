package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Birthday {

    public static final String EXAMPLE = "20/10/1997";
    public static final String MESSAGE_BIRTHDAY_CONSTRAINTS = "Person birthday can be in any format";
    public static final String BIRTHDAY_VALIDATION_REGEX = ".+";



    public final String value;
    private boolean isPrivate;

    /**
     * Validates given Birthday.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Birthday(String birthday, boolean isPrivate) throws IllegalValueException {
        String trimmedBirthday = birthday.trim();
        this.isPrivate = isPrivate;
        if (!isValidBirthday(trimmedBirthday)) {
            throw new IllegalValueException(MESSAGE_BIRTHDAY_CONSTRAINTS);
        }
        this.value = trimmedBirthday;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.value.equals(((Birthday) other).value)); // state check
    }
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidBirthday(String test) {
        return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
