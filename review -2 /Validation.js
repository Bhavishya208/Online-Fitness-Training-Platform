document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("signup-form");

    form.addEventListener("submit", function (e) {
        let valid = true;

        const name = document.getElementById("name");
        const email = document.getElementById("email");
        const password = document.getElementById("password");

        // Clear previous error messages
        document.querySelectorAll(".error").forEach((el) => el.textContent = "");

        // Name validation
        if (name.value.trim() === "") {
            document.getElementById("name-error").textContent = "Name is required.";
            valid = false;
        }

        // Email validation
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email.value)) {
            document.getElementById("email-error").textContent = "Invalid email address.";
            valid = false;
        }

        // Password validation
        if (password.value.length < 6) {
            document.getElementById("password-error").textContent = "Password must be at least 6 characters.";
            valid = false;
        }

        if (!valid) {
            e.preventDefault(); // Prevent form submission
        }
    });
});
