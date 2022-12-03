
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jrobin.mrtg.client.ClientMRTG;
import static org.jrobin.mrtg.client.ClientMRTG.frameClientMRTG;

public class NewMain {

    public static String currentLAF = "com.jtattoo.plaf.mint.MintLookAndFeel";

    public static void setLF() {
        try {
            UIManager.setLookAndFeel(currentLAF);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(frameClientMRTG);
        SwingUtilities.updateComponentTreeUI(frameClientMRTG.mrtgPopupMenu);
        SwingUtilities.updateComponentTreeUI(frameClientMRTG.linksPopupMenu);
        SwingUtilities.updateComponentTreeUI(frameClientMRTG.routerPopupMenu);
        //frameClientMRTG.pack();
        //frame.setSize(FW, FH);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //FlatLightLaf.setup();
                    //com.formdev.flatlaf.intellijthemes.FlatArcIJTheme.setup();
                    //com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme.setup();
                    //com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme.setup();
                    //com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme.setup();
                    //com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme.setup();
                    //com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme.setup(); 
                    //InstallLF();
                    frameClientMRTG = new ClientMRTG();
                    ImageIcon icone = new ImageIcon(getClass().getResource("pic/mrtg.png"));
                    frameClientMRTG.setIconImage(icone.getImage());
                    frameClientMRTG.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    frameClientMRTG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameClientMRTG.setSize(840, 440);
                    frameClientMRTG.setLocation(211, 211);
                    setLF();
                    //frameClientMRTG.mrtgPopupMenu.updateUI();
                    frameClientMRTG.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ClientMRTG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
