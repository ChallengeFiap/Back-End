package fiap.model;

import java.sql.*;

public class VisualizarPerfilDAO {
	
private Connection con;
	
	public VisualizarPerfilDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String trazerInformacoes (VisualizarPerfil visualizarPerfil) {
		String sql = "SELECT * FROM FROM T_CHALL_REGISTRO_GERAL WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, visualizarPerfil.getIdRegistroGeral());
			if(ps.executeUpdate() > 0) {
				return "Informacoes tragas com sucesso.";
			} else {
				return "Erro ao trazer informacoes";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
