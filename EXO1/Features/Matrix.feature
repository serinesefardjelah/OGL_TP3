Feature: Matrix Determinant Test
Scenario: Squared Matrix Test
  Given : I have a square matrix M
  |3|0|0|
  |0|3|0|
  |0|0|3|
  When : I calculate its determinant d
  Then : The determinant should be equal to 27.0
