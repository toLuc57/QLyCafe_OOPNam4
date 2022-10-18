package UserControl;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author tranbathien
 */
public class FormUpdateData extends JComponent {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private int animate = 10;
    private BufferedImage imageShadow;
    private int shadowSize = 6;

    public FormUpdateData(Frame fram) {
        this.fram = fram;
        initComponents();
        init();
        initAnimator();
    }

    private void initComponents() {

    }

    private void init() {
        setBackground(Color.WHITE);
        dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                    y = fram.getY() + fram.getHeight() - dialog.getHeight();
                    top_to_bot = false;
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            closeform();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }
    public void showform(){
        animator.start();
    }
    public void closeform(){
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        g2.setColor(new Color(18, 163, 24));
        g2.fillRect(6, 5, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(g);
    }
    
}
