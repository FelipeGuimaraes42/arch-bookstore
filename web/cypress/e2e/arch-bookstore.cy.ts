/// <reference types="cypress" />

describe('Arch Bookstore', () => {
  it('It should create a new account and log on it', () => {
    // Generates random username and password
    const username = 'username_' + Math.floor(Math.random() * 100000)

    // Opens application
    cy.visit('http://localhost:5173');

    // Verify buttons
    cy.contains('a', 'SIGN IN').should('exist');
    cy.contains('a', 'SIGN UP').should('exist');

    // Redirects user to login screen if it tries to add a book to cart without being logged in
    cy.contains('.card', 'Engenharia de Software Moderna').find('button').contains('Add to cart').click();
    cy.wait(500);
    cy.contains('h1', 'Sign In').should('exist');

    // Returns to home
    cy.get('a').contains('Arch Bookstore').click();

    // Redirects user to login screen if it tries to access cart without being logged in
    cy.get('.dWuAmA').click();
    cy.wait(500);
    cy.contains('h1', 'Sign In').should('exist');

    // Returns to home
    cy.get('a').contains('Arch Bookstore').click();

    // Navigates to sign up screen
    cy.get('a').contains('SIGN UP').click();
    cy.wait(500);

    // Tries to create an account that already exists
    cy.get('input[type="text"]').type('admin');
    cy.get('input[type="password"]').type('admin');
    cy.get('button').contains('Create').click();
    cy.contains('div', 'Username not available!').should('exist');

    // Creates a new account
    cy.get('input[type="text"]').clear().type(username);
    cy.get('input[type="password"]').clear().type('testCypress123');
    cy.get('button').contains('Create').click();
    cy.contains('div', 'Successfully saved!').should('exist');

    // Navigates to sign in screen
    cy.get('a').contains('Already have an account? Sign In').click();
    cy.wait(500);

    // Tries to sign in with wrong account
    cy.get('input[type="text"]').type(username);
    cy.get('input[type="password"]').type(username);
    cy.get('button').contains('Sign In').click();
    cy.contains('div', 'Wrong username or password!').should('exist');

    // Sign in with the created account
    cy.get('input[type="text"]').clear().type(username);
    cy.get('input[type="password"]').clear().type('testCypress123');
    cy.get('button').contains('Sign In').click();
    
    // Verifies if login was successful
    cy.wait(500);
    cy.get('button').contains('LOGOUT');

    // Add a book to the cart
    cy.contains('.card', 'Engenharia de Software Moderna').find('button').contains('Add to cart').click();

    // Verifies cart elements
    cy.get('.dWuAmA').click();
    cy.contains('h2', 'Shopping Cart');
    cy.contains('h3', 'Engenharia de Software Moderna');
    cy.contains('button', '-');
    cy.contains('button', '+');
    cy.contains('p', '1');
    cy.contains('p', 'Price: R$67.60');
    cy.contains('p', 'Total: R$67.60');

    cy.contains('h2', 'Total: R$67.60');
    
    cy.contains('button', '+').click();
    cy.contains('p', '2');
    cy.contains('p', 'Price: R$67.60');
    cy.contains('p', 'Total: R$135.20');

    cy.contains('h2', 'Total: R$135.20');
    
    cy.contains('button', '-').click();
    cy.contains('p', '1');
    cy.contains('p', 'Price: R$67.60');
    cy.contains('p', 'Total: R$67.60');

    cy.contains('h2', 'Total: R$67.60');
    
    cy.contains('button', '-').click();
    cy.contains('p', 'No items in cart.');
    cy.contains('h2', 'Total: R$0.00');
    
    // Leave cart screen
    cy.get('body').click(1, 1);

    // Add two different books
    cy.contains('.card', 'The Hitchhiker\'s Guide to the Galaxy').find('button').contains('Add to cart').click();
    cy.contains('.card', 'The Hobbit').find('button').contains('Add to cart').click();

    cy.get('.dWuAmA').click();
    cy.contains('h3', 'The Hitchhiker\'s Guide to the Galaxy');
    cy.contains('h3', 'The Hobbit');
    
    cy.contains('p', 'Price: R$14.99');
    cy.contains('p', 'Total: R$14.99');
    cy.contains('p', 'Price: R$19.99');
    cy.contains('p', 'Total: R$19.99');

    cy.contains('h2', 'Total: R$34.98');

    cy.contains('.fQxOdQ', 'The Hitchhiker\'s Guide to the Galaxy').find('button').contains('-').click();
    cy.contains('p', 'Price: R$19.99');
    cy.contains('p', 'Total: R$19.99');

    cy.contains('h2', 'Total: R$19.99');

    cy.contains('.fQxOdQ', 'The Hobbit').find('button').contains('-').click();
    cy.contains('p', 'No items in cart.');
    cy.contains('h2', 'Total: R$0.00');
    
    // Leave cart screen
    cy.get('body').click(1, 1);

    // Log out from account
    cy.get('button').contains('LOGOUT').click();
    cy.wait(500);
    cy.get('button').contains('LOGOUT').should('not.exist');
  })
})