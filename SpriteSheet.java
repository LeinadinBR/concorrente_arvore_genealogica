import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor: Daniel Nogueira
Matrícula: 201911910
Inicio...: 26 de Marco de 2021
Alteracao: 27 de Marco de 2021
Nome.....: SpriteSheet
Funcao...: Funcao para carregar imagens para o programa
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class SpriteSheet {
	private BufferedImage spriteSheet;    //objeto de BufferedImagem que carrega um arquivo de imagem
	
  /* *********************
  * Metodo: SpriteSheet (construtor)
  * Funcao: constroi um objeto SpriteSheet lendo a String path atraves do metodo read() de ImageIO 
  * Parametros: String path
  ********************* */
	public SpriteSheet(String path) {
		try {
			spriteSheet = ImageIO.read(getClass().getResource(path));
		}
    catch(IOException e){}  //Ocorre caso o arquivo nao seja encontrado
	}

  /* *********************
  * Metodo: getSprite
  * Funcao: retorna uma sub-imagem da imagem carregada pelo objeto de acordo com os parametros
  * Parametros: int x, int y, int largura, int altura
  * Retorno: BufferedImage
  ********************* */
	public BufferedImage getSprite(int x , int y , int largura , int altura) {
		return spriteSheet.getSubimage(x, y, largura, altura);
	}
}