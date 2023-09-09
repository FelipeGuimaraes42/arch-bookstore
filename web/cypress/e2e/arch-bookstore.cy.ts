/// <reference types="cypress" />

describe('Arch Bookstore', () => {
  it('It should create a new account and log on it', () => {
    // Opens application
    cy.visit('http://localhost:5173');

    // Creates an account
    cy.get('a').contains('SIGN UP').click();
    cy.get('input[type="text"]').type('testeCypress');
    cy.get('input[type="password"]').type('testeCypress');
    cy.get('button').contains('Create').click();
    // cy.contains('div', 'Successfully saved!')

    // Navigates to sign in screen
    cy.get('a').contains('Already have an account? Sign In').click();
    cy.wait(1000);

    // Sign in with the created account
    cy.get('input[type="text"]').type('testeCypress');
    cy.get('input[type="password"]').type('testeCypress');
    cy.get('button').contains('Sign In').click();
    
    // Verifies if login was successful
    cy.wait(1000);
    cy.get('button').contains('LOGOUT')

    // Add a book to the cart
    cy.contains('.card', 'Engenharia de Software Moderna').find('button').contains('Add to cart').click()

    // Verifies cart icons
    cy.get('.dWuAmA').click()
    cy.contains('h2', 'Shopping Cart')
    cy.contains('h3', 'Engenharia de Software Moderna')
    cy.contains('button', '-')
    cy.contains('button', '+')
    cy.contains('p', '1')
    
    cy.contains('button', '+').click()
    cy.contains('p', '2')
    
    cy.contains('button', '-').click()
    cy.contains('p', '1')
    
    cy.contains('button', '-').click()
    cy.contains('p', 'No items in cart.')
  })
})