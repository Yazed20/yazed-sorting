package javaapplication2;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Main extends JFrame
{
    private class RBtnI extends JRadioButton
    {
        public int Index1;
        RBtnI(String Name,int Index)
        {
            super(Name);
            this.Index1=Index;
        }
    }
    private JPanel Left=new JPanel(),Right=new JPanel(),
            Algorithms = new JPanel(),Random = new JPanel(),
            Operations= new JPanel(),RandP=new JPanel(),
            RNPnl=new JPanel(),RSPnl=new JPanel(),LSPnl=new JPanel(),RSP2=new JPanel();
    private JButton AddBtn=new JButton("Add"),UP1=new JButton("Up"),Down1=new JButton("Down"),
            Generate1 = new JButton("Generate"),Clear1 = new JButton("Clear"),
            Remove1=new JButton("Remove"),Sort1= new JButton("Sort");
    private RBtnI[] RBtns = new RBtnI[4];
    private JCheckBox CBox = new JCheckBox("Restrict to integers");
    private JTextField AddText = new JTextField(),GenText=new JTextField();
    private DefaultListModel DLMList1 = new DefaultListModel();
    private JList List1 = new JList(DLMList1);
    private JScrollPane ScrollP1 = new JScrollPane(List1);
    private ButtonGroup Grp1 = new ButtonGroup();
    private JLabel Lbl1 = new JLabel("Count ");
    private Random Rand1=new Random();
    private int Index=0,SelectedBtn=0;
    Main()
    {
        super();
        setBounds(300,200,800,400);
        setMinimumSize(new Dimension(800,400));
        setTitle("Sorting Algorithms");
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(3);
        LBtns();
        RBtns();
        LPnls();
        RPnls();
        setVisible(true);
    }
    private void LPnls()
    {
        Left.setLayout(new BorderLayout(0,5));
        //Left.setBorder(new TitledBorder("List Panel"));
        AlgBtn();
        Algorithms.setLayout(new GridLayout(5,1));
        Algorithms.setBorder(new TitledBorder("Algorithms"));
        Random.setBorder(new TitledBorder("Radom Input"));
        Random.setLayout(new GridLayout(2,1));
        Operations.setBorder(new TitledBorder("Operations"));
        Operations.setLayout(new GridLayout(2,1));
        RandP.setLayout(new BorderLayout(5,0));
        RandP.add(Lbl1,BorderLayout.WEST);
        RandP.add(GenText,BorderLayout.CENTER);
        Random.add(RandP);
        Random.add(Generate1);
        Operations.add(Sort1);
        Operations.add(Clear1);
        LSPnl.setLayout(new GridLayout(1,2));
        LSPnl.add(Random);
        LSPnl.add(Operations);
        LSPnl.setPreferredSize(new Dimension(400,100));
        Left.add(Algorithms,BorderLayout.CENTER);
        Left.add(LSPnl,BorderLayout.SOUTH);
        add(Left);
    }
    private void RPnls()
    {
        Right.setLayout(new BorderLayout(0,0));
        Right.setBorder(new TitledBorder("List Panel"));
        RNPnl.setLayout(new BorderLayout(0,0));
        RNPnl.add(AddText,BorderLayout.CENTER);
        RNPnl.add(AddBtn,BorderLayout.EAST);
        RSPnl.setLayout(new GridLayout(1,2));
        RSP2.setLayout(new FlowLayout(0,0,0));
        RSP2.add(UP1);
        RSP2.add(Down1);
        RSPnl.add(RSP2);
        RSPnl.add(Remove1);
        Right.add(RNPnl,BorderLayout.NORTH);
        Right.add(ScrollP1,BorderLayout.CENTER);
        Right.add(RSPnl,BorderLayout.SOUTH);
        add(Right);
    }
    private void AlgBtn()
    {
        for(int i=0;i<RBtns.length;i++)
        {
            /*RBtns[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    //SelectedBtn=this.Index1;
                }
            });*/
            switch(i)
            {
                case 0:
                    RBtns[i]=new RBtnI("Bubble Sort",0);
                    break;
                case 1:
                    RBtns[i]=new RBtnI("Selection Sort",1);
                    break;
                case 2:
                    RBtns[i]=new RBtnI("Quick Sort",2);
                    break;
                case 3:
                    RBtns[i]=new RBtnI("Heap Sort",3);
                    break;    
            }
            Grp1.add(RBtns[i]);
            Algorithms.add(RBtns[i]);
            Algorithms.add(CBox);
        }
    }
    private void LBtns()
    {
        Generate1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(GenText.getText()!=""&&GenText.getText()!=null)
                {
                    int Lim1=Integer.parseInt(GenText.getText());
                    for(int i=0;i<Lim1;i++)
                    {
                        DLMList1.add(Index++,CBox.isSelected()?Rand1.nextInt(1000000):
                            Rand1.nextDouble()*14);
                    }
                }
            }
        });
        Clear1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DLMList1.removeAllElements();
                Index=0;
            }
            
        });
        Sort1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(Index>1)
                {
                    //switch();
                }
            }
        });
    }
    private void RBtns()
    {
        /*List1.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });*/
        AddBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(AddText.getText()!=""&&AddText.getText()!=null)
                    DLMList1.add(Index++,Integer.parseInt(AddText.getText()));
            }

        });
        UP1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!List1.isSelectionEmpty())
                {
                    int SS1=List1.getSelectedIndex();
                    if(SS1>0)
                    {
                        Object Temp=DLMList1.get(SS1-1);
                        DLMList1.set(SS1-1,DLMList1.get(SS1));
                        DLMList1.set(SS1,Temp);
                    }
                    List1.setSelectedIndex(SS1-1);
                }
            }
            
        });
        Down1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!List1.isSelectionEmpty())
                {
                    int SS1=List1.getSelectedIndex();
                    if(SS1<DLMList1.size()-1)
                    {
                        Object Temp=DLMList1.get(SS1+1);
                        DLMList1.set(SS1+1,DLMList1.get(SS1));
                        DLMList1.set(SS1,Temp);
                    }
                    List1.setSelectedIndex(SS1+1);
                }
            }
        });
        Remove1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!List1.isSelectionEmpty())
                    DLMList1.remove(List1.getSelectedIndex());
                Index--;
            }
            
        });
        ;
    }
    public static void main(String[] args)
    {
        new Main();
    }

}