/// <reference types="cypress" />

describe("User Account Creation and Book Addition Test", () => {
    const randomSuffix = Math.floor(Math.random() * 10000);
    const username = `username_${randomSuffix}`;
    const password = `password_${randomSuffix}`;
    
    it("should create an account, log in, and add a book to the cart", () => {
      // Visit the sign-up page
      cy.visit("http://localhost:5173/signup");
  
      // Fill in the sign-up form
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("#submit").click();
  
      // Ensure successful sign-up
      cy.get(".MuiAlert-filledSuccess").should("be.visible");
  
      // Log in with the created account
      cy.visit("http://localhost:5173/signin");
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("#submit").click();
  
      // Ensure successful login
    //   cy.get(".MuiAlert-filledSuccess").should("be.visible");
  
      // Add the book 'Engenharia de Software Moderna' to the cart
      cy.contains(".card", "Engenharia de Software Moderna")
        .find("button")
        .click();
  
      // Verify that the book is added to the cart
      cy.get(".cart-icon").should("have.text", "1");
    });
  });
  