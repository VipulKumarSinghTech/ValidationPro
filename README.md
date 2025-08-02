[![Maven Central](https://img.shields.io/maven-central/v/com.github.VipulKumarSinghTech/DateUtils.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/com.github.vipulkumarsinghtech/ValidationPro)


# 📦 ValidationPro

This library provides custom validation annotations for use with Jakarta Bean Validation (e.g., in Spring Boot or Jakarta EE applications).

---
## Contributors
- [Vipul Kumar Singh](https://github.com/vipul-kumar-singh)
---

## ✅ `@StartsWith`

**Description:**  
Validates that a string field starts with a specified prefix.

**Use Case:**  
Ensure names, paths, or codes follow a specific format.

**Example:**
```java
@StartsWith(prefix = "EMP_")
private String employeeCode;
```

---

## ✅ `@EndsWith`

**Description:**  
Validates that a string field ends with a specified suffix.

**Use Case:**  
Enforce file naming conventions or specific endings like ".jpg", ".log", etc.

**Example:**
```java
@EndsWith(suffix = ".log")
private String logFileName;
```

---

## ✅ `@ContainsSubstring`

**Description:**  
Validates that a string contains a specified substring.

**Use Case:**  
Ensure a sentence or path contains mandatory content (e.g., `/api/` in URLs).

**Example:**
```java
@ContainsSubstring(substring = "/api/")
private String endpointPath;
```

---

## ✅ `@FieldsMatch`

**Description:**  
Validates that the values of two fields in the same class are equal.

**Use Case:**  
Password and confirm-password match validations.

**Example:**
```java
@FieldsMatch(first = "password", second = "confirmPassword", message = "Passwords must match")
public class UserSignupDTO {
    private String password;
    private String confirmPassword;
}
```

---

## ✅ `@ValidEnum`

**Description:**  
Validates that a string value is one of the constants in a specified enum.

**Use Case:**  
Accept values like `"MALE"` or `"FEMALE"` only from a predefined enum.

**Example:**
```java
@ValidEnum(enumClass = Gender.class, ignoreCase = true)
private String gender;
```

---

## ✅ `@NotIn`

**Description:**  
Validates that a string or number is not within a given set of values.

**Use Case:**  
Reject reserved words or banned identifiers.

**Example:**
```java
@NotIn(values = { "admin", "root", "superuser" })
private String username;
```

---

## ✅ `@IfPresent`

**Description:**  
Validates an optional field only if it is present (non-null).

**Use Case:**  
Make validation conditional based on presence.

**Example:**
```java
@IfPresent
@Email
private String alternateEmail;
```

---

## ✅ `@FutureWithin`

**Description:**  
Validates that a date/time field is in the future but within a specified time window.

**Use Case:**  
Schedule an event within 30 days, not further.

**Example:**
```java
@FutureWithin(days = 30)
private LocalDate scheduledDate;
```

---

## ✅ `@NoHtmlTags`

**Description:**  
Validates that a string does not contain HTML/XML tags.

**Use Case:**  
Prevent HTML injection in input fields.

**Example:**
```java
@NoHtmlTags
private String userComment;
```

---

## ✅ `@ValidFileExtension`

**Description:**  
Validates that a filename ends with an allowed extension.

**Use Case:**  
Allow only image uploads or specific file types.

**Example:**
```java
@ValidFileExtension(extensions = { ".jpg", ".png", ".jpeg" })
private String uploadedFileName;
```

---

## ✅ `@AllowedPatternList`

**Description:**  
Validates that a string matches at least one of the specified regular expressions.

**Use Case:**  
Accept input matching multiple formats (e.g., phone or email).

**Example:**
```java
@AllowedPatternList(patterns = {
    "^\\+91\\d{10}$", // Indian mobile number
    "^\\w+@\\w+\\.\\w+$" // Simple email
})
private String contactInfo;
```

---

## ✅ `@UniqueElements`

**Description:**  
Validates that all elements in a collection are unique.

**Use Case:**  
Ensure no duplicate values in a list of emails, IDs, or roles.

**Example:**
```java
@UniqueElements
private List<String> tags;
```

---

## License & Copyright

© Vipul Kumar Singh

Licensed under the [MIT License](LICENSE).