describe('Arch Bookstore', () => {
  it('It should create a new account and log on it', () => {
    cy.visit('http://localhost:5173');

    cy.get('a').contains('SIGN UP').click();
    cy.get('input[type="text"]').type('testeCypress');
    cy.get('input[type="password"]').type('testeCypress');
    cy.get('button').contains('Create').click();

    cy.get('a').contains('Already have an account? Sign In').click();
    cy.wait(1000);

    cy.get('input[type="text"]').type('testeCypress');
    cy.get('input[type="password"]').type('testeCypress');
    cy.get('button').contains('Sign In').click();
  })
})