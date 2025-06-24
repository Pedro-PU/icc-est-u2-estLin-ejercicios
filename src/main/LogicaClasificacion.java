package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for(char c : texto.toCharArray()){
            pila.push(c);
        }
        StringBuilder sc = new StringBuilder();
        while(!pila.isEmpty()){
            sc.append(pila.pop());
        }
        
        return ""+sc;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        for(int i = 0; i < expresion.length(); i++){
            if(expresion.charAt(i) == '(' || expresion.charAt(i) == '[' || expresion.charAt(i) == '{'){
                pila.push(expresion.charAt(i));
            }else if(expresion.charAt(i) == ')' || expresion.charAt(i) == ']' || expresion.charAt(i) == '}'){
                if(pila.isEmpty()){
                    return false;
                }
                if((expresion.charAt(i) == ')' && pila.peek() == '(') ||
                    (expresion.charAt(i) == ']' && pila.peek() == '[') ||
                    (expresion.charAt(i) == '}' && pila.peek() == '{')){
                    pila.pop();

                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pila2 = new Stack<>();
        while(!pila.isEmpty()){
            int aux = pila.pop();
            while(!pila2.isEmpty() && pila2.peek()>aux){
                pila.push(pila2.pop());
            }
            pila2.push(aux);
        }
        return pila2;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for(int num : original){
            if(num % 2 == 0){
                pares.add(num);
            }else{
                impares.add(num);
            }
        }

        pares.addAll(impares);
        return pares;
    }
}
