describe('User Account Creation and Login', () => {
    it('should create an account and log in', () => {
      const randomNumber = Math.floor(Math.random() * 10000);
      const username = `username_${randomNumber}`;
      const password = `password_${randomNumber}`;
  
      // Visit the signup page
      cy.visit('http://localhost:5173/signup');
  
      // Fill in the signup form
      cy.get('#usernameSignUp').type(username);
      cy.get('#passwordSignUp').type(password);
      cy.get('#submitSignUp').click();
  
      // Check for successful signup alert
      cy.get('.MuiAlert-filledSuccess').should('contain', 'Successfully saved!');
  
      // Visit the login page
      cy.visit('http://localhost:5173/signin');
  
      // Fill in the login form
      cy.get('#usernameSignIn').type(username);
      cy.get('#passwordSignIn').type(password);
      cy.get('#submitSignIn').click();
  
      // Check for successful login and redirection to the homepage
      cy.url().should('eq', 'http://localhost:5173/');
    });
  });
  