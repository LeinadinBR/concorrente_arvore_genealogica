/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matrícula: 201911910
Inicio...: 25 de Marco de 2021
Alteracao: 27 de Marco de 2021
Nome.....: ThreadGenealogica
Funcao...: Thread incial onde acontece a acao do pai
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class ThreadGenealogica extends Thread {

  private int contadorAnos=0;    //int para contar os anos do pai
  private MainFrame mainFrame;    //instancia de MainFrame

  /* *********************
  * Metodo: run (Override)
  * Funcao: algoritmo que a thread do pai segue
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  @Override
  public void run(){
    mainFrame = new MainFrame();    //instancia o objeto de MainFrame
    mainFrame.desenhar(contadorAnos, "Pai");    //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread
    
    for (int i=0; i<22; i++){     //durante 22 segundos chama o metodo desenhar
      dormir(1);
      contadorAnos++;
      mainFrame.desenhar(contadorAnos, "Pai");
    }
    
    Filho filho1 = new Filho(1);    //cria um objeto de Filho passando 1 como parametro
    filho1.start();   //inicia a thread filho1

    for (int i=0; i<3; i++){ //durante 3 sedundos chama o metodo desenhar
      dormir(1);
      contadorAnos++;
      mainFrame.desenhar(contadorAnos, "Pai");
    }

    Filho filho2 = new Filho(2);    //cria um objeto de Filho passando 2 como parametro
    filho2.start();     //inicia a thread filho2

    for (int i=0; i<7; i++){    //durante 7 segundos chama o metodo desenhar
      dormir(1);
      contadorAnos++;
      mainFrame.desenhar(contadorAnos, "Pai");
    }

    Filho filho3 = new Filho(3);    //cria um objeto de Filho passando 3 como parametro
    filho3.start();   //inicia a thread filho3

    for (int i=0; i<58; i++){   //durante 58 segundos chama o metodo desenhar
      dormir(1);
      contadorAnos++;
      mainFrame.desenhar(contadorAnos, "Pai");
    }

    dormir(10); //dorme por 10 segundos
    System.exit(0); //termina o programa
  }

  /* *********************
  * Metodo: dormir
  * Funcao: faz a thread que o chamar 'dormir' pelo numero de segundos dados no parametro
  * Parametros: int tempo
  * Retorno: void
  ********************* */
  private void dormir(int tempo){
    try {
      sleep(tempo*1000);
    } 
    catch (InterruptedException e) {}
  }
  
  /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
  Autor: Daniel Nogueira
  Matrícula: 201911910
  Inicio...: 25 de Marco de 2021
  Alteracao: 27 de Marco de 2021
  Nome.....: ThreadGenealogica$Filho
  Funcao...: Thread onde acontece as acoes dos filhos
  =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
  class Filho extends Thread {

    private int numFilho;   //int para identificar qual filho e usar as acoes correspondentes
    private int contadorAnos=0;    //int para contar os anos dos filhos
    
    /* *********************
    * Metodo: Filho (construtor)
    * Funcao: construir um objeto 'Filho'
    * Parametros: int numFilho
    ********************* */
    public Filho(int numFilho){
      this.numFilho = numFilho;
    }

    /* *********************
    * Metodo: run (Override)
    * Funcao: algoritmo que as threads de filhos seguem
    * Parametros: nenhum
    * Retorno: void
    ********************* */
    @Override
    public void run(){
      switch (numFilho){  //o switch utiliza o int que eh passado no construtor para identificar qual acao para prosseguir
        
        case 1: //filho 1===================================================================================================
          mainFrame.desenhar(contadorAnos, "Filho 1");    //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread
          
          for (int i=0; i<16; i++){   //durante 16 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;
            mainFrame.desenhar(contadorAnos, "Filho 1");
          }

          Neto neto1 = new Neto(1);   //cria um objeto de Neto passando 1 como parametro
          neto1.start();    //inicia a thread neto1

          for (int i=0; i<45; i++){   //durante 45 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;   
            mainFrame.desenhar(contadorAnos, "Filho 1");
          }

          break; //fim do filho1=======================================================================================================
       
        case 2: //filho 2==============================================================================================================
          mainFrame.desenhar(contadorAnos, "Filho 2");    //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread
          
          for (int i=0; i<20; i++){   //durante 20 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;
            mainFrame.desenhar(contadorAnos, "Filho 2");
          }

          Neto neto2 = new Neto(2);   //cria um objeto de Neto passando 2 como parametro
          neto2.start();    //inicia a thread neto2

          for (int i=0; i<35; i++){   //durante 35 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;
            mainFrame.desenhar(contadorAnos, "Filho 2");
          }

          break; //fim do filho 2======================================================================================================
        
        case 3: //filho 3==============================================================================================================
          mainFrame.desenhar(contadorAnos, "Filho 3");    //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread
          
          for (int i=0; i<55; i++){   //durante 55 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;
            mainFrame.desenhar(contadorAnos, "Filho 3");
          }

          break; //fim do filho 3======================================================================================================
        
        default:
          break;
      }
    }

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    Autor: Daniel Nogueira
    Matrícula: 201911910
    Inicio...: 25 de Marco de 2021
    Alteracao: 27 de Marco de 2021
    Nome.....: ThreadGenealogica$Filho$Neto
    Funcao...: Thread onde acontece as acoes dos netos
    =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    class Neto extends Thread {

      private int numNeto;    //int para identificar qual neto e usar as acoes correspondentes
      private int contadorAnos=0;    //int para contar os anos dos netos

      /* *********************
      * Metodo: Neto
      * Funcao: construir um objeto 'Neto'
      * Parametros: int numFilho
      ********************* */
      public Neto(int numNeto){
        this.numNeto = numNeto;
      }

      /* *********************
      * Metodo: run (Override)
      * Funcao: algoritmo que as threads de netos seguem
      * Parametros: nenhum
      * Retorno: void
      ********************* */
      @Override
      public void run(){    //o switch utiliza o int que eh passado no construtor para identificar qual acao para prosseguir
        switch(numNeto){

          case 1: //neto1==============================================================================================================
            mainFrame.desenhar(contadorAnos, "Neto 1");   //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread

            for (int i=0; i<30; i++){   //durante 30 segundos chama o metodo desenhar
              dormir(1);
              contadorAnos++;
              mainFrame.desenhar(contadorAnos, "Neto 1");;              
            }

            Bisneto bisneto = new Bisneto();    //cria um objeto de Bisneto
            bisneto.start();    //inicia a thread bisneto

            for (int i=0; i<5; i++){    //durante 5 segundos chama o metodo desenhar
              dormir(1);
              contadorAnos++;       
              mainFrame.desenhar(contadorAnos, "Neto 1");       
            }

            break; //fim do neto1======================================================================================================
          
          case 2: //neto2==============================================================================================================
            mainFrame.desenhar(contadorAnos, "Neto 2");   //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread

            for (int i=0; i<33; i++){   //durante 33 segundos chama o metodo desenhar
              dormir(1);
              contadorAnos++;
              mainFrame.desenhar(contadorAnos, "Neto 2");
            }

            break; //fim do neto2======================================================================================================

          default:
            break;
        }
      }

      /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
      Autor: Daniel Nogueira
      Matrícula: 201911910
      Inicio...: 25 de Marco de 2021
      Alteracao: 27 de Marco de 2021
      Nome.....: ThreadGenealogica$Filho$Neto$Bisneto
      Funcao...: Thread onde acontece a acao do bisneto
      =-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
      class Bisneto extends Thread {

        private int contadorAnos=0;    //int para contar os anos do bisneto

        /* *********************
        * Metodo: run (Override)
        * Funcao: algoritmo que a thread bisneto segue
        * Parametros: nenhum
        * Retorno: void
        ********************* */
        @Override
        public void run(){ //bisneto================================================================================================
          mainFrame.desenhar(contadorAnos, "Bisneto"); //chama o metodo desenhar passando o tempo decorrido e o id(String) da thread

          for (int i=0; i<12; i++){   //durante 12 segundos chama o metodo desenhar
            dormir(1);
            contadorAnos++;
            mainFrame.desenhar(contadorAnos, "Bisneto");
          }
        } //fim de bisneto==========================================================================================================
      }
    }
  }
} 