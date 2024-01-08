
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Font;
import javax.swing.JFrame;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matrícula: 201911910
Inicio...: 26 de Marco de 2021
Alteracao: 27 de Marco de 2021
Nome.....: MainFrame
Funcao...: Serve para construir a parte grafica do programa
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class MainFrame extends JFrame {

  private static final long serialVersionUID = 1L; //numero serial de MainFrame por ser classe-filha de JFrame
  private BufferedImage image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_BGR);    //imagem na qual um objeto 'Graphic' pode 'desenhar'
  private SpriteSheet[] sprites;    //cria um arranjo de SpriteSheet que armazenara as imagens usadas no programa
  private Display display;    //cria um objeto de 'Display'

  /* *********************
  * Metodo: MainFrame
  * Funcao: constroi um objeto de mainFrame onde a interface grafica acontece
  * Parametros: nenhum
  ********************* */
  public MainFrame(){
    sprites = new SpriteSheet[18];    //instancia o objeto de sprites
    inicializarSprites();   //chama a funcao que inicializa os sprites
    display = new Display();    //cria um objeto de Display onde a tela 'Canvas' esta

    this.setTitle("Arvore Genealogica Animada");    //coloca o titulo
    this.add(display.getTela());    //adiciona a tela ao mainFrame
    this.pack();    //compacta o mainFrame para se tornar do tamanho da tala
    this.setVisible(true);    //coloca o mainFrame visivel
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //configura o programa para fechar o frame quando clicar no 'X'
  }

  /* *********************
  * Metodo: desenhar
  * Funcao: criar o objeto de 'Graphic' para que ele possa desenhar imagens e outras coisas na tela
  * Parametros: int tempo, String pessoa
  * Retorno: void
  ********************* */
  public void desenhar(int tempo, String pessoa){
    BufferStrategy bufferStrategy = display.getTela().getBufferStrategy();    //cria um objeto BufferStrategy que gera as imagens antes de mostrar na tela

    if (bufferStrategy == null){  //caso o bufferStrategy esteja nulo ele cria uma nova instancia a partir de tela
      display.criarBufferStrategy();
      bufferStrategy = display.getTela().getBufferStrategy();
    }
    
    Graphics g = image.getGraphics();   //cria um objeto 'Graphic' para desenhar na tela
    g = bufferStrategy.getDrawGraphics();   //atribui os graficos de desenho para 'g'
    g.setColor(Color.WHITE);    //coloca a cor do 'g' para branco
    g.setFont(new Font("Verdana", Font.BOLD, 25));    //coloca a fonte da letra de 'g' para uma fonte com os padroes passados nos parametros

    //desenha as palavras a seguir nos determinados x e y
    g.drawString("Pai", 12, 90);   
    g.drawString("Filhos", 12, 230);
    g.drawString("Netos", 12, 370);
    g.drawString("Bisneto", 12, 520);

    g.setColor(Color.BLACK);
    g.fillRect(125, 0, 5, 700);   //cria uma linha na tela

    g.setColor(new Color(120, 150, 255));

    switch(pessoa){ //o switch utiliza a String que eh passado no parametro para identificar qual acao para prosseguir

      case "Pai": //pai========================================================================================
        if (tempo >= 0 && tempo < 15)   //pai menor de 15 anos
          g.drawImage(sprites[0].getSprite(0, 0, 32, 32), 320, 40, 100, 100, null);
        else if (tempo >= 15 && tempo < 50){    //pai entre 15 e 50 anos
          g.fillRect(320, 40, 100, 100);
          g.drawImage(sprites[1].getSprite(0, 0, 32, 32), 320, 40, 100, 100, null);
        }
        else if (tempo >= 50 && tempo<90) {   //pai acima de 50 e vivo
          g.fillRect(320, 40, 100, 100);
          g.drawImage(sprites[2].getSprite(0, 0, 32, 32), 320, 40, 100, 100, null);
        }
        else {  //pai morto
          g.fillRect(320, 40, 100, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 320, 40, 100, 100, null);
        }
        desenharTempo(tempo, g, 360, 30); //chama o metodo para desenhar os anos do pai
        break; //fim do pai====================================================================================

      case "Filho 1": //filho 1================================================================================
        if (tempo >= 0 && tempo < 15) //filho 1 com menos de 15 anos
          g.drawImage(sprites[3].getSprite(0, 0, 32, 32), 120, 190, 100, 100, null);
        else if (tempo >= 15 && tempo < 50){ //filho 1 entre 15 e 50 anos
          g.fillRect(140, 190, 80, 100);
          g.drawImage(sprites[4].getSprite(0, 0, 32, 32), 120, 190, 100, 100, null);
        }
        else if (tempo >= 50 && tempo < 61){ //filho 1 acima de 50 anos e vivo
          g.fillRect(140, 190, 80, 100);
          g.drawImage(sprites[5].getSprite(0, 0, 32, 32), 120, 190, 100, 100, null);
        }
        else { //filho 1 morto
          g.fillRect(140, 190, 80, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 120, 190, 100, 100, null);
        }
        desenharTempo(tempo, g, 160, 180); //chama o metodo para desenhar os anos do filho 1
        break; //fim do filho 1================================================================================

      case "Filho 2": //filho 2================================================================================
        if (tempo >= 0 && tempo < 15) //filho 2 com menos de 15 anos
          g.drawImage(sprites[6].getSprite(0, 0, 32, 32), 320, 190, 100, 100, null);
        else if (tempo >= 15 && tempo < 50){ //filho 2 entre 15 e 50 anos
          g.fillRect(320, 190, 100, 100);
          g.drawImage(sprites[7].getSprite(0, 0, 32, 32), 320, 190, 100, 100, null);
        }
        else if (tempo >=50 && tempo<55) { //filho 2 com mais de 50 anos e vivo
          g.fillRect(320, 190, 100, 100);
          g.drawImage(sprites[8].getSprite(0, 0, 32, 32), 320, 190, 100, 100, null);
        }
        else { //filho 2 morto
          g.fillRect(320, 190, 100, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 320, 190, 100, 100, null);
        }
        desenharTempo(tempo, g, 360, 180); //chama o metodo para desenhar os anos de filho 2
        break; //fim do filho 2=================================================================================

      case "Filho 3": //filho 3=================================================================================
        if (tempo >= 0 && tempo < 15) //filho 3 com menos de 15 anos
          g.drawImage(sprites[9].getSprite(0, 0, 32, 32), 520, 190, 100, 100, null);
        else if (tempo >= 15 && tempo < 50){ //filho 3 entre 15 e 50 anos 
          g.fillRect(520, 190, 100, 100);
          g.drawImage(sprites[10].getSprite(0, 0, 32, 32), 520, 190, 100, 100, null);
        }
        else if (tempo >= 50 && tempo < 55) { //filho 3 com mais de 50 anos e vivo
          g.fillRect(520, 190, 100, 100);
          g.drawImage(sprites[11].getSprite(0, 0, 32, 32), 520, 190, 100, 100, null);
        }
        else { //filho 3 morto
          g.fillRect(540, 190, 80, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 520, 190, 100, 100, null);
        }
        desenharTempo(tempo, g, 560, 180); //chama o metodo para desenhar os anos do filho 3
        break; //fim do filho 3==================================================================================

      case "Neto 1": //neto 1====================================================================================
        if (tempo >= 0 && tempo < 15) //neto 1 com menos de 15 anos
          g.drawImage(sprites[12].getSprite(0, 0, 32, 32), 120, 330, 100, 100, null);
        else if (tempo >= 15 && tempo < 35){ //neto 1 com mais de 15 anos e vivo
          g.fillRect(140, 330, 80, 100);
          g.drawImage(sprites[13].getSprite(0, 0, 32, 32), 120, 330, 100, 100, null);
        }
        else { //neto 1 morto
          g.fillRect(140, 330, 80, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 120, 330, 100, 100, null);
        }
        desenharTempo(tempo, g, 160, 320); //chama o metodo para desenhar os anos do neto 1
        break; //fim do neto 1===================================================================================
        
      case "Neto 2": //neto 2====================================================================================
        if (tempo >= 0 && tempo < 15) //neto 2 com menos de 15 anos
          g.drawImage(sprites[14].getSprite(0, 0, 32, 32), 320, 330, 100, 100, null);
        else if (tempo >= 15 && tempo < 33){ //neto 2 com mais de 15 anos e vivo
          g.fillRect(320, 330, 100, 100);
          g.drawImage(sprites[15].getSprite(0, 0, 32, 32), 320, 330, 100, 100, null);
        }
        else { //neto 2 morto
          g.fillRect(320, 330, 100, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 320, 330, 100, 100, null);
        }
        desenharTempo(tempo, g, 360, 320); //chama o metodo para desenhar os anos do neto 2
        break; //fim do neto 2====================================================================================

      case "Bisneto": //bisnet0===================================================================================
        if (tempo >= 0 && tempo < 12) //bisneto ate os 11 anos
          g.drawImage(sprites[16].getSprite(0, 0, 32, 32), 120, 480, 100, 100, null);
        else { //bisneto morto
          g.fillRect(140, 480, 80, 100);
          g.drawImage(sprites[17].getSprite(0, 0, 32, 32), 120, 480, 100, 100, null);
        }
        desenharTempo(tempo, g, 160, 470); //chamar o metodo para desenhar os anos do bisneto
        break; //fim do bisneto===================================================================================
    }

    g.dispose(); //acaba com o objeto g tirando sua referencia
    bufferStrategy.show(); //torna o proximo buffer visivel
  }

  /* *********************
  * Metodo: inicializarSprites
  * Funcao: pega o arranjo de sprites criado no construtor e inicializa cada index com um path para a imagem especifica
  * Parametros: nenhum
  * Retorno: void
  ********************* */
  private void inicializarSprites(){
    sprites[0] = new SpriteSheet("res/pai_crianca.png");
    sprites[1] = new SpriteSheet("res/pai_adulto.png");
    sprites[2] = new SpriteSheet("res/pai_velho.png");
    sprites[3] = new SpriteSheet("res/filho_1_crianca.png");
    sprites[4] = new SpriteSheet("res/filho_1_adulto.png");
    sprites[5] = new SpriteSheet("res/filho_1_velho.png");
    sprites[6] = new SpriteSheet("res/filho_2_crianca.png");
    sprites[7] = new SpriteSheet("res/filho_2_adulto.png");
    sprites[8] = new SpriteSheet("res/filho_2_velho.png");
    sprites[9] = new SpriteSheet("res/filho_3_crianca.png");
    sprites[10] = new SpriteSheet("res/filho_3_adulto.png");
    sprites[11] = new SpriteSheet("res/filho_3_velho.png");
    sprites[12] = new SpriteSheet("res/neto_1_crianca.png");
    sprites[13] = new SpriteSheet("res/neto_1_adulto.png");
    sprites[14] = new SpriteSheet("res/neto_2_crianca.png");
    sprites[15] = new SpriteSheet("res/neto_2_adulto.png");
    sprites[16] = new SpriteSheet("res/bisneto_crianca.png");
    sprites[17] = new SpriteSheet("res/tumba.png");
  }

  /* *********************
  * Metodo: desenharTempo
  * Funcao: desenha o cronometro que marca os anos que aparecem em cima dos desenhos
  * Parametros: int tempo, Graphics g, int x, int y
  * Retorno: void
  ********************* */
  private void desenharTempo(int tempo, Graphics g, int x, int y){
    g.setColor(new Color(120, 150, 255));
    g.fillRect(x, y-20, 20, 20);
    g.setColor(Color.WHITE);
    g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    g.drawString(String.valueOf(tempo), x, y);    //desenha a String com o valor dos anos
  }
}
