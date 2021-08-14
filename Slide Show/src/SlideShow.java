import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();		
		textPane.setBackground(Color.BLUE);		
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		// Edit 1 - JRP 20210727: Change title to reflect new theme
		//setTitle("Top 5 Destinations SlideShow");
		setTitle("SNHU Travel: Top 5 Detox/Wellness Destinations");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = "";
		// Edit 2 - JRP 20210727: Replace TestImage1..5 with new images for new destinations
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/1_Hilton_Sedona_Sedona_Arizona.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/2_Nobu_Hotel_Los_Cabos_Mexico.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/3_Spa_Eastman_Quebec_Canada.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/4_Cala_Luna_Hotel_Tamarindo_Costa_Rica.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/5_Agrivilla_i_pini_Tuscany_Italy.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		// Edit 3 - JRP 20210727: Add destination descriptions and details: use larger font for descriptions
		if (i==1){
			text = "<html><body><font size='5'>#1 Hilton Sedona Resort (Sedona, Arizona)</font> <br>Home of the Eforea Spa and Close to Hundreds of Hiking Trails.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Nobu Hotel Los Cabos (Cabo San Lucas, Mexico)</font> <br>Features a Tranquil Spa and an Outdoor Hydrotherapy Garden.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Spa Eastman (Quebec, Canada)</font> <br> Nordic Spa Therapy with Fresh Canadian Air to Rejuvinate Your Senses.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Cala Luna Boutique Hotels and Villas (Tamarindo, Costa Rica)</font> <br> A Transformative Yoga Vacation With Holistic Treatments and Organic Food.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Agrivilla i pini (Tuscany, Italy)</font> <br>The Historic Agrivilla i pini Estate Features Healthy Organic Food and Plant-Based Cooking Classes.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}