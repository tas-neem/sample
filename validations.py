class User:
    def __init__(self, name: str, age: int, email: str):
        if not name:
            raise ValueError("Name cannot be empty.")
        if age < 18:
            raise ValueError("User must be at least 18 years old.")
        if "@" not in email:
            raise ValueError("Invalid email address.")
        
        self.name = name
        self.age = age
        self.email = email

    def register(self):
        """
        Registers the user into the system.
        """
        return f"{self.name} registered."

# Example usage
try:
    user = User("Alice", 25, "alice@example.com")
    print(user.register())

    # Uncomment to see validation in action
    # user2 = User("", 16, "aliceatexample.com")
except ValueError as e:
    print("Registration failed:", e)
