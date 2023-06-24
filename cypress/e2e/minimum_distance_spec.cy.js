describe('Minimum Distance Checker', () => {
  beforeEach(() => {
    cy.visit('HTML/MinDistance.html');
  });

  it('Calculates minimum distance for valid input', () => {
    // Enter valid input values
    cy.get('#word1').type('hello');
    cy.get('#word2').type('world');
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the expected results
    cy.get('#message')
      .should('have.class', 'valid')
      .and('have.text', 'Valid input. Minimum distance:');
    cy.get('#result').should('have.text', '4');
  });

  it('Shows error message for uppercase string', () => {
    // Enter uppercase string as input
    cy.get('#word1').type('HELLO');
    cy.get('#word2').type('world');
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the error message is displayed
    cy.get('#message')
      .should('have.class', 'invalid')
      .and(
        'have.text',
        'Invalid input: words should consist of lowercase English letters only.'
      );
  });

  it('Shows error message for special characters', () => {
    // Enter special characters as input
    cy.get('#word1').type('hello');
    cy.get('#word2').type('@world!');
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the error message is displayed
    cy.get('#message')
      .should('have.class', 'invalid')
      .and(
        'have.text',
        'Invalid input: words should consist of lowercase English letters only.'
      );
  });

  it('Shows error message for numbers', () => {
    // Enter numbers as input
    cy.get('#word1').type('hello');
    cy.get('#word2').type('123');
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the error message is displayed
    cy.get('#message')
      .should('have.class', 'invalid')
      .and(
        'have.text',
        'Invalid input: words should consist of lowercase English letters only.'
      );
  });

  it('Shows error message for empty input', () => {
    // Clear the input fields
    cy.get('#word1').clear();
    cy.get('#word2').clear();
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the error message for empty input
    cy.get('#message')
      .should('have.class', 'invalid')
      .and(
        'have.text',
        'Invalid input: words should consist of lowercase English letters only.'
      );
  });

  it('Shows error message for long words', () => {
    // Enter long words as input
    const longWord1 = 'a'.repeat(501);
    const longWord2 = 'b'.repeat(500);

    cy.get('#word1').type(longWord1);
    cy.get('#word2').type(longWord2);
    cy.get('button').contains('Calculate Minimum Distance').click();

    // Verify the error message for long words
    cy.get('#message')
      .should('have.class', 'invalid')
      .and(
        'have.text',
        'Invalid input: words should consist of lowercase English letters only.'
      );
  });
});
