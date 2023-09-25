describe('E2E Test Case', () => {
    it('Logs into the system and adds "Engenharia de Software Moderna" to cart', () => {
      // Visit the sign-in page
      cy.visit('http://localhost:5173/signin');
  
      // Fill in the username and password fields
      cy.get('#username').type('admin');
      cy.get('#password').type('admin');
  
      // Click the Sign In button
      cy.get('#submit').click();
  
      // Wait for login to complete
      cy.wait(2000);
  
      // Check if we are on the home page
      cy.url().should('eq', 'http://localhost:5173/');
  
      // Add "Engenharia de Software Moderna" to cart
      cy.contains('Engenharia de Software Moderna')
        .parent()
        .parent() // Assuming it's a grandparent of the book name
        .parent() // Assuming it's a parent of the book name
        .find('button')
        .click();
  
      // Verify that the book is added to the cart
      cy.get('.cart-icon').click(); // Open the cart
      cy.contains('Engenharia de Software Moderna').should('exist');
    });
  });
  