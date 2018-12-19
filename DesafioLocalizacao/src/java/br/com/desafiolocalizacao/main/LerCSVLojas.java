package br.com.desafiolocalizacao.main;

import br.com.desafiolocalizacao.obj.Loja;
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
public class LerCSVLojas {

    public static List<Loja> carregarLojas() {
        List<Loja> lojas = new ArrayList();

        final String arquivoCSV = "C:\\Users\\L3nfers\\Downloads\\lojas.csv";

        String linha;
        String divisor = ",";
        int contador = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "UTF-8"))) {
            while ((linha = bufferedReader.readLine()) != null) {
                if (contador != 0) {
                    String[] dadosLoja = linha.split(divisor);
                    String nomeLoja = dadosLoja[0];
                    double latitudeLoja = Double.parseDouble(dadosLoja[1]);
                    double longitudeLoja = Double.parseDouble(dadosLoja[2]);

                    Loja loja = new Loja(contador, nomeLoja, latitudeLoja, longitudeLoja);
                    lojas.add(loja);
                }
                contador++;
            }
        } catch (IOException e) {
        }

        return lojas;
    }
}
