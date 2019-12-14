
@tag
Feature: Validacion API PErsona

  @tag2
  Scenario Outline: Consultar Persona
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name     |             value          | status  |
      | endpoint |  /devops/services/persona/ |  200    |

	@tag2
  Scenario Outline: Crear Persona
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name     |             value          | status  |
      | endpoint |  /devops/services/persona/ |  200    |

  @tag2
  Scenario Outline: Editar Persona
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name     |             value          | status  |
      | endpoint |  /devops/services/persona/ |  200    |
