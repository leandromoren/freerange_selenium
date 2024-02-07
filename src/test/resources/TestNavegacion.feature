@Navigation
Feature: Barra de navegacion
    Para ver las paginas dentro de FreeRangeTester
    Sin haber logeado
    Puedo hacer click en los links

    Background: Estoy en la web de Free range tester sin logearme
        Given Navego a www.freerangetester.com

    Scenario Outline: Puedo acceder a free Range testers
        When Voy a <section> usando la barra de navegacion
        Examples:
            | section    | 
            | Cursos     | 
            | Recursos   |
            | Udemy      |
            | Mentorías  |
            | Newsletter |

    @Courses
    Scenario: Los cursos son presentados correctamente al CEO
        When Voy a Cursos usando la barra de navegacion
        And Selecciono introduccion al testing

    @Plans @Courses
    Scenario: Usuarios pueden seleccionar un plan cuando se registran
        When Selecciono Elegir Plan
        Then El cliente puede validar las opciones in el checkout page