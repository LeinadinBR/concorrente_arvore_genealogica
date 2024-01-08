/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matrícula: 201911910
Inicio...: 25 de Marco de 2021
Alteracao: 27 de Marco de 2021
Nome.....: Principal
Funcao...: Funcao principal do programa
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Principal {
  /* *********************
  * Metodo: main
  * Funcao: iniciar o programa
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public static void main(String[] args){
    ThreadGenealogica tg = new ThreadGenealogica(); //cria um objeto de ThreadGenealogica
    tg.start();   //inicia a thread tg
  }
}