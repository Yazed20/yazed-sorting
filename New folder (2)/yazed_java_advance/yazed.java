/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazed_main;

/**
 *
 * @author yazed
 */
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class yazed extends JFrame {
//Creating panels and buttons
     JPanel Left = new JPanel(), Right = new JPanel(),
             
            Algorithms = new JPanel(), Random = new JPanel(),
            Operations = new JPanel(), RandP = new JPanel(),
            RightNorthPanel = new JPanel(),
            RightSouthPanel = new JPanel(),
            LeftSouthPanel = new JPanel(),
            RightSouthPanel2 = new JPanel();
    
    
    JButton AddBtn = new JButton("Add"),
            UP = new JButton("Up"),
            Down = new JButton("Down"),
            Generate = new JButton("Generate"),
            Clear = new JButton("Clear"),
            Remove = new JButton("Remove"),
            Sort = new JButton("Sort");
    JRadioButton[] RBtns = new JRadioButton[4];
    
    JCheckBox tointeger = new JCheckBox("Restrict to integers");
    
    JTextField AddText = new JTextField(), GenText = new JTextField();
    
    DefaultListModel<Double> DLMList1 = new DefaultListModel();
    
    
    JList<Double> List1 = new JList(DLMList1);
    
    
    JScrollPane ScrollP1 = new JScrollPane(List1);
    
    ButtonGroup Grp1 = new ButtonGroup();
    JLabel Lbl1 = new JLabel("Count ");
    Random Rand1 = new Random();
    int Index = 0, SelectedBtn = 0;

    
    
    
    yazed() {
//yazed.main
        setBounds(300, 200, 800, 400);
        setMinimumSize(new Dimension(800, 400));
        setTitle("Sorting Algorithms Coded BY yazed_hasan -_^ ");
        setBackground(Color.black);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(3);
        Left_buttons();
        Right_buttons();
        Left_panel();
        Right_panel();
        setVisible(true);
    }

    
    
    //left panel customize
    private void Left_panel() {
        Left.setLayout(new BorderLayout(0, 5));
        //Left.setBorder(new TitledBorder("List Panel"));
        Alogorithm_Buttons();
        Algorithms.setLayout(new GridLayout(5, 1));
        Algorithms.setBorder(new TitledBorder("Algorithms"));
        Algorithms.setBackground(new Color(153, 255, 204));

        Random.setBorder(new TitledBorder("Radom Input"));
        Random.setLayout(new GridLayout(2, 1));

        Operations.setBorder(new TitledBorder("Operations"));
        Operations.setLayout(new GridLayout(1, 2));

        RandP.setLayout(new BorderLayout(5, 0));
        RandP.add(Lbl1, BorderLayout.WEST);
        RandP.add(GenText, BorderLayout.CENTER);

        Random.add(RandP);
        Random.add(Generate);

        Operations.add(Sort);

        Sort.setForeground(new Color(51, 51, 255));

        Operations.add(Clear);

        LeftSouthPanel.setLayout(new GridLayout(1, 2));
        LeftSouthPanel.add(Random);
        LeftSouthPanel.add(Operations);
        LeftSouthPanel.setPreferredSize(new Dimension(400, 100));
        Left.add(Algorithms, BorderLayout.CENTER);
        Left.add(LeftSouthPanel, BorderLayout.SOUTH);
        add(Left);
    }
    
    
    
//right panel 

    private void Right_panel() {
        Right.setLayout(new BorderLayout(0, 0));
        Right.setBorder(new TitledBorder("List Panel"));
        Right.setBackground(new Color(153, 204, 255));

        RightNorthPanel.setLayout(new BorderLayout(0, 0));
        RightNorthPanel.add(AddText, BorderLayout.CENTER);
        RightNorthPanel.add(AddBtn, BorderLayout.EAST);
        RightSouthPanel.setLayout(new GridLayout(1, 2));
        RightSouthPanel2.setLayout(new FlowLayout(0, 0, 0));
        RightSouthPanel2.add(UP);
        RightSouthPanel2.add(Down);
        RightSouthPanel.add(RightSouthPanel2);
        RightSouthPanel.add(Remove);
        Right.add(RightNorthPanel, BorderLayout.NORTH);
        Right.add(ScrollP1, BorderLayout.CENTER);
        Right.add(RightSouthPanel, BorderLayout.SOUTH);
        add(Right);
    }

    private void Alogorithm_Buttons() {
        for (int i = 0; i < RBtns.length; i++) {
            // creating radio buttons case statemnet
            switch (i) {
                case 0:
                    RBtns[i] = new JRadioButton("Bubble Sort");
                    break;
                case 1:
                    RBtns[i] = new JRadioButton("Selection Sort");
                    break;
                case 2:
                    RBtns[i] = new JRadioButton("Quick Sort");
                    break;
                case 3:
                    RBtns[i] = new JRadioButton("Heap Sort");
                    break;
            }
            Grp1.add(RBtns[i]);
            Algorithms.add(RBtns[i]);
            Algorithms.add(tointeger);
        }
    }

    private void Left_buttons() {
        Generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for text fe
                try {
                    if (GenText.getText() != null && GenText.getText() != "") {
                        int Lim1 = Integer.parseInt(GenText.getText());
                        for (int i = 0; i < Lim1; i++) {
                            DLMList1.add(Index++, tointeger.isSelected() ? Rand1.nextInt(1000000)
                                    : Rand1.nextDouble() * 14);
                        }
                    }
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, "Enter Number!");
                }
            }
        });
         // Action for Clear button
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Index >= 1) {
                    DLMList1.removeAllElements();
                    Index = 0;
                    
                } else {
                    JOptionPane.showMessageDialog(null, "its already clear :P");

                }

            }

        });
        // adding Listener for groub button using case statment 
        Sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Index > 1) {
                    for (int i = 0; i < RBtns.length; i++) {
                        if (RBtns[i].isSelected()) {
                            switch (i) {
                                case 0:

                                    SortingAlgorithms.
                                            BubbleSort(DLMList1);

                                case 1:

                                    SortingAlgorithms.
                                            SelectionSort(DLMList1);

                                case 2:
                                    SortingAlgorithms.
                                            QuickSort(DLMList1, 0, DLMList1.size() - 1);

                                case 3:
                                    SortingAlgorithms.
                                            HeapSort(DLMList1);

                            }
                        }
                    }
                }
            }
        });
    }

    private void Right_buttons() {
        List1.addListSelectionListener(new ListSelectionListener() {
            @Override
            // ADD actions 
            public void valueChanged(ListSelectionEvent e) {
                if (!List1.isSelectionEmpty()) {
                    UP.setEnabled(true);
                    Down.setEnabled(true);
                    Remove.setEnabled(true);
                } else {
                    UP.setEnabled(false);
                    Down.setEnabled(false);
                    Remove.setEnabled(false);
                }
            }
        });
        AddBtn.addActionListener(new ActionListener() {
            @Override
            // ACTIONS for ADD button
            public void actionPerformed(ActionEvent e) {
                if (AddText.getText() != "" && AddText.getText() != null) {
                    DLMList1.add(Index++, 0.0 + Integer.parseInt(AddText.getText()));
                }

            }

        });
        
        // ACTIONS for up button
        UP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!List1.isSelectionEmpty()) {
                    int selectedindex = List1.getSelectedIndex();
                    if (selectedindex > 0) {
                        Double Temp = DLMList1.get(selectedindex - 1);
                        DLMList1.set(selectedindex - 1, DLMList1.get(selectedindex));
                        DLMList1.set(selectedindex, Temp);
                    }
                    List1.setSelectedIndex(selectedindex - 1);
                }
            }

        });
        UP.setEnabled(false);
        Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!List1.isSelectionEmpty()) {
                    int SS1 = List1.getSelectedIndex();
                    if (SS1 < DLMList1.size() - 1) {
                        Double Temp = DLMList1.get(SS1 + 1);
                        DLMList1.set(SS1 + 1, DLMList1.get(SS1));
                        DLMList1.set(SS1, Temp);
                    }
                    List1.setSelectedIndex(SS1 + 1);
                }
            }
        });
        Down.setEnabled(false);
          // ACTIONS for remove button
        Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!List1.isSelectionEmpty()) {
                    DLMList1.remove(List1.getSelectedIndex());
                    Index--;
                } else {

                    JOptionPane.showMessageDialog(null, "its Clear :P");

                }

            }

        });
        Remove.setEnabled(false);
    }

    public static void main(String[] args) {
        new Main(); // calling main yazed_
        
    }

}
