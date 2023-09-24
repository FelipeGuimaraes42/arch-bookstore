describe("User Account Creation and Login", () => {
    it("should create an account and log in", () => {
      const randomNum = Math.floor(Math.random() * 1000);
      const username = `username_${randomNum}`;
      const password = `password_${randomNum}`;
  
      // Visit the signup page
      cy.visit("http://localhost:5173/signup");
  
      // Fill out the signup form
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("form").submit();
  
      // Check if signup was successful
      cy.contains("Successfully saved!");
  
      // Go to the signin page
      cy.visit("http://localhost:5173/signin");
  
      // Fill out the signin form
      cy.get("#username").type(username);
      cy.get("#password").type(password);
      cy.get("#submit").click();
  
      // Check if login was successful and redirected to the homepage
      cy.url().should("eq", "http://localhost:5173/");
    });
  });
  