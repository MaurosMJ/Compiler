package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.MatteBorder;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class InterfacePrincipal extends JFrame {

	private JPanel contentPane;
	private String areaTransf = "";
	private Boolean ctrlIsPress = false;
	private String msg = "";
	private JTextArea mensagens = new JTextArea();

	private JTextArea txtLinhas = new JTextArea();
	private JTextArea codFonte = new JTextArea();
	private String codFonteSalvo = "";
	private JLabel lblStatus = new JLabel();
	private Boolean salvo = false;
	private String diretorio;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincipal frame = new InterfacePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfacePrincipal() {
		setTitle("Compilador");
		setMinimumSize(new Dimension(900, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(0);
		panel_1.setMinimumSize(new Dimension(150, 500));
		panel_1.setPreferredSize(new Dimension(150, 10));
		panel_1.setMaximumSize(new Dimension(150, 32767));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Novo [CTRL + N]");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/new.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Abrir [CTRL + O]");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/open.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar [CTRL + S]");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/save.png")));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Copiar [CTRL + C]");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaTransf = codFonte.getSelectedText();
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/copy.png")));
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Colar [CTRL + V]");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String part1 = codFonte.getText().substring(0, codFonte.getCaretPosition());
				String part2 = codFonte.getText().substring(codFonte.getCaretPosition(), codFonte.getText().length());
				codFonte.setText(part1 + areaTransf + part2);
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/paste.png")));
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Recortar [CTRL + X]");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaTransf = codFonte.getSelectedText();
				String part1 = codFonte.getText().substring(0, codFonte.getSelectionStart());
				String part2 = codFonte.getText().substring(codFonte.getSelectionEnd(), codFonte.getText().length());
				codFonte.setText(part1 + "" + part2);
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/cut.png")));
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Compilar [F7]");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacoes op = new operacoes();
				op.lineCount(codFonte.getText());
				Lexico lexico = new Lexico();
			//	System.out.println(op.linhaID(25));
				   lexico.setInput(codFonte.getText() );
				   //op.verificaComentario();
				   String msg1 = "LINHA       CLASSE                     LEXEMA\n";
				   String espaço = "";
				   int posicao =0;
				   int value = op.gettemChar();
				   value++;
				   int local =1;

				   
				   if(value == 10000) {
				   
				   try {
				   Token t = null;
				   while ( (t = lexico.nextToken()) != null ) {
					   posicao = t.getPosition();	
					   
					   if (op.decodeficar(t.getId()).equals("palavra reservada")){
						   espaço = "    ";
					   }
					   
					   if (op.decodeficar(t.getId()).equals("identificador")){
						   espaço = "               ";
					   }
					   
					   if (op.decodeficar(t.getId()).equals("símbolo especial")){
						   espaço = "      ";
					   }
					   if (op.decodeficar(t.getId()).equals("constante float")){
						   espaço = "           ";
					   }
					   if (op.decodeficar(t.getId()).equals("constante int")){
						   espaço = "              ";
					   }
					   if (op.decodeficar(t.getId()).equals("constante string")){
						   espaço = "        ";
					   }
					   					   
					 local = op.linha(posicao);
					 local++;
				     msg1 +=local+"               "+op.decodeficar(+t.getId())+espaço+ t.getLexeme()+"\n"; 
				     
				      
				   }
				  
				     msg1 += "programa compilado com sucesso";
				   }
				   catch (LexicalError ex ) {  // tratamento de erros
				     msg1 = "Erro na linha "+local+" - "+  ex.getMessage()+"\n";
				     
				   }} else {
					   msg1 = "Erro na linha "+value+" - char palavra inválida"; 
				   }
				  
				   mensagens.setText(msg1);
			
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/execute.png")));
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_6.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Equipe [F1]");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipe = "Vinicius Mueller Landi\n"
						+ "Victor Fernando Poplade\n"
						+ "Mauros Milach Junior";
				imprimir(equipe);
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setIcon(new ImageIcon(InterfacePrincipal.class.getResource("/view/images/team.png")));
		btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_7.setPreferredSize(new Dimension(142, 60));
		panel_1.add(btnNewButton_7);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.setMinimumSize(new Dimension(900, 25));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblStatus);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		codFonte.setFont(new Font("Monospaced", Font.PLAIN, 13));
		codFonte.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (!ctrlIsPress) 
					return;
				
				if (e.getWheelRotation() == -1) {
//					Subiu
					mudarFonte(+1);
				} else {
//					Desceu
					mudarFonte(-1);
				}
			}
		});
		codFonte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 17) {
					ctrlIsPress = false;
				}
				if (!codFonte.getText().equals(codFonteSalvo)) {
					salvo = false;
					return;
				}
				salvo = true;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 17) {
					ctrlIsPress = true;
				}
				if (ctrlIsPress && e.getKeyCode() != 17) {
					switch (e.getKeyCode()) {
//					N
					case 78:
						novo();
						break;
//					O
					case 79:
						abrir();
						break;
//					S
					case 83:
						salvar();
						break;
					}
					ctrlIsPress = false;
					return;
				}

				switch (e.getKeyCode()) {
//				F7
				case 118:
					String compilar = "Compilação de programas ainda não foi implementada";
					imprimir(compilar);
					break;
//				F1
				case 112:
					String equipe = "Vinicius Mueller Landi\n"
							+ "Victor Fernando Poplade\n"
							+ "Mauros Milach Junior";
					imprimir(equipe);
					break;
				}
			}
		});
		
		panel.add(codFonte, BorderLayout.CENTER);
		
		txtLinhas.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtLinhas.setBorder(new MatteBorder(0, 0, 0, 1, (Color) Color.LIGHT_GRAY));
		txtLinhas.setEnabled(false);
		txtLinhas.setEditable(false);
		txtLinhas.setPreferredSize(new Dimension(50, 22));
		String linhas = "";
		for (int i = 1; i <= 10000; i++) {
			linhas += i+"\n";
		}
		txtLinhas.setText(linhas);
		panel.add(txtLinhas, BorderLayout.WEST);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPane_1);
		mensagens.setDisabledTextColor(Color.BLACK);
		
		mensagens.setEditable(false);
		mensagens.setEnabled(false);
		scrollPane_1.setViewportView(mensagens);
		splitPane.setDividerLocation(450);
	}

	private void novo() {
//		if (!codFonte.getText().isBlank() && !salvo) {
			int opcao = JOptionPane.showConfirmDialog(null, "Criar um novo arquivo sem salvar suas alterações?", "Novo arquivo", JOptionPane.YES_NO_OPTION);
			if (opcao == 1)
				return;
//		}
		codFonte.setText("");
		lblStatus.setText("");
		mensagens.setText("");
		diretorio = null;
		salvo = false;
	}
	
	private void abrir() {
	    JFileChooser chooser = new JFileChooser();
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        try {
	        	Scanner scanner = new Scanner(chooser.getSelectedFile());
                while (scanner.hasNext()) {
                    codFonte.setText(codFonte.getText() + scanner.nextLine() + "\n");
                }
                scanner.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        atualizaDiretorio(chooser.getSelectedFile().getPath());
	    }
	}
	
	private void salvar() {
		File arquivo;
		if (diretorio != null) {
			arquivo = new File(diretorio);
		} else {
		    JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter(".txt", ".txt"));
		    if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
		    	return;
		    }
		    arquivo = chooser.getSelectedFile();
		}
        try {
            FileWriter fw = new FileWriter(arquivo + (arquivo.getName().endsWith(".txt") ? "" : ".txt"));
            fw.write(codFonte.getText());
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        atualizaDiretorio(arquivo.getPath());
	}
	
	public void imprimir(String texto) {
		msg += texto;
		mensagens.setText(msg);
	}
	
	private void atualizaDiretorio(String path) {
        diretorio = path;
        lblStatus.setText(path);
        codFonteSalvo = codFonte.getText();
        salvo = true;
	}
	
	private void mudarFonte(Integer num) {
		Font font = new Font("Monospaced", Font.PLAIN, codFonte.getFont().getSize()+num);
		codFonte.setFont(font);
		txtLinhas.setFont(font);
	}
}
