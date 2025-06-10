// Pacote onde está localizada a classe
package com.mycompany.lojadesapatos;

// Importações de bibliotecas gráficas e utilitárias
import java.awt.*; // Para layouts, fontes, cores etc.
import java.awt.event.*; // Para eventos como clique de botão
import java.io.IOException;
import javax.imageio.ImageIO; // Para carregar imagens
import javax.swing.*; // Componentes de interface gráfica como JButton, JFrame etc.

// Classe principal do menu da loja, estende JFrame (janela)
public class MenuSapatos extends JFrame {

    // Botões principais do menu
    private JButton bCadSapato, bCadEstoque, bConSapato, bConEstoque, bCadVenda, bSair;
    // Novos botões adicionados
    private JButton bRelatorioVendas, bSobre;

    // Instâncias das classes de apoio
    private Sapatos sapato = new Sapatos();
    private Estoque estoque = new Estoque(); 
    private EntradaSaidaDados io = new EntradaSaidaDados();

    // Classe interna personalizada para botões de menu
    private class BotaoMenu extends JButton {
        public BotaoMenu(String text, String iconPath) {
            super(text);
            try {
                // Tenta carregar um ícone para o botão
                Image img = ImageIO.read(getClass().getResourceAsStream("icons/" + iconPath));
                if (img != null) {
                    setIcon(new ImageIcon(img.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
                }
            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                System.err.println("Erro ao carregar ícone: " + iconPath + " - " + e.getMessage());
            }

            // Estilo visual do botão
            setHorizontalAlignment(JButton.LEFT);
            setIconTextGap(15); // Espaço entre ícone e texto
            setFont(new Font("Segoe UI", Font.PLAIN, 15)); 
            setPreferredSize(new Dimension(280, 45)); 
            setBackground(new Color(225, 225, 225));
            setFocusPainted(false); // Remove o contorno ao focar
        }
    }

    // Construtor da classe (configura o tema Nimbus, se disponível)
    public MenuSapatos() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Nimbus LookAndFeel não encontrado, usando padrão. " + e.getMessage());
        }
    }

    // Método público para iniciar a interface do menu
    public void executarSapato() {
        executarMenuPrincipal();
    }

    // Define o ícone da janela
    private void configurarIconeJanela() {
        try {
            Image icon = ImageIO.read(getClass().getResourceAsStream("icons/store_icon.png"));
            if (icon != null) {
                setIconImage(icon);
            }
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            System.err.println("Erro ao carregar ícone da janela: icons/store_icon.png - " + e.getMessage());
        }
    }

    // Método que monta toda a interface do menu principal
    private void executarMenuPrincipal() {
        setTitle("Gestão Loja de Sapatos Pro");
        configurarIconeJanela(); // Define ícone da janela

        Container tela = getContentPane();
        tela.setLayout(new BorderLayout(15, 15)); // Layout com espaçamento
        tela.setBackground(new Color(230, 230, 250)); // Cor de fundo (lavanda claro)

        // Painel do título na parte superior
        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelTitulo.setBackground(new Color(75, 0, 130)); // Cor índigo
        JLabel lblTitulo = new JLabel("Menu Principal - Loja de Sapatos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        painelTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        tela.add(painelTitulo, BorderLayout.NORTH);

        // Painel onde ficam os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(0, 1, 10, 10)); // Uma coluna, espaçamento entre botões
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        painelBotoes.setBackground(tela.getBackground());

        // Instanciando os botões com ícones
        bCadSapato = new BotaoMenu("Cadastrar Sapato", "add_shoe.png");
        bCadEstoque = new BotaoMenu("Cadastrar Estoque", "stock.png");
        bConSapato = new BotaoMenu("Consultar Sapato", "search_shoe.png");
        bConEstoque = new BotaoMenu("Consultar Estoque", "search_stock.png");
        bCadVenda = new BotaoMenu("Registrar Venda", "cart.png");
        bRelatorioVendas = new BotaoMenu("Relatório de Vendas", "report.png");
        bSobre = new BotaoMenu("Sobre o Sistema", "info.png");
        bSair = new BotaoMenu("Sair do Sistema", "exit.png");

        // Destaque visual para o botão de sair
        bSair.setBackground(new Color(255, 99, 71)); // Cor tomate
        bSair.setForeground(Color.WHITE);
        bSair.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Adiciona o mesmo listener para todos os botões
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avaliarOpcaoEscolhida(e); // Redireciona para o método de tratamento
            }
        };

