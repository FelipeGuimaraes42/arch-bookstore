/// <reference types="cypress" />

describe('End-to-End Test', () => {
    it('User can create an account, log in, and add a book to the cart', () => {
      // Generate a random number for the username and password
      const randomNumber = Math.floor(Math.random() * 100000);
      const username = `username_${randomNumber}`;
      const password = `password_${randomNumber}`;
      
      // Visit the signup page
      cy.visit('http://localhost:5173/signup');
  
      // Fill in the signup form
      cy.get('input[name="username"]').type(username);
      cy.get('input[name="password"]').type(password);
      cy.get('button[type="submit"]').click();
  
      // Assert that signup was successful
      cy.contains('Successfully saved!').should('be.visible');
  
      // Visit the signin page
      cy.visit('http://localhost:5173/signin');
  
      // Fill in the signin form with the generated username and password
      cy.get('input[name="username"]').type(username);
      cy.get('input[name="password"]').type(password);
    //   cy.get('button[type="submit"]').click();
      cy.get('button[name="submit"]').click();
  
      // Assert that signin was successful
    //   cy.contains('Client logged in').should('be.visible');
  
      // Visit the home page
    //   cy.visit('http://localhost:5173');
  
      // Find and click on the 'Add to cart' button for the book 'Engenharia de Software Moderna'
      cy.contains('Engenharia de Software Moderna')
        .parent().parent().parent().parent() // Adjust parent selectors as needed to reach the 'Add to cart' button
        .find('button')
        .click();
  
      // Open the cart
      cy.get('.cart-icon').click();
  
      // Assert that the book is in the cart
      cy.contains('Engenharia de Software Moderna').should('be.visible');
    });
  });
  