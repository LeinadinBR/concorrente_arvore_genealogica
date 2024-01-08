import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matrícula: 201911910
Inicio...: 26 de Marco de 2021
Alteracao: 27 de Marco de 2021
Nome.....: Display
Funcao...: Serve para incializar a tela 'Canvas'
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Display {
  private Canvas tela;    //objeto de 'Canvas' tela que serve para ser 'desenhado'

  /* *********************
  * Metodo: Display (constutor)
  * Funcao: constroi um objeto Display que carrega consigo o atributo de tela
  * Parametros: nenhum
  ********************* */
  public Display(){
    tela = new Canvas();
    tela.setSize(new Dimension(700,600));
    tela.setFocusable(false);
    tela.setBackground(new Color(120,150,255));
  }

  /* *********************
  * Metodo: criarBufferStrategy
  * Funcao: chama o createBufferStrategy de tela que serve para renderizar a imagem um numero de vezes antes de reproduzir
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  public void criarBufferStrategy(){
    tela.createBufferStrategy(2);
  }

  /* *********************
  * Metodo: getTela
  * Funcao: retorna tela
  * Parametros: nenhum
  * Retorno: Canvas
  ********************* */
  public Canvas getTela() {
    return tela;
  }
}
