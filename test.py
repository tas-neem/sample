def register_user(name: str, age: int, email: str):
    """
    Registers a user into the system.
    """
    if not name:
        raise ValueError("Name cannot be empty.")
    if age < 18:
        raise ValueError("User must be at least 18 years old.")
    if "@" not in email:
        raise ValueError("Invalid email address.")
    return f"{name} registered."
