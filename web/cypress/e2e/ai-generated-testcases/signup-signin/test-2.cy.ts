// E2E test case for creating an account and logging in with Cypress

describe('User Account Creation and Login', () => {
    it('should create an account and log in', () => {
      // Generate random username and password
      const randomNum = Math.floor(Math.random() * 1000);
      const username = `username_${randomNum}`;
      const password = `password_${randomNum}`;
  
      // Visit the signup page
      cy.visit('http://localhost:5173/signup');
  
      // Fill out the signup form
      cy.get('input[name="username"]').type(username);
      cy.get('input[name="password"]').type(password);
      cy.get('button[type="submit"]').click();
  
      // Check if the account creation was successful
      cy.get('.MuiAlert-filledSuccess').should('contain.text', 'Successfully saved!');
  
      // Navigate to the login page
      cy.get('a[href="/signin"]').click();
  
      // Fill out the login form with the generated credentials
      cy.get('input[name="username"]').type(username);
      cy.get('input[name="password"]').type(password);
      cy.get('button[name="submit"]').click(); // Updated to use the button name
  
      // Check if the login was successful and user is redirected to the home page
      cy.url().should('eq', 'http://localhost:5173/');
    });
  });
  