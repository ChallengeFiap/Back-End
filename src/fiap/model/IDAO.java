package fiap.model;
/**Interface para os objetos de todas as classes DAO
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public interface IDAO {
	
	public String inserir(Object obj);
	
	public String alterar(Object obj);
	
	public String excluir(Object obj);
	

}