package fiap.model;
/**Classe para objetos do tipo Registro Recrutador
 * @author Luis Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class RegistroRecrutador extends UsuarioRegistroGeral {

	private String nomeEmpresa;
	private String cargoRecrutador;

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCargoRecrutador() {
		return cargoRecrutador;
	}

	public void setCargoRecrutador(String cargoRecrutador) {
		this.cargoRecrutador = cargoRecrutador;
	}

}
