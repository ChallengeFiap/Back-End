package fiap.model;
/**Interface para os objetos de todas as classes de Registro Candidato e Recrutador
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */

public interface IDAOR {
	
public String inserirRegistro(Object obj);

public String inserirUsuario(Object obj);
	
public String alterarRegistro(Object obj);

public String alterarUsuario(Object obj);
	
public String excluirRegistro(Object obj);

public String excluirUsuario(Object obj);
	

}
