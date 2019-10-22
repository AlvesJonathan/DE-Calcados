/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorios;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Administrador
 */
public class DAORelatorios extends ConexaoMySql{
    
    
    public boolean gerarRelatorioCliente() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioProdutos() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM produtos;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    public boolean gerarRelatorioFornecedores() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM fornecedores;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioFornecedores.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("select VENDAS.CODIGO as VENDASCODIGO\n"
                    + "     , VENDAS.CLIENTES_CODIGO as VENDASCLIENTES_CODIGO\n"
                    + "     , VENDAS.DATA_VENDA as VENDASDATA_VENDA\n"
                    + "     , VENDAS.VALOR_TOTAL as VENDASVALOR_TOTAL\n"
                    + "     , VENDAS.DESCONTO as VENDASDESCONTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO as VENDAS_PRODUTOCODIGO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_PRODUTO as VENDAS_PRODUTOCODIGO_PRODUTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_VENDA as VENDAS_PRODUTOCODIGO_VENDA\n"
                    + "     , VENDAS_PRODUTO.QUANTIDADE as VENDAS_PRODUTOQUANTIDADE\n"
                    + "     , PRODUTOS.CODIGO as PRODUTOSCODIGO\n"
                    + "     , PRODUTOS.NOME as PRODUTOSNOME\n"
                    + "     , PRODUTOS.VALOR as PRODUTOSVALOR\n"
                    + "     , CLIENTES.CODIGO as CLIENTESCODIGO\n"
                    + "     , CLIENTES.NOME as CLIENTESNOME\n"
                    + "     , CLIENTES.ENDERECO as CLIENTESENDERECO\n"
                    + "     , CLIENTES.BAIRRO as CLIENTESBAIRRO\n"
                    + "     , CLIENTES.CIDADE as CLIENTESCIDADE\n"
                    + "     , CLIENTES.UF as CLIENTESUF\n"
                    + "     , CLIENTES.CEP as CLIENTESCEP\n"
                    + "     , CLIENTES.TELEFONE as CLIENTESTELEFONE\n"
                    + "from VENDAS inner join VENDAS_PRODUTO on VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA\n"
                    + "inner join CLIENTES on VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO\n"
                    + "inner join PRODUTOS on VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("select VENDAS.CODIGO as VENDASCODIGO\n"
                    + "     , VENDAS.CLIENTES_CODIGO as VENDASCLIENTES_CODIGO\n"
                    + "     , VENDAS.DATA_VENDA as VENDASDATA_VENDA\n"
                    + "     , VENDAS.VALOR_TOTAL as VENDASVALOR_TOTAL\n"
                    + "     , VENDAS.DESCONTO as VENDASDESCONTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO as VENDAS_PRODUTOCODIGO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_PRODUTO as VENDAS_PRODUTOCODIGO_PRODUTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_VENDA as VENDAS_PRODUTOCODIGO_VENDA\n"
                    + "     , VENDAS_PRODUTO.QUANTIDADE as VENDAS_PRODUTOQUANTIDADE\n"
                    + "     , PRODUTOS.CODIGO as PRODUTOSCODIGO\n"
                    + "     , PRODUTOS.NOME as PRODUTOSNOME\n"
                    + "     , PRODUTOS.VALOR as PRODUTOSVALOR\n"
                    + "     , CLIENTES.CODIGO as CLIENTESCODIGO\n"
                    + "     , CLIENTES.NOME as CLIENTESNOME\n"
                    + "     , CLIENTES.ENDERECO as CLIENTESENDERECO\n"
                    + "     , CLIENTES.BAIRRO as CLIENTESBAIRRO\n"
                    + "     , CLIENTES.CIDADE as CLIENTESCIDADE\n"
                    + "     , CLIENTES.UF as CLIENTESUF\n"
                    + "     , CLIENTES.CEP as CLIENTESCEP\n"
                    + "     , CLIENTES.TELEFONE as CLIENTESTELEFONE\n"
                    + "from VENDAS inner join VENDAS_PRODUTO on VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA\n"
                    + "inner join CLIENTES on VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO\n"
                    + "inner join PRODUTOS on VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPDV.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    
    public boolean gerarRelatorioContaReceber(int pCodigo) {
        try {
              this.conectar();
             this.executarSQL("SELECT * FROM clientes INNER JOIN contas ON clientes.CODIGO = contas.FK_CODIGO_PESSOA WHERE pk_codigo = '" + pCodigo + "';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM fornecedores INNER JOIN contas ON fornecedores.CODIGO = contas.FK_CODIGO_PESSOA WHERE pk_codigo = '"+pCodigo+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaPagar.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVendaData(Date pData) {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes INNER JOIN vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO INNER JOIN tipo_pagamento ON vendas.TIPO_PAGAMENTO = tipo_pagamento.pk_codigo WHERE data_venda = '"+pData+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVendaCliente(String pCliente) {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes INNER JOIN vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO INNER JOIN tipo_pagamento ON vendas.TIPO_PAGAMENTO = tipo_pagamento.pk_codigo WHERE nome = '"+pCliente+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    
}
