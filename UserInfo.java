import java.util.Scanner;

public class UserInfo {
    private String name;
    private String userId;

    public UserInfo() {
        this.userId = "guest";  // Default user ID
    }

    public void getNameFromUser(Scanner scanner) {
        System.out.print("Please enter your first name and surname: ");
        this.name = scanner.nextLine();
        generateUserId();
    }

    public void generateUserId() {
        if (name != null && name.contains(" ")) {
            String[] parts = name.split(" ");
            // First initial from the first name
            String firstNameInitial = String.valueOf(parts[0].charAt(0));
            // Full surname
            String lastName = parts[parts.length - 1];
            // Combine to generate user ID
            userId = firstNameInitial + lastName;
        } else {
            // If no space is found in the name
            userId = "guest";
        }
    }

    public String getUserId() {
        return this.userId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}