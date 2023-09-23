// E2E test case for creating an account using Cypress syntax
describe('Create Account', () => {
  it('should successfully create an account', () => {
    cy.visit('http://localhost:5173/signup'); // Replace with the actual URL

    // Fill out the registration form
    cy.get('input[name="username"]').type('testuser'); // Replace with a unique username
    cy.get('input[name="password"]').type('testpassword'); // Replace with a secure password

    // Submit the form
    cy.get('button[type="submit"]').click();

    // Ensure successful registration alert is shown
    cy.get('.MuiAlert-filledSuccess').should('be.visible');
  });

  it('should handle registration with an existing username', () => {
    cy.visit('http://localhost:5173/signup'); // Replace with the actual URL

    // Fill out the registration form with an existing username
    cy.get('input[name="username"]').type('existinguser'); // Replace with an existing username
    cy.get('input[name="password"]').type('testpassword'); // Replace with a secure password

    // Submit the form
    cy.get('button[type="submit"]').click();

    // Ensure error alert for existing username is shown
    cy.get('.MuiAlert-filledError').should('be.visible');
  });
});
