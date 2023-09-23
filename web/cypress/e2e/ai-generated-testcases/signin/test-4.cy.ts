describe('User Login E2E Test', () => {
    it('Logs in with existing account', () => {
        cy.visit('http://localhost:5173/signin');

        cy.get('#username').type('admin');
        cy.get('#password').type('admin');
        cy.get('#submit').click();

        cy.url().should('eq', 'http://localhost:5173/');
    });

    it('Logs in with non-existing account', () => {
        cy.visit('http://localhost:5173/signin');

        cy.get('#username').type('admin');
        cy.get('#password').type('wrong_password');
        cy.get('#submit').click();

        cy.get('.MuiAlert-filledError').should('be.visible');
    });
});
