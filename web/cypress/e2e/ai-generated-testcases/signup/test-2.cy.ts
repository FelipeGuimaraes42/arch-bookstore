// E2E test case for creating an account with a random username and password
describe('Create Account', () => {
  it('should successfully create an account', () => {
    // Generate random username and password
    const randomUsername = `username_${Math.floor(Math.random() * 1000000)}`;
    const randomPassword = `password_${Math.floor(Math.random() * 1000000)}`;

    cy.visit('http://localhost:5173/signup'); // Replace with the actual URL

    // Fill out the registration form with random username and password
    cy.get('input[name="username"]').type(randomUsername);
    cy.get('input[name="password"]').type(randomPassword);

    // Submit the form
    cy.get('button[type="submit"]').click();

    // Ensure successful registration alert is shown
    cy.get('.MuiAlert-filledSuccess').should('be.visible');
  });

  it('should handle registration with an existing username', () => {
    // Generate random username and password
    const randomUsername = `username_${Math.floor(Math.random() * 1000000)}`;
    const randomPassword = `password_${Math.floor(Math.random() * 1000000)}`;

    // Register a user with the random username
    cy.request('POST', 'http://localhost:8080/customer/register', {
      username: randomUsername,
      password: randomPassword,
    });

    cy.visit('http://localhost:5173/signup'); // Replace with the actual URL

    // Fill out the registration form with the same random username and password
    cy.get('input[name="username"]').type(randomUsername);
    cy.get('input[name="password"]').type(randomPassword);

    // Submit the form
    cy.get('button[type="submit"]').click();

    // Ensure error alert for existing username is shown
    cy.get('.MuiAlert-filledError').should('be.visible');
  });
});
