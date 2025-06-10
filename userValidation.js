// userValidation.js

/**
 * Validates user input for registration and updates.
 * @param {object} userData - Object containing user details.
 * @param {string} userData.username - User's chosen username.
 * @param {string} userData.email - User's email address.
 * @param {string} userData.password - User's password.
 * @param {number} userData.age - User's age.
 * @returns {object} - An object indicating success and any error messages.
 */
function validateUserDetails(userData) {
    const errors = [];

    // Validation: Username must be between 3 and 20 characters
    if (!userData.username || userData.username.length < 3 || userData.username.length > 20) {
        errors.push("Username must be between 3 and 20 characters.");
    }

    // Validation: Email must be a valid format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!userData.email || !emailRegex.test(userData.email)) {
        errors.push("Invalid email format.");
    }

    // Validation: Password must be at least 8 characters and contain a number
    const passwordRegex = /^(?=.*\d).{8,}$/;
    if (!userData.password || !passwordRegex.test(userData.password)) {
        errors.push("Password must be at least 8 characters and include a number.");
    }

    // Validation: Age must be a number and at least 13
    if (typeof userData.age !== 'number' || userData.age < 13) {
        errors.push("Age must be a number and at least 13.");
    }

    // Functional Requirement: Record validation attempt
    console.log(`Attempting to validate user: ${userData.username || 'N/A'}`);

    if (errors.length > 0) {
        // Functional Requirement: Return specific error messages on validation failure
        return { success: false, messages: errors };
    } else {
        // Functional Requirement: Indicate successful validation
        return { success: true, messages: ["Validation successful."] };
    }
}

/**
 * Sends a welcome email to a new user.
 * @param {string} email - The email address of the new user.
 * @param {string} username - The username of the new user.
 */
function sendWelcomeEmail(email, username) {
    // Functional Requirement: Compose and send a personalized welcome email
    console.log(`Sending welcome email to ${username} at ${email}.`);
    // In a real app, this would integrate with an email service
}

// Example usage (not part of the AI's analysis, just for context)
// const newUser = { username: "jsuser1", email: "test@example.com", password: "Password123", age: 25 };
// const validationResult = validateUserDetails(newUser);
// if (validationResult.success) {
//     sendWelcomeEmail(newUser.email, newUser.username);
// } else {
//     console.error("Validation errors:", validationResult.messages);
// }
