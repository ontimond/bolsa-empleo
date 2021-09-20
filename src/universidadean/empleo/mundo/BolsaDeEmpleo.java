/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o más con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesión del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Años de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El teléfono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retornó true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        int n = this.aspirantes.size() -1;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < (n - i); j++) {
                Aspirante a = this.aspirantes.get(j);
                Aspirante b = this.aspirantes.get(j + 1);
                if(a.darNombre().compareTo(b.darNombre()) > 0) {
                    this.aspirantes.set(j, b);
                    this.aspirantes.set(j + 1, a);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selección <br>
     * <b>post: </b>La lista de aspirantes está ordenada por edad
     */
    public void ordenarPorEdad() {
        int n = this.aspirantes.size();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
          Aspirante a = this.aspirantes.get(j);
          Aspirante b = this.aspirantes.get(i);
          if(a.darEdad() < b.darEdad()) {
              Collections.swap(this.aspirantes, i, j);
          }
      }
    }
    }

    /**
     * Organiza la lista de aspirantes por profesión usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesión
     */
    public void ordenarPorProfesion() {
        int n = this.aspirantes.size() -1;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < (n - i); j++) {
                Aspirante a = this.aspirantes.get(j);
                Aspirante b = this.aspirantes.get(j + 1);
                if(a.darProfesion().compareTo(b.darProfesion()) > 0) {
                    this.aspirantes.set(j, b);
                    this.aspirantes.set(j + 1, a);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por años de experiencia usando el algoritmo de inserción <br>
     * <b>post: </b>La lista de aspirantes está ordenada por años de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
    for (int i = 1; i < this.aspirantes.size(); i++) {
        int index = i;
        Aspirante a = this.aspirantes.get(i);
        while (index > 0 && this.aspirantes.get(index - 1).darAniosExperiencia() > a.darAniosExperiencia()) {
            this.aspirantes.set(index, this.aspirantes.get(index - 1));
            index -= 1;
        }
        this.aspirantes.set(index, a);
    }
    }

    /**
     * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retornó la posición donde se encuentra un aspirante con el nombre dado. Si no se encuentra ningún aspirante con ese nombre se retornó -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
            for (Aspirante item: darAspirantes()){
        if(item.darNombre().equalsIgnoreCase(nombre)){
            posicion = darAspirantes().indexOf(item);
            System.out.println(posicion+" "+item.darNombre());
            }
        }

        return posicion;
    }

    /**
     * Busca un aspirante utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retornó la posición del aspirante con el nombre dado. Si el aspirante no existe se retornó -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;

        // TODO: Realizar el ejercicio correspondiente
        while (ini <= fin) {

            int centro = (fin + ini) / 2;

            int comparar = nombre.compareTo(aspirantes.get(centro).darNombre());

            if (aspirantes.get(centro).darNombre().equalsIgnoreCase(nombre)) {
                posicion = centro;
                break;

            } else if (comparar < 0) {

                ini = centro + 1;

            } else {
                fin = centro - 1;

            }

        }
        return posicion;
    }


    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante más joven. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        int edad = aspirantes.get(0).darEdad();

        for (Aspirante item: darAspirantes()){

            if (item.darEdad() <= edad){
                edad = item.darEdad();
                posicion = darAspirantes().indexOf(item);
            }
        }
        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con más edad. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        int edad = aspirantes.get(0).darEdad();

        for (Aspirante item: darAspirantes()){

            if (item.darEdad() >= edad){
                edad = item.darEdad();
                posicion = darAspirantes().indexOf(item);
            }
        }
        return posicion;
    }

    /**
     * Busca el aspirante con más años de experiencia en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        int experiencia = aspirantes.get(0).darAniosExperiencia();

        for (Aspirante item: darAspirantes()){

            if (item.darAniosExperiencia() >= experiencia){
                experiencia = item.darAniosExperiencia();
                posicion = darAspirantes().indexOf(item);
            }
        }
        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se eliminó el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retornó true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente
        int posicion = -1;
        for (Aspirante item: darAspirantes()){
            if(item.darNombre().equals(nombre)){
                posicion = darAspirantes().indexOf(item);
                aspirantes.remove(posicion);
            }
        }
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos años de experiencia <br>
     * son menores a la cantidad de años especificada <br>
     *
     * @param aniosExperiencia La cantidad de años con relación a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;

        int cont = 0;

        // TODO: Realizar el ejercicio correspondiente
        int experiencia = aspirantes.get(0).darAniosExperiencia();

        for (Aspirante item: darAspirantes()){

            if (item.darAniosExperiencia() < aniosExperiencia){
                experiencia = item.darAniosExperiencia();
                cont = darAspirantes().indexOf(item);
                eliminados ++;
                aspirantes.remove(cont);
            }
        }
        return eliminados;
    }

}
