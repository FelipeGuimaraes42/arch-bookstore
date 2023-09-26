/// <reference types="cypress" />

describe("End-to-End Test Case", () => {
    it("should create an account, log in, and add a book to the cart", () => {
        const randomNum = Math.floor(Math.random() * 10000);
        const username = `username_${randomNum}`;
        const password = `password_${randomNum}`;

        // Create an account
        cy.visit("http://localhost:5173/signup");
        cy.get("#username").type(username);
        cy.get("#password").type(password);
        cy.get("#submit").click();
        cy.get(".MuiAlert-filledSuccess").should("be.visible");

        // Log in
        cy.visit("http://localhost:5173/signin");
        cy.get("#username").type(username);
        cy.get("#password").type(password);
        cy.get("#submit").click();

        // Add a book to the cart
        cy.get(".card").contains("Engenharia de Software Moderna")
            .parent().parent().parent().find(".cart-icon").click();

        //   // Add a book to the cart
        //   cy.get(".card").contains("Engenharia de Software Moderna")
        //     .parent().parent().parent().find("button").click();

        // Verify the cart
        cy.get(".cart-icon").click();
        cy.contains("Engenharia de Software Moderna").should("be.visible");
    });
});
