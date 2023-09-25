// Cypress E2E Test Case
describe('User Login and Add Book to Cart', () => {
    it('should log in and add a book to cart', () => {
      // Visit the signin page
      cy.visit('http://localhost:5173/signin');
  
      // Enter username and password
      cy.get('#username').type('admin');
      cy.get('#password').type('admin');
  
      // Click the Sign In button
      cy.get('#submit').click();
  
      // Wait for login to complete (you may need to adjust the wait time)
      cy.wait(1000);
  
      // Find the book 'Engenharia de Software Moderna' and click its "Add to Cart" button
      cy.contains('Engenharia de Software Moderna')
        .parent()
        .within(() => {
          cy.get('button').contains('Add to Cart').click();
        });
  
      // Check if the cart icon shows 1 item (you may need to adjust the selector)
      cy.get('.cart-icon').should('have.attr', 'data-count', '1');
    });
  });
  