const { v4: uuidv4 } = require('uuid');

describe('successfull operation', () => {
    it('user can make an operation and return result', () => {

        cy.visit('/do-math');
        cy.findByRole('button', { name: /1/i }).click();
        cy.findByRole('button', { name: /+/i }).click();
        cy.findByRole('button', { name: /3/i }).click();
   
    });
});

describe("dividing by zero operation", () => {
  it("user can make an operation and return an error of dividing by zero", () => {
    cy.visit("/do-math");
    cy.findByRole("button", { name: /1/i }).click();
    cy.findByRole("button", { name: "/" }).click();
    cy.findByRole("button", { name: /0/i }).click();
  });
});