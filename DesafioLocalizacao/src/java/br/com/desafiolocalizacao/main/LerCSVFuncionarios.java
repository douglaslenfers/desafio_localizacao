package br.com.desafiolocalizacao.main;

import br.com.desafiolocalizacao.obj.Funcionario;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L3nfers
 */
public class LerCSVFuncionarios {

    public static List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList();

        final String arquivoCSV = "C:\\Users\\L3nfers\\Downloads\\funcionarios.csv";

        String linha;
        String divisor = ",";
        int contador = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "UTF-8"))) {
            while ((linha = bufferedReader.readLine()) != null) {
                if (contador != 0) {
                    String[] dadosFuncionario = linha.split(divisor);
                    String nomeFuncionario = dadosFuncionario[0];
                    double latitudeFuncionario = Double.parseDouble(dadosFuncionario[1]);
                    double longitudeFuncionario = Double.parseDouble(dadosFuncionario[2]);

                    Funcionario funcionario = new Funcionario(contador, nomeFuncionario, latitudeFuncionario, longitudeFuncionario);
                    funcionarios.add(funcionario);
                }
                contador++;
            }
        } catch (IOException e) {
        }

        return funcionarios;
    }
}
