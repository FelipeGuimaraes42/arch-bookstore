describe("Sign In E2E Test", () => {
    it("Logs in with valid credentials", () => {
      cy.visit("http://localhost:5173/signin");
      cy.get('input[type="text"]').type("admin");
      cy.get('input[type="password"]').type("admin");
      cy.get('button').contains("Sign In").click();
      cy.url().should("eq", "http://localhost:5173/");
    });
  
    it("Displays an error with invalid credentials", () => {
      cy.visit("http://localhost:5173/signin");
      cy.get('input[type="text"]').type("admin");
      cy.get('input[type="password"]').type("wrong_password");
      cy.get('button').contains("Sign In").click();
      cy.get('.MuiAlert-filledError').should('exist');
    });
  });
  