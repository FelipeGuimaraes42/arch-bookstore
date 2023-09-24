/// <reference types="cypress" />

describe("Account Creation and Login E2E Test", () => {
    const getRandomNumber = () => Math.floor(Math.random() * 10000);
    const username = `username_${getRandomNumber()}`;
    const password = `password_${getRandomNumber()}`;
  
    it("should create an account and log in", () => {
      cy.visit("http://localhost:5173/signup");
  
      // Fill out the sign-up form
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("#submit").click();
  
      // Check for successful sign-up message
      cy.get(".MuiAlert-filledSuccess").should("contain.text", "Successfully saved!");
  
      // Navigate to the sign-in page
      cy.get("a[href='/signin']").click();
  
      // Fill out the sign-in form with the newly created account
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("#submit").click();
  
      // Check for successful login and redirection to the home page
      cy.url().should("eq", "http://localhost:5173/");
    });
  });
  