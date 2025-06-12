function validateForm(data) {
    if (!data.name || data.name.length < 3) {
        throw new Error("Name too short.");
    }
    if (!data.email.includes("@")) {
        throw new Error("Invalid email.");
    }
    if (typeof data.age !== "number" || data.age < 18) {
        throw new Error("User must be at least 18.");
    }
}
