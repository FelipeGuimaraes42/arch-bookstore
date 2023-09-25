// Cypress E2E test case
describe('Login and Add Book to Cart', () => {
    it('Logs in and adds a book to the cart', () => {
      // Visit the sign-in page
      cy.visit('http://localhost:5173/signin');
  
      // Enter username and password
      cy.get('#username').type('admin');
      cy.get('#password').type('admin');
  
      // Click the Sign In button
      cy.get('#submit').click();
  
      // Wait for login to complete and redirect to the homepage
      cy.url().should('eq', 'http://localhost:5173/');
  
      // Click the "Add to cart" button for the book 'Engenharia de Software Moderna'
      cy.contains('Engenharia de Software Moderna')
        .parent()
        .find('button')
        .click();
  
      // Verify that the cart icon shows 1 item
      cy.get('.cart-icon').should('have.text', '1');
    });
  });
  