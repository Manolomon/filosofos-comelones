# Preguntas

1. ¿Qué medidas tomaste para evitar _deadlocks_?
   Dada una inicialización específica se pretende que se siga una secuencia de solicitudes de recursos un un orden específico. Adicionalmente, los filósofos sueltan en recurso que obtienen en la siguiente iteración, en la espera de poder juntar los dos en la siguiente.

2. ¿Qué medidas tomaste para evitar inanición?
   Se especifican los dos casos en los que puede caer un hilo, encontrar el tenedor izquierdo y luego el derecho, y viceversa. De esta forma, si es que el hilo no logra juntarlos en una iteración, dadas las condiciones aleatorias de espera, se espera que pueda caer en alguna de las dos opciones en la siguiente iteración.

3. ¿Qué medidas tomaste para conservar la integridad del recurso compartido?
    En el caso de encontrar los recursos que solicita ocupados, el filósofo intentará hasta que sean soltados en la siguiente iteración

4. ¿Qué medidas tomaste para no malgastar los recursos?
   Los filósofos sólo hacen dos solicitudes por iteración, la de algún tenedor. De obtenerlo intenta obtener el otro, pero en caso negativo, dejan el recurso para que algún otro lo obtenga e intente lo mismo. Pero sólo realizan la búsqueda del otro recurso en caso de conseguir el primero.