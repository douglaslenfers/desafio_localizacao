package br.com.desafiolocalizacao.main;

import br.com.desafiolocalizacao.obj.Funcionario;
import br.com.desafiolocalizacao.obj.Loja;
import java.util.List;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author L3nfers
 */
public class ListarLojas extends HttpServlet {

    public static List<Loja> listarLojas() {
        List<Funcionario> funcionarios = LerCSVFuncionarios.carregarFuncionarios();
        List<Loja> lojas = LerCSVLojas.carregarLojas();

        for (Funcionario funcionario : funcionarios) {
            double latitudeFuncionario = funcionario.getLatitude();
            double longitudeFuncionario = funcionario.getLongitude();

            for (Loja loja : lojas) {
                if (loja.getFuncionario() == null) {
                    double latitudeLoja = loja.getLatitude();
                    double longitudeLoja = loja.getLongitude();

                    double distanciaEntreDoisPontos = Haversine.distanciaEntreDoisPontos(latitudeFuncionario, longitudeFuncionario,
                            latitudeLoja, longitudeLoja);

                    if (distanciaEntreDoisPontos < 2) {
                        loja.setFuncionario(funcionario);
                    }
                }
            }
        }

        return lojas;
    }
}
