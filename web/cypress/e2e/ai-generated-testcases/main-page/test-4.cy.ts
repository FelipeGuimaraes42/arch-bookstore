describe("E2E Test Case: User Login and Add Book to Cart", () => {
    it("should log into the system and add 'Engenharia de Software Moderna' to cart", () => {
      cy.visit("http://localhost:5173/signin");
  
      // Enter username and password
      cy.get("#username").type("admin");
      cy.get("#password").type("admin");
  
      // Click the Sign In button
      cy.get("#submit").click();
  
      // Wait for login and redirection to home page
      cy.url().should("eq", "http://localhost:5173/");
  
      // Add 'Engenharia de Software Moderna' to cart
      cy.contains("Engenharia de Software Moderna")
        .parent()
        .parent()
        .within(() => {
          cy.get("button").click();
        });
  
      // Verify that the item is in the cart
      cy.get(".cart-icon").click();
      cy.contains("Engenharia de Software Moderna").should("exist");
    });
  });
  