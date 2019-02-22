import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Pomoc_UI extends JFrame {
	
	private JPanel panel;
	private JButton button, buttonPomoc;
	private String filePath;
	private JLabel skladniki;
	private JComboBox<String> comboSkladniki1, 
							  comboSkladniki2, 
							  comboSkladniki3, 
							  comboSkladniki4, 
							  comboSkladniki5, 
							  comboSkladniki6, 
							  comboSkladniki7, 
							  comboSkladniki8, 
							  comboSkladniki9, 
							  comboSkladniki10;
	private JTextArea text;
	
	private Pomoc pomoc;
	
	public Pomoc_UI() {
		super("Pomocnik Kucharza");	
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		button = new JButton("Podaj lokacje pliku .pl");
		button.setBounds(235, 11, 160, 23);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PROLOG FILES", "pl");
				fc.setFileFilter(filter);
				fc.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Downloads"));
				int result = fc.showOpenDialog(panel);
				if (result == JFileChooser.APPROVE_OPTION) {
					filePath = fc.getSelectedFile().getAbsolutePath();
					filePath = filePath.replaceAll("\\\\", "/");
					pomoc = new Pomoc(filePath); 
					pomoc.initFilds();
					buttonPomoc.setEnabled(true);
					comboSkladniki1.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki2.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki3.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki4.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki5.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki6.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki7.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki8.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki9.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
					comboSkladniki10.setModel(new DefaultComboBoxModel(pomoc.slownikSkladniki.toArray()));
				}
			}
		});
		
		buttonPomoc = new JButton("Pomoc");
		buttonPomoc.setBounds(240, 200, 130, 25);
		buttonPomoc.setEnabled(false);
		panel.add(buttonPomoc);
		buttonPomoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.removeAll();
				String queryItemsListString = comboSkladniki1.getSelectedItem().toString() + ", " +
									 		  comboSkladniki2.getSelectedItem().toString() + ", " + 
									 		  comboSkladniki3.getSelectedItem().toString() + ", " + 
									 		  comboSkladniki4.getSelectedItem().toString() + ", " + 
									 		  comboSkladniki5.getSelectedItem().toString() + ", " +
											  comboSkladniki6.getSelectedItem().toString() + ", " +
											  comboSkladniki7.getSelectedItem().toString() + ", " +
											  comboSkladniki8.getSelectedItem().toString() + ", " +
											  comboSkladniki9.getSelectedItem().toString() + ", " +
											  comboSkladniki10.getSelectedItem().toString();
				text.setText(pomoc.help(queryItemsListString));
			}
		});
		
		
		skladniki = new JLabel("Skladniki jakie mamy");
		skladniki.setHorizontalAlignment(SwingConstants.CENTER);
		skladniki.setBounds(10, 50, 120, 15);
		panel.add(skladniki);
				
		comboSkladniki1 = new JComboBox<String>();
		comboSkladniki1.setBounds(10, 65, 180, 20);
		panel.add(comboSkladniki1);
		
		comboSkladniki2 = new JComboBox<String>();
		comboSkladniki2.setBounds(10, 85, 180, 20);
		panel.add(comboSkladniki2);
		
		comboSkladniki3 = new JComboBox<String>();
		comboSkladniki3.setBounds(10, 105, 180, 20);
		panel.add(comboSkladniki3);
		
		comboSkladniki4 = new JComboBox<String>();
		comboSkladniki4.setBounds(10, 125, 180, 20);
		panel.add(comboSkladniki4);
		
		comboSkladniki5 = new JComboBox<String>();
		comboSkladniki5.setBounds(10, 145, 180, 20);
		panel.add(comboSkladniki5);
		
		comboSkladniki6 = new JComboBox<String>();
		comboSkladniki6.setBounds(200, 65, 180, 20);
		panel.add(comboSkladniki6);
		
		comboSkladniki7 = new JComboBox<String>();
		comboSkladniki7.setBounds(200, 85, 180, 20);
		panel.add(comboSkladniki7);

		comboSkladniki8 = new JComboBox<String>();
		comboSkladniki8.setBounds(200, 105, 180, 20);
		panel.add(comboSkladniki8);
		
		comboSkladniki9 = new JComboBox<String>();
		comboSkladniki9.setBounds(200, 125, 180, 20);
		panel.add(comboSkladniki9);
		
		comboSkladniki10 = new JComboBox<String>();
		comboSkladniki10.setBounds(200, 145, 180, 20);
		panel.add(comboSkladniki10);
		
		text = new JTextArea();
		text.setBounds(10, 270, 565, 190);
		text.setLineWrap(true);
		panel.add(text);

		setVisible(true);
	}
}
