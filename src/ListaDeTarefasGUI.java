import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaDeTarefasGUI extends JFrame {
    private JPanel painel = new JPanel();
    private ArrayList<String> tarefas = new ArrayList<>();
    private DefaultListModel<String> lista;
    private JList<String> tarefasLista;
    private JTextField tarefaTextField;

    public ListaDeTarefasGUI() {
        setTitle("======================LISTA DE TAREFAS=========================");
        this.setSize(600, 400);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);

        lista = new DefaultListModel<>();
        tarefasLista = new JList<>(lista);
        JScrollPane scrollPane = new JScrollPane(tarefasLista);

        JPanel buttonPanel = new JPanel();
        JButton adicionarButton = new JButton("Adicionar Tarefa");
        JButton removerButton = new JButton("Remover Tarefa");
        tarefaTextField = new JTextField(20);

        buttonPanel.add(tarefaTextField);
        buttonPanel.add(adicionarButton);
        buttonPanel.add(removerButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaTarefa = tarefaTextField.getText();
                if (!novaTarefa.isEmpty()) {
                    adicionarTarefa(novaTarefa);
                    tarefaTextField.setText("");
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tarefasLista.getSelectedIndex();
                if (selectedIndex != -1) {
                    removerTarefa(selectedIndex);
                }
            }
        });
    }

    private void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
        lista.addElement(tarefa);
    }

    private void removerTarefa(int indice) {
        tarefas.remove(indice);
        lista.remove(indice);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaDeTarefasGUI app = new ListaDeTarefasGUI();
            app.setVisible(true);
        });
    }




}
