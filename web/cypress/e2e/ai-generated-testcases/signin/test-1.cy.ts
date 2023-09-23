describe("Sign In E2E Test", () => {
    it("Logs in with valid credentials", () => {
      cy.visit("http://localhost:5173/signin");
      cy.get('input[name="username"]').type("admin");
      cy.get('input[name="password"]').type("admin");
      cy.get('button[type="submit"]').click();
      cy.url().should("eq", "http://localhost:5173/");
    });
  
    it("Displays an error with invalid credentials", () => {
      cy.visit("http://localhost:5173/signin");
      cy.get('input[name="username"]').type("admin");
      cy.get('input[name="password"]').type("wrong_password");
      cy.get('button[type="submit"]').click();
      cy.get('.MuiAlert-filledError').should('exist');
    });
  });
  