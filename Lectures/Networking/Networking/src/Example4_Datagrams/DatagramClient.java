package Example4_Datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class DatagramClient extends javax.swing.JFrame {

    //Datagram socket
    private DatagramSocket socket;

    //A byte array for sending and recieving datagram sockets
    private byte[] buf = new byte[256];

    //server InetAddress
    private InetAddress address;

    //The packet sent to the server
    private DatagramPacket sendPacket;

    //The packet recieved from the client
    private DatagramPacket recievePacket;


    /** Creates new form DatagramClient */
    public DatagramClient() {
        initComponents();

        try {

            socket = new DatagramSocket();

            address = InetAddress.getByName("localhost");

            sendPacket = new DatagramPacket(buf, buf.length, address, 8000);

            recievePacket = new DatagramPacket(buf, buf.length);
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }//end catch


    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datagram Client");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Enter radius");
        jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jtf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfActionPerformed(evt);
            }
        });
        jPanel1.add(jtf, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfActionPerformed

        try {
            //initialise buffer for each iteration
            Arrays.fill(buf, (byte)0);

            //send radius to the server in a packet
            sendPacket.setData(jtf.getText().trim().getBytes());
            socket.send(sendPacket);

           //recieve area from the server in a packet
           socket.receive(recievePacket);

           //display to the text area
           jta.append("Radius is " + jtf.getText().trim() + "\n");
           jta.append("Area recieved from the server is " + Double.parseDouble(new String(buf).trim()) + "\n");

           jtf.setText("");
        }
        catch (IOException ioe) {

            System.out.println(ioe);

        }





    }//GEN-LAST:event_jtfActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatagramClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables

}