        // Associando os botões ao listener
        bCadSapato.addActionListener(listener);
        bCadEstoque.addActionListener(listener);
        bConSapato.addActionListener(listener);
        bConEstoque.addActionListener(listener);
        bCadVenda.addActionListener(listener);
        bRelatorioVendas.addActionListener(listener);
        bSobre.addActionListener(listener);
        bSair.addActionListener(listener);

        // Adicionando os botões ao painel
        painelBotoes.add(bCadSapato);
        painelBotoes.add(bCadEstoque);
        painelBotoes.add(bConSapato);
        painelBotoes.add(bConEstoque);
        painelBotoes.add(bCadVenda);
        painelBotoes.add(bRelatorioVendas);
        painelBotoes.add(bSobre);
        painelBotoes.add(bSair);

        // Adiciona o painel central com os botões à tela
        tela.add(painelBotoes, BorderLayout.CENTER);

        // Configurações finais da janela
        pack(); // Ajusta a janela ao tamanho dos componentes
        setMinimumSize(new Dimension(400, 600)); // Tamanho mínimo
        setLocationRelativeTo(null); // Centraliza na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Exibe a janela
    }

    // Método que trata os eventos dos botões
    private void avaliarOpcaoEscolhida(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == bCadSapato) {
            // Cadastro de sapato
            String precoStr = io.entradaDados("Digite o preço do sapato:");
            if (precoStr == null) return;
            String descricao = io.entradaDados("Digite a descrição:");
            if (descricao == null) return;

            if (precoStr.trim().isEmpty() || descricao.trim().isEmpty()) {
                io.saidaDados("Preço e descrição não podem ser vazios.");
                return;
            }

            try {
                double preco = ConversorNumeros.stringparaDouble(precoStr);
                sapato.cadastraSapato(preco, descricao);
                io.saidaDados("Sapato cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                io.saidaDados("Erro: Preço inválido. Use ponto para decimais (ex: 49.99).");
            }

        } else if (origem == bCadEstoque) {
            // Cadastro de estoque
            String qtdStr = io.entradaDados("Digite a quantidade para o estoque:");
            if (qtdStr == null) return;

            if (qtdStr.trim().isEmpty()) {
                io.saidaDados("Quantidade não pode ser vazia.");
                return;
            }

            try {
                int qtd = ConversorNumeros.stringparaInt(qtdStr);
                if (qtd < 0) {
                    io.saidaDados("Quantidade não pode ser negativa.");
                    return;
                }
                estoque.cadastrarEstoque(qtd);
                io.saidaDados("Estoque cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                io.saidaDados("Erro: Quantidade inválida. Digite um número inteiro.");
            }

        } else if (origem == bConSapato) {
            // Consulta de sapatos
            io.saidaDados(sapato.consultaSapato());

        } else if (origem == bConEstoque) {
            // Consulta de estoque (campo estático)
            io.saidaDados("Quantidade no estoque: " + estoque.consultarEstoque());

        } else if (origem == bCadVenda) {
            // Registrar venda
            Vender venda = new Vender();
            venda.venderSapato(sapato);

        } else if (origem == bRelatorioVendas) {
            // Placeholder para relatório (ainda não implementado)
            io.saidaDados("Relatório de Vendas (Simulado):\n\n" +
                           "- Esta funcionalidade exibiria um resumo das vendas.\n" +
                           "- Para um relatório real, a classe 'Vender' precisaria armazenar\n" +
                           "  um histórico de transações.\n\n" +
                           "(Funcionalidade em desenvolvimento)");

        } else if (origem == bSobre) {
            // Informações sobre o sistema
            io.saidaDados("Sistema de Loja de Sapatos Pro\n" +
                           "Versão: 2.0 (Menu Melhorado)\n" +
                           "Desenvolvido por: Vinícius Correia, Victor Hugo e Lucas Lewer\n\n" +
                           "Este sistema permite o cadastro de sapatos, \n" +
                           "gerenciamento de estoque e registro de vendas.");

        } else if (origem == bSair) {
            // Saída do sistema
            io.saidaDados("Saindo do sistema... Até logo!");
            System.exit(0);
        }
    }

    // Método main que permite testar essa interface diretamente
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuSapatos menu = new MenuSapatos();
                menu.executarSapato();
            }
        });
    }
}
