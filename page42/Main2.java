package page42;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import java.util.ArrayList;
import page51.Main_51;
import page52.Main_52;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Main2 {

    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination;

    public static String Firstname;
    public static String Lastname;
    public static String busID;
    public static String time;
    public static int price;

    public static String phonenumber;
    public static String username;

    public static JFrame window;
    public static String selectedValue;
    public static JComboBox<String> entry0;
    public static ArrayList<String> myList = new ArrayList<String>();

    public static void setVisiblebig(Date selectedDate, String selectedRideLocation, String selectedDestination,String time,
     String Firstname, String Lastname,String busID , int price , String phone , String user) {
        Main2.selectedDate = selectedDate;
        Main2.selectedRideLocation = selectedRideLocation;
        Main2.selectedDestination = selectedDestination;
        Main2.Firstname = Firstname;
        Main2.Lastname = Lastname;
        Main2.time=time;
        Main2.busID = busID;
        Main2.price=price;
        Main2.phonenumber=phone;
        Main2.username=user;

        if (window == null) {
            createAndShowGUI();
        }
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        window = new JFrame();
        window.setSize(900, 551);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImg = new ImageIcon(Main2.class.getResource("background.png"));
                g.drawImage(backgroundImg.getImage(), -15, -20, this);
            }
        };
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        canvas.setBounds(0, 0, 900, 551);
        window.add(canvas);

        JLabel errorMessage = new JLabel("");
        errorMessage.setForeground(Color.decode("#FFAB15"));
        errorMessage.setFont(new Font("cambria", Font.BOLD, 15));
        errorMessage.setBounds(558, 440, 400, 40);
        canvas.add(errorMessage);

        JLabel label_from = new JLabel(selectedRideLocation);
        label_from.setBounds(145,59,200,20 );
        label_from.setFont(new Font("Cairo", Font.BOLD, 21));
        label_from.setForeground(Color.WHITE);
        canvas.add(label_from);

        JLabel label_to = new JLabel(selectedDestination);
        label_to.setBounds(135,105,200,20 );
        label_to.setFont(new Font("Cairo", Font.BOLD, 21));
        label_to.setForeground(Color.WHITE);
        canvas.add(label_to);

        JLabel label_busid = new JLabel("#"+busID);
        label_busid.setBounds(700,75,100,39 );
        label_busid.setFont(new Font("Cairo", Font.BOLD, 21));
        label_busid.setForeground(Color.WHITE);
        canvas.add(label_busid);
        
        JLabel label_time = new JLabel(time);
        label_time.setBounds(490,48,100,39 );
        label_time.setFont(new Font("Cairo", Font.BOLD, 21));
        label_time.setForeground(Color.WHITE);
        canvas.add(label_time);
        
        JLabel label_price = new JLabel(price+"LE");
        label_price.setBounds(490,97, 100, 39 );
        label_price.setFont(new Font("Cairo", Font.BOLD, 21));
        label_price.setForeground(Color.WHITE);
        canvas.add(label_price);


        ImageIcon img0 = new ImageIcon(Main2.class.getResource("img0.png"));
        ImageIcon hoverImg = new ImageIcon(Main2.class.getResource("Hoverimg.png"));
        ImageIcon clickimg = new ImageIcon(Main2.class.getResource("new_image.png"));
        JButton b0 = new JButton(img0);
        b0.setBorder(null);
        b0.setContentAreaFilled(false);
        b0.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                b0.setIcon(hoverImg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b0.setIcon(img0); 
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                b0.setIcon(clickimg);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0); 
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedValue != null && !selectedValue.equals("Seat no.")) {
                    myList.add(selectedValue);
                    entry0.removeItem(selectedValue);
                } else {
                    String title1 = "Error: Please choose a seat no.";
                    errorMessage.setText(title1);
                    errorMessage.setVisible(true);
                }
                if (username.contains("user")) {
                    window.dispose();
                    Main_52.setVisible(selectedDate,selectedRideLocation,selectedDestination,time, Firstname,Lastname,busID ,price ,  phonenumber ,String.valueOf(myList),"Big");
                    entry0.setSelectedIndex(0);

                } else {
                    window.dispose();
                    Main_51.setVisible(selectedDate,selectedRideLocation,selectedDestination,time, Firstname,Lastname,busID ,price ,  phonenumber,String.valueOf(myList) , "Big");
                    entry0.setSelectedIndex(0);
                }
            }
        });

        b0.setBounds(590, 403, 140, 48);
        canvas.add(b0);

        String[] options = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"};
        entry0 = new JComboBox<>(options);
        entry0.insertItemAt("Seat no.", 0);
        entry0.setSelectedIndex(0);
        entry0.setBackground(Color.WHITE);
        entry0.setBorder(null);
        entry0.setFont(entry0.getFont().deriveFont(Font.BOLD)); 
        entry0.setBounds(267, 410, 155, 32);
        AutoCompleteDecorator.decorate(entry0);
        entry0.addActionListener(new ActionListener() { // Add ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedValue = (String) entry0.getSelectedItem(); // Get selected item
            }
        });
        canvas.add(entry0);

        ImageIcon entry0Img = new ImageIcon(Main2.class.getResource("img_textBox0.png"));
        JLabel entry0Bg = new JLabel(entry0Img);
        entry0Bg.setBounds(260, 410, entry0Img.getIconWidth(), entry0Img.getIconHeight());
        canvas.add(entry0Bg);

        window.setVisible(true);
    }
}
