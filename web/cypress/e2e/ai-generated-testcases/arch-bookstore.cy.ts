// Generate random username and password
const randomNum = Math.floor(Math.random() * 1000000);
const username = `username_${randomNum}`;
const password = `password_${randomNum}`;

// Test case for creating an account, logging in, and adding a book to the cart
describe("User Account and Cart Test", () => {
    it("Creates an account, logs in, and adds a book to the cart", () => {
        // Visit the signup page
        cy.visit("http://localhost:5173/signup");

        // Fill in the signup form
        cy.get("#username").type(username);
        cy.get("#password").type(password);

        // Submit the signup form
        cy.get("#submit").click();

        // Check if the signup was successful (alert with "Successfully saved!")
        cy.get(".MuiAlert-filledSuccess").should("be.visible");

        // Visit the signin page
        cy.visit("http://localhost:5173/signin");

        // Fill in the signin form
        cy.get("#username").type(username);
        cy.get("#password").type(password);

        // Submit the signin form
        cy.get("#submit").click();

        // Check if the signin was successful (no error alert)
        cy.get(".MuiAlert-filledError").should("not.exist");

        // Add the book "Engenharia de Software Moderna" to the cart
        cy.contains("Engenharia de Software Moderna")
            .parentsUntil(".card")
            .parent()
            .find("button")
            .click();

        // Click on the cart icon
        cy.get(".cart-icon").click();

        // Verify that the cart contains the added item
        cy.contains("Engenharia de Software Moderna").should("exist");
    });
});
