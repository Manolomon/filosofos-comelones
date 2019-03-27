# Filósofos Comelones

- En una mesa redonda se sienta 5 filósofos, al centro de la mesa hay un tazón mágico de espagueti (que nunca se termina).
- Lo único que hacen los filósofos es comer y pensar (np pueden hacer las dos cosas al mismo tiempo)
- Para poder comer, cada filósofo necesita de dos tenedores: un tenedor izquierdo y uno derecho. En total hay 5 tenedores.
- Como es una mesa redonda, algunos de los tenedores son compartidos. Por ejemplo: el tenedor izquierdo del filósofo 1 es el derecho del filósofo 5, mientras que el tenedor derecho del filósofo 1 es el tenedor izquierdo del filósofo 2.
- Los recursos compartidos son los tenedores (2 por filósofo)
- Si dos filósofos adyacentes desean comer al mismo tiempo
puede generarse una condición de carrera (se compite por los
tenedores)
- Es necesario asegurar que eventualmente todos los filósofos
que desean comer lo hagan
- Es necesario evitar _dead-locks_

## Posible Solución

- Cada filósofo es un hilo diferente
- En cada hilo puede haber 4 métodos:
  - `Vivir (run)`: es un ciclo infinito, los filósofos piensan por un
tiempo aleatorio, luego se disponen a comer, tratan de tomar
primero el tenedor izquierdo y luego el derecho, si tienen los
dos tenedores comen durante un tiempo aleatorio (sino
esperan, hacen wait), dejan de comer (liberan los tenedores) y
repiten el ciclo indefinidamente.
  - `Pensar`: se imprime un mensaje que indica que el filósofo
está pensando. El hilo se duerme por un tiempo aleatorio.
  - `Tomar tenedor`: se indica si se quiere tomar el
tenedor izquierdo o derecho. Si alguno de los tenedores
esta ocupado el hilo se bloquea (se hace un wait)
  - `Comer`: se imprime un mensaje indicando que el
filósofo está comiendo. El hilo se duerme por un tiempo
aleatorio. Al terminar de comer el hilo libera los
tenedores y despierta a los hilos adyacentes que
pudieron haberse bloqueado

## Recomendaciones

Para evitar problemas de inanición se puede utilizar una
aproximación de alternancia estricta.
  - Cada tenedor es compartido por 2 hilos, cada tenedor
  puede ser una variable numérica, el valor del tenedor indica
  cuál de los dos hilos tiene el control del tenedor en un
  momento dado (ninguno lo tiene al inicio del proceso).
  - Un hilo solo puede utilizar el tenedor si es su turno.
  - Si el turno de un hilo termina (ya comió) le da el turno al
  otro hilo.
  - Para evitar dead-lock: Si se sigue la aproximación de
  alternancia estricta antes mencionado, se caerá en un
  dead-lock desde el principio del proceso. Para evitarlo
  basta con que uno de los filósofos no tome primero el
  tenedor izquierdo sino el derecho.

## Salida Esperada

```output
Filosofo 3 toma su tenedor derecho...
Filosofo 3 esta comiendo...
Filosofo 3 deja de comer...
Filosofo 3 esta pensando...
Filosofo 1 se prepara para comer...
Filosofo 1 toma su tenedor izquierdo...
Filosofo 1 toma su tenedor derecho...
Filosofo 1 esta comiendo...
Filosofo 4 se prepara para comer...
Filosofo 4 toma su tenedor izquierdo...
Filosofo 4 toma su tenedor derecho...
Filosofo 4 esta comiendo...
Filosofo 3 se prepara para comer...
Filosofo 3 toma su tenedor izquierdo...
```