#language:es

Requisito: Pantalla de login
  
  Escenario: Hacer un login con datos correctos
    Dado Que tengo un navegador abierto
    Y que el navegador está apuntando a la página: "https://katalon-demo-cura.herokuapp.com/profile.php#login"
    Cuando Relleno en el campo que tiene por id: "txt-username" el valor "John Doe"
    Y Relleno en el campo que tiene por id: "txt-password" el valor "ThisIsNotAPassword"
    Y Apreto el botón que tiene por id "btn-login"
    Entonces Debe aperecer en pantalla el elemento "//section[@id='appointment']//h2" con el texto: "Make Appointment"
    