import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
//import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
//import javax.swing.JSplitPane;
//import java.awt.GridLayout;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.ListSelectionModel;
//import javax.swing.JToggleButton;
//import javax.swing.JSlider;
//import java.awt.Button;


public class GUI extends JFrame implements ReceiveCallback {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4765951169868128409L;
	private LinkedList<WIZnet_Header.Discovery_Reply> list = new LinkedList<WIZnet_Header.Discovery_Reply>();
	private WIZDatagramSocket socket = new WIZDatagramSocket(this);
	private String selectedMac;
	private int treeIndex = 0;
	private Timer timer = new Timer(true);

	public JPanel contentPane;
	public JPanel panel_ListOfModules;
	public JPanel panel_SearchMethod;
	public JPanel panel_LocalInfo;
	public JPanel panel_WorkingMode;
	public JPanel panel_Timer;
	public JPanel panel_ModuleName;
	public JPanel panel_Password;
	public JPanel panel_Dhcp;
	public JPanel panel_Dns;
	public JPanel panel_Buttons;
	public JPanel panel_Mqtt;
	public JPanel panel_Analog;
	
	public JTextField txtIp;
	public JTextField txtGateway;
	public JTextField txtSubnet;
	public JTextField txtLocalPort;
	public JTextField txtRemotePort;
	public JTextField txtHostIp;
	public JTextField txtReconnection;
	public JTextField txtDnsServerIp;
	public JTextField txtDomain;
	public JTextField txtIpAddress;
	public JTextField txtMacAddress;
	public JTextField txtModuleName;
	public JTextField txtMqttUser;
	public JTextField txtMqttPassword;
	public JTextField txtMqttPublishTopic;
	public JTextField txtMqttSubscribeTopic;
	public JTextField txtDataTransfer;
	public JTextField txtAnalogSeperator;
	
	
	public final JTree tree = new JTree();
	
	public final ButtonGroup btngrpWorkingMode = new ButtonGroup();
	public final JRadioButton rdbtnTcpClient = new JRadioButton("TCP Client");
	public final JRadioButton rdbtnTcpServer = new JRadioButton("TCP Server");
	public final JRadioButton rdbtnUdp = new JRadioButton("UDP");
	public final JRadioButton rdbtnMqtt = new JRadioButton("MQTT");
	public final JRadioButton rdbtnModbusTcp = new JRadioButton("Modbus TCP");
	public final JRadioButton rdbtnModbusUdp = new JRadioButton("Modbus UDP");
	
	public final ButtonGroup btngrpSearchMethod = new ButtonGroup();
	public final JRadioButton rdbtnBroadcast = new JRadioButton("Broadcast");
	public final JRadioButton rdbtnIpAddress = new JRadioButton("IP Address");
	public final JRadioButton rdbtnMacAddress = new JRadioButton("MAC Address");
	
	
	public final JCheckBox chckbxUseDhcp = new JCheckBox("Use DHCP");
	public final JCheckBox chckbxUseDns = new JCheckBox("Use DNS");
	
	
	
	
	
	public final JCheckBox chckbxEnableAnalogChannel_1 = new JCheckBox("Channel 1");
	public final JCheckBox chckbxEnableAnalogChannel_2 = new JCheckBox("Channel 2");
	public final JCheckBox chckbxEnableAnalogChannel_3 = new JCheckBox("Channel 3");
	public final JCheckBox chckbxEnableAnalogChannel_4 = new JCheckBox("Channel 4");
	public final JCheckBox chckbxEnableAnalogChannel_5 = new JCheckBox("Channel 5");
	public final JCheckBox chckbxEnableAnalogChannel_6 = new JCheckBox("Channel 6");
	public final JCheckBox chckbxEnableAnalogChannel_7 = new JCheckBox("Channel 7");
	public final JCheckBox chckbxEnableAnalogChannel_8 = new JCheckBox("Channel 8");
	
	public JTextField txtAnalogChannelValue_1;
	public JTextField txtAnalogChannelValue_2;
	public JTextField txtAnalogChannelValue_3;
	public JTextField txtAnalogChannelValue_4;
	public JTextField txtAnalogChannelValue_5;
	public JTextField txtAnalogChannelValue_6;
	public JTextField txtAnalogChannelValue_7;
	public JTextField txtAnalogChannelValue_8;
	public JLabel lblAnalogChannelValue;
	
	public JPasswordField pwdSettingPassword;
	public JButton btnSearch = new JButton("Search");
	private JScrollPane scrollPane;
	
	public JLabel lblUser;
	public JLabel lblPassword;
	public JLabel lblPublishTopic;
	public JLabel lblSubscribeTopic;
	public JLabel lblDataTransfer;
	public JLabel lblAnalogSeperator;
	public JLabel lblAnalogForm;
	public JLabel lblAnalogModbusFuction;
	
	public final JComboBox<Object> cmbAnalogForm = new JComboBox<Object>();
	public final JComboBox<Object> cmbAnalogFilter = new JComboBox<Object>();
	public JTabbedPane tabbedPane_;
	public JPanel panel_General;
	public JDesktopPane desktopPane_Network;
	public JDesktopPane desktopPane_Option;
	public JPanel panel_AnalogIn;
	
	public JPanel panel_AnalogInCommonSetting;
	public JLabel lblAnalogFilter;
	public JTextField txtAnalogModbusFuction;
	public JTextField txtAnalogModbusAddress;
	
	public JPanel panel_DigitalIn;
	public JPanel panel_DigitalOut;
	public JPanel panel_DigitalInSetting;
	public final JCheckBox chckbxEnableDigitalInChannel_1 = new JCheckBox("Channel 1");
	public final JCheckBox chckbxEnableDigitalInChannel_2 = new JCheckBox("Channel 2");
	public final JCheckBox chckbxEnableDigitalInChannel_3 = new JCheckBox("Channel 3");
	public final JCheckBox chckbxEnableDigitalInChannel_4 = new JCheckBox("Channel 4");
	public final JCheckBox chckbxEnableDigitalInChannel_5 = new JCheckBox("Channel 5");
	public final JCheckBox chckbxEnableDigitalInChannel_6 = new JCheckBox("Channel 6");
	public final JCheckBox chckbxEnableDigitalInChannel_7 = new JCheckBox("Channel 7");
	public final JCheckBox chckbxEnableDigitalInChannel_8 = new JCheckBox("Channel 8");
	
	public JLabel lblDigitalInValue;
	public JLabel lblDigitalInMode;
	public JLabel lblDigitalInModbusFuction;
	public JLabel lblDigitalInModbusAddress;
	public JTextField txtDigitalInChannelValue_1;
	public JTextField txtDigitalInChannelValue_2;
	public JTextField txtDigitalInChannelValue_3;
	public JTextField txtDigitalInChannelValue_4;
	public JTextField txtDigitalInChannelValue_5;
	public JTextField txtDigitalInChannelValue_6;
	public JTextField txtDigitalInChannelValue_7;
	public JTextField txtDigitalInChannelValue_8;
	public final JComboBox<Object> cmbDigitalInModeChannel_1 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_2 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_3 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_4 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_5 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_6 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_7 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalInModeChannel_8 = new JComboBox<Object>();
	public JTextField txtDigitalInModbusFuctionChannel_1;
	public JTextField txtDigitalInModbusFuctionChannel_2;
	public JTextField txtDigitalInModbusFuctionChannel_3;
	public JTextField txtDigitalInModbusFuctionChannel_4;
	public JTextField txtDigitalInModbusFuctionChannel_5;
	public JTextField txtDigitalInModbusFuctionChannel_6;
	public JTextField txtDigitalInModbusFuctionChannel_7;
	public JTextField txtDigitalInModbusFuctionChannel_8;
	public JTextField txtDigitalInModbusAddressChannel_1;
	public JTextField txtDigitalInModbusAddressChannel_2;
	public JTextField txtDigitalInModbusAddressChannel_3;
	public JTextField txtDigitalInModbusAddressChannel_4;
	public JTextField txtDigitalInModbusAddressChannel_5;
	public JTextField txtDigitalInModbusAddressChannel_6;
	public JTextField txtDigitalInModbusAddressChannel_7;
	public JTextField txtDigitalInModbusAddressChannel_8;
	public JPanel panel_DigitalOutSetting;
	public final  JCheckBox chckbxEnableDigitalOutChannel_1 = new JCheckBox("Channel 1");
	public final  JCheckBox chckbxEnableDigitalOutChannel_2 = new JCheckBox("Channel 2");
	public final  JCheckBox chckbxEnableDigitalOutChannel_3 = new JCheckBox("Channel 3");
	public final  JCheckBox chckbxEnableDigitalOutChannel_4 = new JCheckBox("Channel 4");
	public final  JCheckBox chckbxEnableDigitalOutChannel_5 = new JCheckBox("Channel 5");
	public final  JCheckBox chckbxEnableDigitalOutChannel_6 = new JCheckBox("Channel 6");
	public final  JCheckBox chckbxEnableDigitalOutChannel_7 = new JCheckBox("Channel 7");
	public final  JCheckBox chckbxEnableDigitalOutChannel_8 = new JCheckBox("Channel 8");
	public JLabel lblDigitalOutValue;
	public JLabel lblDigitalOutMode;
	public JLabel lblDigitalOutModbusFuction;
	public JLabel lblDigitalOutModbusAddress;
	public JLabel lblDigitalOutHighWidth;
	public JLabel lblDigitalOutLowWidth;
	public JLabel lblDigitalOutFrequency;
	public JLabel lblDigitalOutDutyCycle;
	public JTextField txtDigitalOutChannelValue_1;
	public JTextField txtDigitalOutChannelValue_2;
	public JTextField txtDigitalOutChannelValue_3;
	public JTextField txtDigitalOutChannelValue_4;
	public JTextField txtDigitalOutChannelValue_5;
	public JTextField txtDigitalOutChannelValue_6;
	public JTextField txtDigitalOutChannelValue_7;
	public JTextField txtDigitalOutChannelValue_8;
	public final JComboBox<Object> cmbDigitalOutModeChannel_1 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_2 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_3 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_4 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_5 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_6 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_7 = new JComboBox<Object>();
	public final JComboBox<Object> cmbDigitalOutModeChannel_8 = new JComboBox<Object>();
	
	public JTextField txtDigitalOutModbusFuctionChannel_1;
	public JTextField txtDigitalOutModbusFuctionChannel_2;
	public JTextField txtDigitalOutModbusFuctionChannel_3;
	public JTextField txtDigitalOutModbusFuctionChannel_4;
	public JTextField txtDigitalOutModbusFuctionChannel_5;
	public JTextField txtDigitalOutModbusFuctionChannel_6;
	public JTextField txtDigitalOutModbusFuctionChannel_7;
	public JTextField txtDigitalOutModbusFuctionChannel_8;
	
	public JTextField txtDigitalOutModbusAddressChannel_1;
	public JTextField txtDigitalOutModbusAddressChannel_2;
	public JTextField txtDigitalOutModbusAddressChannel_3;
	public JTextField txtDigitalOutModbusAddressChannel_4;
	public JTextField txtDigitalOutModbusAddressChannel_5;
	public JTextField txtDigitalOutModbusAddressChannel_6;
	public JTextField txtDigitalOutModbusAddressChannel_7;
	public JTextField txtDigitalOutModbusAddressChannel_8;
	
	public JTextField txtDigitalOutHighWidthChannel_1;
	public JTextField txtDigitalOutHighWidthChannel_2;
	public JTextField txtDigitalOutHighWidthChannel_3;
	public JTextField txtDigitalOutHighWidthChannel_4;
	public JTextField txtDigitalOutHighWidthChannel_5;
	public JTextField txtDigitalOutHighWidthChannel_6;
	public JTextField txtDigitalOutHighWidthChannel_7;
	public JTextField txtDigitalOutHighWidthChannel_8;
	
	public JTextField txtDigitalOutLowWidthChannel_1;
	public JTextField txtDigitalOutLowWidthChannel_2;
	public JTextField txtDigitalOutLowWidthChannel_3;
	public JTextField txtDigitalOutLowWidthChannel_4;
	public JTextField txtDigitalOutLowWidthChannel_5;
	public JTextField txtDigitalOutLowWidthChannel_6;
	public JTextField txtDigitalOutLowWidthChannel_7;
	public JTextField txtDigitalOutLowWidthChannel_8;
	
	public JTextField txtDigitalOutFrequencyChannel_1;
	public JTextField txtDigitalOutFrequencyChannel_2;
	public JTextField txtDigitalOutFrequencyChannel_3;
	public JTextField txtDigitalOutFrequencyChannel_4;
	public JTextField txtDigitalOutFrequencyChannel_5;
	public JTextField txtDigitalOutFrequencyChannel_6;
	public JTextField txtDigitalOutFrequencyChannel_7;
	public JTextField txtDigitalOutFrequencyChannel_8;
	
	public JTextField txtDigitalOutDutyCycleChannel_1;
	public JTextField txtDigitalOutDutyCycleChannel_2;
	public JTextField txtDigitalOutDutyCycleChannel_3;
	public JTextField txtDigitalOutDutyCycleChannel_4;
	public JTextField txtDigitalOutDutyCycleChannel_5;
	public JTextField txtDigitalOutDutyCycleChannel_6;
	public JTextField txtDigitalOutDutyCycleChannel_7;
	public JTextField txtDigitalOutDutyCycleChannel_8;
	private JPanel panel_HostInfo;
	private JLabel lblAnalogInModbusAddress;
	public JTextField txtAnalogInModbusAddressChannel_1;
	public JTextField txtAnalogInModbusAddressChannel_2;
	public JTextField txtAnalogInModbusAddressChannel_3;
	public JTextField txtAnalogInModbusAddressChannel_4;
	public JTextField txtAnalogInModbusAddressChannel_5;
	public JTextField txtAnalogInModbusAddressChannel_6;
	public JTextField txtAnalogInModbusAddressChannel_7;
	public JTextField txtAnalogInModbusAddressChannel_8;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	public JTextField txtFirmwareVersion;
	public JTextField txtNetworkStatus;
	public JTextField txtDigitalOutModbusAddress2Channel_1;
	public JTextField txtDigitalOutModbusAddress2Channel_2;
	public JTextField txtDigitalOutModbusAddress2Channel_3;
	public JTextField txtDigitalOutModbusAddress2Channel_4;
	public JTextField txtDigitalOutModbusAddress2Channel_5;
	public JTextField txtDigitalOutModbusAddress2Channel_6;
	public JTextField txtDigitalOutModbusAddress2Channel_7;
	public JTextField txtDigitalOutModbusAddress2Channel_8;
	public JTextField txtAnalogChannelVoltage_1;
	public JTextField txtAnalogChannelVoltage_2;
	public JTextField txtAnalogChannelVoltage_3;
	public JTextField txtAnalogChannelVoltage_4;
	public JTextField txtAnalogChannelVoltage_5;
	public JTextField txtAnalogChannelVoltage_6;
	public JTextField txtAnalogChannelVoltage_7;
	public JTextField txtAnalogChannelVoltage_8;
	
	private class treeSelectionTimer extends TimerTask {
		public void run() {
			if(treeIndex != 0) {
				// 가장 최근에 추가된 MAC 주소를 선택하도록 한다.
				//tree.setSelectionRow(treeIndex);
				// 가장 상단에 추가된 MAC 주소를 선택하도록 한다.
				tree.setSelectionRow(2);
			}

			btnSearch.setEnabled(true);
			btnSearch.requestFocus();

			timer.cancel();
			timer = new Timer();
		}
	}

	private void treeUpdate(WIZnet_Header.Discovery_Reply packet) {
		boolean exist;
		int i;

		String module_type = new String();
		String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
				packet.mac_address[0], packet.mac_address[1],
				packet.mac_address[2], packet.mac_address[3],
				packet.mac_address[4], packet.mac_address[5]);

		// Search Method가 Mac Address로 설정된 경우
		if(rdbtnMacAddress.isSelected() && txtMacAddress.getText().length() != 0) {
			// Mac Address를 입력 받는 텍스트 박스의 문자열과 현재 수신된 패킷의 MAC Address가 동일한지 검사
			if(txtMacAddress.getText().trim().toUpperCase(Locale.ENGLISH).equals(mac_address.toUpperCase(Locale.ENGLISH)) == false)
				return;
		}

		list.add(packet);

		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
		DefaultMutableTreeNode child = null;

		// 모듈의 타입을 확인한다.
		if(packet.product_code[0] == 0x04 && packet.product_code[1] == 0x00 && packet.product_code[2] == 0x00) {
			module_type = "ETH-4022";
		}
		else {
			return;
		}

		// 모듈을 타입별로 구분하기 위해 트리에 카테고리를 만든다.
		treeIndex = root.getChildCount();
		if(treeIndex == 0) {
			// 현재 트리에 아무런 카테고리가 없는 경우
			child = new DefaultMutableTreeNode(module_type);
			root.add(child);
			treeIndex++;
		}
		else {
			// 현재 트리에 1개 이상의 카테고리가 있는 경우
			exist = false;
			child = (DefaultMutableTreeNode)root.getFirstChild();

			for(i=0; i<root.getChildCount(); i++) {
				if(child.getUserObject() == module_type) {
					exist = true;
					break;
				}
				treeIndex += child.getChildCount();
				child = (DefaultMutableTreeNode) root.getChildAfter(child);
			}

			// 모듈의 타입과 동일한 카테고리가 없는 경우
			if(exist == false) {
				child = new DefaultMutableTreeNode(module_type);
				root.add(child);
				treeIndex++;
			}
		}
		
		// 위에서 선택된 카테고리에 수신한 패킷의 MAC 주소를 추가한다.
		DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(mac_address);
		child.add(leaf);
		model.reload(root);

		// 모든 카테고리를 확장한다.
		for (int j = 0; j < tree.getRowCount(); j++) {
			tree.expandRow(j);
			//tree.collapseRow(j);
		}

		// 가장 최근에 추가된 MAC 주소를 선택하도록 한다.
		treeIndex += model.getIndexOfChild(child, leaf) + 1;
		timer.schedule(new treeSelectionTimer(), 500);
	}

	// ReceiveThread가 패킷을 수신하면 이 함수를 호출한다.
	public void receivedPacket(byte op, Object packet) {
		WIZnet_Header wiznet_header = new WIZnet_Header();

		if((byte)(op & 0xF0) == (byte)wiznet_header.DISCOVERY) {
			WIZnet_Header.Discovery_Reply discovery_reply = (WIZnet_Header.Discovery_Reply) packet;
			list.add(discovery_reply);
			treeUpdate(discovery_reply);
		}
		else if(op == wiznet_header.GET_INFO) {
			WIZnet_Header.Get_Info_Reply get_info_reply = (WIZnet_Header.Get_Info_Reply) packet;

			/* WizIO */
			if(get_info_reply.system_info[2] == 0x04 && get_info_reply.system_info[3] == 0x00 && get_info_reply.system_info[4] == 0x00) {
				WizIO_Config wizio_config = new WizIO_Config();
				wizio_config.setData(get_info_reply.system_info);
				PanelManager.updateToPanel(this, wizio_config);
			}
		}
		else if(op == wiznet_header.SET_INFO) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Set");
		}
		else if(op == wiznet_header.FIRMWARE_UPLOAD_INIT) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Firmware Uploading will Start");
		}
		else if(op == wiznet_header.FIRMWARE_UPLOAD_DONE) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Firmware Uploading");
		}
		else if(op == wiznet_header.REMOTE_RESET) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Reset");
		}
		else if(op == wiznet_header.FACTORY_RESET) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Factory Reset");
		}
		else if(op == wiznet_header.REMOTE_CLEAR) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Clear");
		}
		else if(op == wiznet_header.REMOTE_LOCATE) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Success Locate");
		}
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("WizIO Tool Version 1.00");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1112, 690);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{195, 898};
		gbl_contentPane.rowHeights = new int[]{542, 71, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel_ListOfModules = new JPanel();
		panel_ListOfModules.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List of Modules", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_ListOfModules = new GridBagConstraints();
		gbc_panel_ListOfModules.gridheight = 3;
		gbc_panel_ListOfModules.insets = new Insets(0, 0, 0, 5);
		gbc_panel_ListOfModules.fill = GridBagConstraints.BOTH;
		gbc_panel_ListOfModules.gridx = 0;
		gbc_panel_ListOfModules.gridy = 0;
		contentPane.add(panel_ListOfModules, gbc_panel_ListOfModules);
		panel_ListOfModules.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_ListOfModules.add(scrollPane, "2, 2, fill, fill");
				tree.setVisibleRowCount(254);
				scrollPane.setViewportView(tree);
		
				tree.addTreeSelectionListener(new TreeSelectionListener() {
					public void valueChanged(TreeSelectionEvent e) {
						JTree tree = (JTree) e.getSource();
						DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		
						selectedMac = null;
						if(selectedNode == null) return;
						String selectedNodeName = selectedNode.toString();
		
						if(selectedNode.isLeaf()) {
							WIZnet_Header.Discovery_Reply discovery_reply;
							for(int i=0; i<list.size(); i++) {
								discovery_reply = list.get(i);
								String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
										discovery_reply.mac_address[0], discovery_reply.mac_address[1],
										discovery_reply.mac_address[2], discovery_reply.mac_address[3],
										discovery_reply.mac_address[4], discovery_reply.mac_address[5]);
								if(selectedNodeName.equals(mac_address)) {
									selectedMac = mac_address;
									socket.get_info("255.255.255.255", discovery_reply.mac_address);
									break;
								}
							}
						}
					}
				});
				
				tree.setModel(new DefaultTreeModel(
					new DefaultMutableTreeNode("WIZnet")
				));
		
		panel_SearchMethod = new JPanel();
		panel_SearchMethod.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ListOfModules.add(panel_SearchMethod, "2, 4, fill, fill");
		panel_SearchMethod.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		rdbtnBroadcast.setEnabled(false);
		
		rdbtnBroadcast.setSelected(true);
		rdbtnBroadcast.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton radiobutton = (JRadioButton) e.getSource();

				if(radiobutton.isSelected()) {
					txtIpAddress.setEnabled(false);
					txtMacAddress.setEnabled(false);
				}
			}
		});
		btngrpSearchMethod.add(rdbtnBroadcast);
		panel_SearchMethod.add(rdbtnBroadcast, "2, 2");
		rdbtnIpAddress.setEnabled(false);
		
		rdbtnIpAddress.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton radiobutton = (JRadioButton) e.getSource();

				if(radiobutton.isSelected()) {
					txtIpAddress.setEnabled(true);
					txtMacAddress.setEnabled(false);

					txtIpAddress.setVisible(true);
					txtMacAddress.setVisible(false);

					txtIpAddress.requestFocus();
				}
			}
		});
		btngrpSearchMethod.add(rdbtnIpAddress);
		panel_SearchMethod.add(rdbtnIpAddress, "2, 4");
		rdbtnMacAddress.setEnabled(false);
		
		rdbtnMacAddress.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton radiobutton = (JRadioButton) e.getSource();

				if(radiobutton.isSelected()) {
					txtIpAddress.setEnabled(false);
					txtMacAddress.setEnabled(true);

					txtIpAddress.setVisible(false);
					txtMacAddress.setVisible(true);

					txtMacAddress.requestFocus();
				}
			}
		});
		btngrpSearchMethod.add(rdbtnMacAddress);
		panel_SearchMethod.add(rdbtnMacAddress, "2, 6");
		
		txtIpAddress = new JTextField();
		txtIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtIpAddress.setEnabled(false);
		panel_SearchMethod.add(txtIpAddress, "2, 8, fill, default");
		txtIpAddress.setColumns(10);
		
		txtMacAddress = new JTextField();
		txtMacAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtMacAddress.setEnabled(false);
		panel_SearchMethod.add(txtMacAddress, "2, 8, fill, default");
		txtMacAddress.setColumns(10);
		
		tabbedPane_ = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_.setToolTipText("WizIO");
		GridBagConstraints gbc_tabbedPane_ = new GridBagConstraints();
		gbc_tabbedPane_.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane_.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_.gridx = 1;
		gbc_tabbedPane_.gridy = 0;
		contentPane.add(tabbedPane_, gbc_tabbedPane_);
		
		panel_General = new JPanel();
		tabbedPane_.addTab("General", null, panel_General, null);
		panel_General.setLayout(null);
		
		desktopPane_Network = new JDesktopPane();
		desktopPane_Network.setBounds(0, 10, 585, 488);
		desktopPane_Network.setBackground(SystemColor.control);
		desktopPane_Network.setBorder(new TitledBorder(null, "Network", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_General.add(desktopPane_Network);
		
		panel_LocalInfo = new JPanel();
		panel_LocalInfo.setBounds(12, 23, 270, 168);
		desktopPane_Network.add(panel_LocalInfo);
		panel_LocalInfo.setBackground(SystemColor.control);
		panel_LocalInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Local Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_LocalInfo.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(43dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblIp = new JLabel("IP");
		panel_LocalInfo.add(lblIp, "2, 1, left, default");
		
		txtIp = new JTextField();
		txtIp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_LocalInfo.add(txtIp, "4, 1, fill, default");
		txtIp.setColumns(10);
		
		JLabel lblGateway = new JLabel("Gateway");
		panel_LocalInfo.add(lblGateway, "2, 3, left, default");
		
		txtGateway = new JTextField();
		txtGateway.setHorizontalAlignment(SwingConstants.CENTER);
		panel_LocalInfo.add(txtGateway, "4, 3, fill, default");
		txtGateway.setColumns(10);
		
		JLabel lblSubnet = new JLabel("Subnet");
		panel_LocalInfo.add(lblSubnet, "2, 5, left, default");
		
		txtSubnet = new JTextField();
		txtSubnet.setHorizontalAlignment(SwingConstants.CENTER);
		panel_LocalInfo.add(txtSubnet, "4, 5, fill, default");
		txtSubnet.setColumns(10);
		
		JLabel lblDnsServerIp = new JLabel("DNS Server IP");
		panel_LocalInfo.add(lblDnsServerIp, "2, 7, left, default");
		
		txtDnsServerIp = new JTextField();
		panel_LocalInfo.add(txtDnsServerIp, "4, 7");
		txtDnsServerIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtDnsServerIp.setColumns(10);
		
		JLabel lblLocalPort = new JLabel("Local Port");
		panel_LocalInfo.add(lblLocalPort, "2, 9");
		
		txtLocalPort = new JTextField();
		panel_LocalInfo.add(txtLocalPort, "4, 9");
		txtLocalPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocalPort.setColumns(10);
		
		panel_Mqtt = new JPanel();
		panel_Mqtt.setBounds(294, 23, 279, 145);
		desktopPane_Network.add(panel_Mqtt);
		panel_Mqtt.setBorder(new TitledBorder(null, "MQTT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Mqtt.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(26dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblUser = new JLabel("User");
		panel_Mqtt.add(lblUser, "2, 2");
		
		txtMqttUser = new JTextField();
		panel_Mqtt.add(txtMqttUser, "4, 2");
		txtMqttUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtMqttUser.setColumns(10);
		
		lblPassword = new JLabel("Password");
		panel_Mqtt.add(lblPassword, "2, 4");
		
		txtMqttPassword = new JTextField();
		panel_Mqtt.add(txtMqttPassword, "4, 4");
		txtMqttPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtMqttPassword.setColumns(10);
		
		lblPublishTopic = new JLabel("Publish Topic");
		panel_Mqtt.add(lblPublishTopic, "2, 6");
		
		txtMqttPublishTopic = new JTextField();
		panel_Mqtt.add(txtMqttPublishTopic, "4, 6");
		txtMqttPublishTopic.setHorizontalAlignment(SwingConstants.CENTER);
		txtMqttPublishTopic.setColumns(10);
		
		lblSubscribeTopic = new JLabel("Subscribe Topic");
		panel_Mqtt.add(lblSubscribeTopic, "2, 8");
		
		txtMqttSubscribeTopic = new JTextField();
		panel_Mqtt.add(txtMqttSubscribeTopic, "4, 8");
		txtMqttSubscribeTopic.setHorizontalAlignment(SwingConstants.CENTER);
		txtMqttSubscribeTopic.setColumns(10);
		
		panel_WorkingMode = new JPanel();
		panel_WorkingMode.setBounds(294, 178, 279, 300);
		desktopPane_Network.add(panel_WorkingMode);
		panel_WorkingMode.setBorder(new TitledBorder(null, "Working Mode", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_WorkingMode.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btngrpWorkingMode.add(rdbtnTcpClient);
		panel_WorkingMode.add(rdbtnTcpClient, "2, 2");
		
		btngrpWorkingMode.add(rdbtnTcpServer);
		panel_WorkingMode.add(rdbtnTcpServer, "2, 4");
		
		btngrpWorkingMode.add(rdbtnUdp);
		panel_WorkingMode.add(rdbtnUdp, "2, 6");
		
		btngrpWorkingMode.add(rdbtnMqtt);
		panel_WorkingMode.add(rdbtnMqtt, "2, 8");
		
		//JRadioButton rdbtnModbusTcp = new JRadioButton("Modbus TCP");
		btngrpWorkingMode.add(rdbtnModbusTcp);
		panel_WorkingMode.add(rdbtnModbusTcp, "2, 10");
		
		//JRadioButton rdbtnModbusUdp = new JRadioButton("Modbus UDP");
		btngrpWorkingMode.add(rdbtnModbusUdp);
		panel_WorkingMode.add(rdbtnModbusUdp, "2, 12");
		
		panel_HostInfo = new JPanel();
		panel_HostInfo.setBorder(new TitledBorder(null, "Host Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_HostInfo.setBounds(12, 394, 270, 84);
		desktopPane_Network.add(panel_HostInfo);
		panel_HostInfo.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblHostIp = new JLabel("Host IP");
		panel_HostInfo.add(lblHostIp, "2, 2");
		
		txtHostIp = new JTextField();
		panel_HostInfo.add(txtHostIp, "4, 2");
		txtHostIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtHostIp.setColumns(10);
		
		JLabel lblRemotePort = new JLabel("Host Port");
		panel_HostInfo.add(lblRemotePort, "2, 4");
		
		txtRemotePort = new JTextField();
		panel_HostInfo.add(txtRemotePort, "4, 4");
		txtRemotePort.setHorizontalAlignment(SwingConstants.CENTER);
		txtRemotePort.setColumns(10);
		
		panel_Dhcp = new JPanel();
		panel_Dhcp.setBounds(12, 201, 270, 64);
		desktopPane_Network.add(panel_Dhcp);
		panel_Dhcp.setBorder(new TitledBorder(null, "DHCP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Dhcp.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		chckbxUseDhcp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkbox = (JCheckBox) e.getSource();

				if(checkbox.isSelected()) {
					txtIp.setEnabled(false);
					txtGateway.setEnabled(false);
					txtSubnet.setEnabled(false);
				}
				else {
					txtIp.setEnabled(true);
					txtGateway.setEnabled(true);
					txtSubnet.setEnabled(true);
				}
			}
		});
		
		panel_Dhcp.add(chckbxUseDhcp, "2, 2");
		
		panel_Dns = new JPanel();
		panel_Dns.setBounds(12, 275, 270, 117);
		desktopPane_Network.add(panel_Dns);
		panel_Dns.setBorder(new TitledBorder(null, "DNS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Dns.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		chckbxUseDns.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkbox = (JCheckBox) e.getSource();

				if(checkbox.isSelected()) {
					txtHostIp.setEnabled(false);
				}
				else {
					txtHostIp.setEnabled(true);
				}
			}
		});
		
		panel_Dns.add(chckbxUseDns, "2, 2");
		
		JLabel lblDomain = new JLabel("Domain");
		panel_Dns.add(lblDomain, "2, 4");
		
		txtDomain = new JTextField();
		txtDomain.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Dns.add(txtDomain, "2, 6, fill, default");
		txtDomain.setColumns(10);
		
		desktopPane_Option = new JDesktopPane();
		desktopPane_Option.setBounds(597, 10, 284, 488);
		desktopPane_Option.setBorder(new TitledBorder(null, "Option", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		desktopPane_Option.setBackground(SystemColor.control);
		panel_General.add(desktopPane_Option);
		
		panel_Password = new JPanel();
		panel_Password.setBounds(12, 104, 260, 66);
		desktopPane_Option.add(panel_Password);
		panel_Password.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Setting Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Password.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		pwdSettingPassword = new JPasswordField();
		pwdSettingPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdSettingPassword.setColumns(16);
		panel_Password.add(pwdSettingPassword, "2, 2, fill, default");
		
		panel_Analog = new JPanel();
		panel_Analog.setBounds(12, 276, 260, 202);
		desktopPane_Option.add(panel_Analog);
		panel_Analog.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Data Format", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Analog.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(64dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblAnalogSeperator = new JLabel("Seperator");
		panel_Analog.add(lblAnalogSeperator, "2, 2");
		
		txtAnalogSeperator = new JTextField();
		panel_Analog.add(txtAnalogSeperator, "4, 2");
		txtAnalogSeperator.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogSeperator.setColumns(10);
		
		lblAnalogForm = new JLabel("Form");
		panel_Analog.add(lblAnalogForm, "2, 4");
		panel_Analog.add(cmbAnalogForm, "4, 4");
		
		cmbAnalogForm.setModel(new DefaultComboBoxModel<Object>(new String[] {"None", "Json"}));
		
		panel_Timer = new JPanel();
		panel_Timer.setBounds(12, 180, 260, 86);
		desktopPane_Option.add(panel_Timer);
		panel_Timer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Timer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Timer.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(64dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblReconnection = new JLabel("Reconnection(ms)");
		panel_Timer.add(lblReconnection, "2, 2");
		
		txtReconnection = new JTextField();
		txtReconnection.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Timer.add(txtReconnection, "4, 2, fill, default");
		txtReconnection.setColumns(10);
		
		lblDataTransfer = new JLabel("Data Transfer(ms)");
		panel_Timer.add(lblDataTransfer, "2, 4");
		
		txtDataTransfer = new JTextField();
		panel_Timer.add(txtDataTransfer, "4, 4, fill, default");
		txtDataTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataTransfer.setColumns(10);
		
		panel_ModuleName = new JPanel();
		panel_ModuleName.setBounds(12, 28, 260, 66);
		desktopPane_Option.add(panel_ModuleName);
		panel_ModuleName.setBorder(new TitledBorder(null, "Module Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ModuleName.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		txtModuleName = new JTextField();
		txtModuleName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ModuleName.add(txtModuleName, "2, 2, fill, default");
		txtModuleName.setColumns(10);
		
		panel_AnalogIn = new JPanel();
		tabbedPane_.addTab("Analog In", null, panel_AnalogIn, null);
		panel_AnalogIn.setLayout(null);
		
		panel_AnalogInCommonSetting = new JPanel();
		panel_AnalogInCommonSetting.setBounds(12, 10, 873, 62);
		panel_AnalogIn.add(panel_AnalogInCommonSetting);
		panel_AnalogInCommonSetting.setBorder(new TitledBorder(null, "Common", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_AnalogInCommonSetting.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblAnalogFilter = new JLabel("Filter");
		panel_AnalogInCommonSetting.add(lblAnalogFilter, "2, 2, right, default");
		panel_AnalogInCommonSetting.add(cmbAnalogFilter, "4, 2");
		
		cmbAnalogFilter.setModel(new DefaultComboBoxModel<Object>(new String[] {"None", "Average"}));
		
		lblAnalogModbusFuction = new JLabel("Modbus Function");
		panel_AnalogInCommonSetting.add(lblAnalogModbusFuction, "6, 2, right, default");
		
		txtAnalogModbusFuction = new JTextField();
		txtAnalogModbusFuction.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogModbusFuction.setEditable(false);
		panel_AnalogInCommonSetting.add(txtAnalogModbusFuction, "8, 2, fill, default");
		txtAnalogModbusFuction.setColumns(10);
		
		JLabel lblAnalogModbusAddress = new JLabel("Modbus Address");
		panel_AnalogInCommonSetting.add(lblAnalogModbusAddress, "10, 2, right, default");
		
		txtAnalogModbusAddress = new JTextField();
		txtAnalogModbusAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInCommonSetting.add(txtAnalogModbusAddress, "12, 2, fill, default");
		txtAnalogModbusAddress.setColumns(10);
		
		JPanel panel_AnalogInSetting = new JPanel();
		panel_AnalogInSetting.setBounds(12, 82, 873, 416);
		panel_AnalogIn.add(panel_AnalogInSetting);
		panel_AnalogInSetting.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_1, "4, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_2, "6, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_3, "8, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_4, "10, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_5, "12, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_6, "14, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_7, "16, 2");
		panel_AnalogInSetting.add(chckbxEnableAnalogChannel_8, "18, 2");
		
		lblAnalogChannelValue = new JLabel("Value");
		panel_AnalogInSetting.add(lblAnalogChannelValue, "2, 4");
		
		txtAnalogChannelValue_1 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_1, "4, 4");
		txtAnalogChannelValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_1.setEditable(false);
		txtAnalogChannelValue_1.setColumns(10);
		
		txtAnalogChannelValue_2 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_2, "6, 4");
		txtAnalogChannelValue_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_2.setEditable(false);
		txtAnalogChannelValue_2.setColumns(10);
		
		txtAnalogChannelValue_3 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_3, "8, 4");
		txtAnalogChannelValue_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_3.setEditable(false);
		txtAnalogChannelValue_3.setColumns(10);
		
		txtAnalogChannelValue_4 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_4, "10, 4");
		txtAnalogChannelValue_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_4.setEditable(false);
		txtAnalogChannelValue_4.setColumns(10);
		
		txtAnalogChannelValue_5 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_5, "12, 4");
		txtAnalogChannelValue_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_5.setEditable(false);
		txtAnalogChannelValue_5.setColumns(10);
		
		txtAnalogChannelValue_6 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_6, "14, 4");
		txtAnalogChannelValue_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_6.setEditable(false);
		txtAnalogChannelValue_6.setColumns(10);
		
		txtAnalogChannelValue_7 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_7, "16, 4");
		txtAnalogChannelValue_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_7.setEditable(false);
		txtAnalogChannelValue_7.setColumns(10);
		
		txtAnalogChannelValue_8 = new JTextField();
		panel_AnalogInSetting.add(txtAnalogChannelValue_8, "18, 4");
		txtAnalogChannelValue_8.setEditable(false);
		txtAnalogChannelValue_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogChannelValue_8.setColumns(10);
		
		JLabel lblAnalogChannelVoltage = new JLabel("Voltage");
		panel_AnalogInSetting.add(lblAnalogChannelVoltage, "2, 6");
		
		txtAnalogChannelVoltage_1 = new JTextField();
		txtAnalogChannelVoltage_1.setEditable(false);
		txtAnalogChannelVoltage_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_1, "4, 6, fill, default");
		txtAnalogChannelVoltage_1.setColumns(10);
		
		txtAnalogChannelVoltage_2 = new JTextField();
		txtAnalogChannelVoltage_2.setEditable(false);
		txtAnalogChannelVoltage_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_2, "6, 6, fill, default");
		txtAnalogChannelVoltage_2.setColumns(10);
		
		txtAnalogChannelVoltage_3 = new JTextField();
		txtAnalogChannelVoltage_3.setEditable(false);
		txtAnalogChannelVoltage_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_3, "8, 6, fill, default");
		txtAnalogChannelVoltage_3.setColumns(10);
		
		txtAnalogChannelVoltage_4 = new JTextField();
		txtAnalogChannelVoltage_4.setEditable(false);
		txtAnalogChannelVoltage_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_4, "10, 6, fill, default");
		txtAnalogChannelVoltage_4.setColumns(10);
		
		txtAnalogChannelVoltage_5 = new JTextField();
		txtAnalogChannelVoltage_5.setEditable(false);
		txtAnalogChannelVoltage_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_5, "12, 6, fill, default");
		txtAnalogChannelVoltage_5.setColumns(10);
		
		txtAnalogChannelVoltage_6 = new JTextField();
		txtAnalogChannelVoltage_6.setEditable(false);
		txtAnalogChannelVoltage_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_6, "14, 6, fill, default");
		txtAnalogChannelVoltage_6.setColumns(10);
		
		txtAnalogChannelVoltage_7 = new JTextField();
		txtAnalogChannelVoltage_7.setEditable(false);
		txtAnalogChannelVoltage_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_7, "16, 6, fill, default");
		txtAnalogChannelVoltage_7.setColumns(10);
		
		txtAnalogChannelVoltage_8 = new JTextField();
		txtAnalogChannelVoltage_8.setEditable(false);
		txtAnalogChannelVoltage_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_AnalogInSetting.add(txtAnalogChannelVoltage_8, "18, 6, fill, default");
		txtAnalogChannelVoltage_8.setColumns(10);
		
		lblAnalogInModbusAddress = new JLabel("Modbus Address");
		panel_AnalogInSetting.add(lblAnalogInModbusAddress, "2, 8, right, default");
		
		txtAnalogInModbusAddressChannel_1 = new JTextField();
		txtAnalogInModbusAddressChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_1.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_1, "4, 8, fill, default");
		txtAnalogInModbusAddressChannel_1.setColumns(10);
		
		txtAnalogInModbusAddressChannel_2 = new JTextField();
		txtAnalogInModbusAddressChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_2.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_2, "6, 8, fill, default");
		txtAnalogInModbusAddressChannel_2.setColumns(10);
		
		txtAnalogInModbusAddressChannel_3 = new JTextField();
		txtAnalogInModbusAddressChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_3.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_3, "8, 8, fill, default");
		txtAnalogInModbusAddressChannel_3.setColumns(10);
		
		txtAnalogInModbusAddressChannel_4 = new JTextField();
		txtAnalogInModbusAddressChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_4.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_4, "10, 8, fill, default");
		txtAnalogInModbusAddressChannel_4.setColumns(10);
		
		txtAnalogInModbusAddressChannel_5 = new JTextField();
		txtAnalogInModbusAddressChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_5.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_5, "12, 8, fill, default");
		txtAnalogInModbusAddressChannel_5.setColumns(10);
		
		txtAnalogInModbusAddressChannel_6 = new JTextField();
		txtAnalogInModbusAddressChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_6.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_6, "14, 8, fill, default");
		txtAnalogInModbusAddressChannel_6.setColumns(10);
		
		txtAnalogInModbusAddressChannel_7 = new JTextField();
		txtAnalogInModbusAddressChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_7.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_7, "16, 8, fill, default");
		txtAnalogInModbusAddressChannel_7.setColumns(10);
		
		txtAnalogInModbusAddressChannel_8 = new JTextField();
		txtAnalogInModbusAddressChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalogInModbusAddressChannel_8.setEditable(false);
		panel_AnalogInSetting.add(txtAnalogInModbusAddressChannel_8, "18, 8, fill, default");
		txtAnalogInModbusAddressChannel_8.setColumns(10);
		
		panel_DigitalIn = new JPanel();
		tabbedPane_.addTab("Digital In", null, panel_DigitalIn, null);
		panel_DigitalIn.setLayout(null);
		
		panel_DigitalInSetting = new JPanel();
		panel_DigitalInSetting.setBounds(12, 10, 873, 488);
		panel_DigitalIn.add(panel_DigitalInSetting);
		panel_DigitalInSetting.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		//chckbxEnableDigitalInChannel_1 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_1, "4, 2");
		
		//chckbxEnableDigitalInChannel_2 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_2, "6, 2");
		
		//chckbxEnableDigitalInChannel_3 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_3, "8, 2");
		
		//chckbxEnableDigitalInChannel_4 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_4, "10, 2");
		
		//chckbxEnableDigitalInChannel_5 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_5, "12, 2");
		
		//chckbxEnableDigitalInChannel_6 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_6, "14, 2");
		
		//chckbxEnableDigitalInChannel_7 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_7, "16, 2");
		
		//chckbxEnableDigitalInChannel_8 = new JCheckBox("Use");
		panel_DigitalInSetting.add(chckbxEnableDigitalInChannel_8, "18, 2");
		
		lblDigitalInValue = new JLabel("Value");
		panel_DigitalInSetting.add(lblDigitalInValue, "2, 4");
		
		txtDigitalInChannelValue_1 = new JTextField();
		txtDigitalInChannelValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_1.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_1, "4, 4, fill, default");
		txtDigitalInChannelValue_1.setColumns(10);
		
		txtDigitalInChannelValue_2 = new JTextField();
		txtDigitalInChannelValue_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_2.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_2, "6, 4, fill, default");
		txtDigitalInChannelValue_2.setColumns(10);
		
		txtDigitalInChannelValue_3 = new JTextField();
		txtDigitalInChannelValue_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_3.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_3, "8, 4, fill, default");
		txtDigitalInChannelValue_3.setColumns(10);
		
		txtDigitalInChannelValue_4 = new JTextField();
		txtDigitalInChannelValue_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_4.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_4, "10, 4, fill, default");
		txtDigitalInChannelValue_4.setColumns(10);
		
		txtDigitalInChannelValue_5 = new JTextField();
		txtDigitalInChannelValue_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_5.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_5, "12, 4, fill, default");
		txtDigitalInChannelValue_5.setColumns(10);
		
		txtDigitalInChannelValue_6 = new JTextField();
		txtDigitalInChannelValue_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_6.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_6, "14, 4, fill, default");
		txtDigitalInChannelValue_6.setColumns(10);
		
		txtDigitalInChannelValue_7 = new JTextField();
		txtDigitalInChannelValue_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_7.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_7, "16, 4, fill, default");
		txtDigitalInChannelValue_7.setColumns(10);
		
		txtDigitalInChannelValue_8 = new JTextField();
		txtDigitalInChannelValue_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInChannelValue_8.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInChannelValue_8, "18, 4, fill, default");
		txtDigitalInChannelValue_8.setColumns(10);
		
		lblDigitalInMode = new JLabel("Mode");
		panel_DigitalInSetting.add(lblDigitalInMode, "2, 6");
		
		//cmbDigitalInModeChannel_1 = new JComboBox();
		cmbDigitalInModeChannel_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_1, "4, 6, fill, default");
		
		//cmbDigitalInModeChannel_2 = new JComboBox();
		cmbDigitalInModeChannel_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_2, "6, 6, fill, default");
		
		//cmbDigitalInModeChannel_3 = new JComboBox();
		cmbDigitalInModeChannel_3.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_3, "8, 6, fill, default");
		
		//cmbDigitalInModeChannel_4 = new JComboBox();
		cmbDigitalInModeChannel_4.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_4, "10, 6, fill, default");
		
		//cmbDigitalInModeChannel_5 = new JComboBox();
		cmbDigitalInModeChannel_5.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_5, "12, 6, fill, default");
		
		//cmbDigitalInModeChannel_6 = new JComboBox();
		cmbDigitalInModeChannel_6.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_6, "14, 6, fill, default");
		
		//cmbDigitalInModeChannel_7 = new JComboBox();
		cmbDigitalInModeChannel_7.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_7, "16, 6, fill, default");
		
		//cmbDigitalInModeChannel_8 = new JComboBox();
		cmbDigitalInModeChannel_8.setModel(new DefaultComboBoxModel<Object>(new String[] {"DI", "H Counter", "L Counter", "Frequency"}));
		panel_DigitalInSetting.add(cmbDigitalInModeChannel_8, "18, 6, fill, default");
		
		lblDigitalInModbusFuction = new JLabel("Modbus Function");
		panel_DigitalInSetting.add(lblDigitalInModbusFuction, "2, 8");
		
		txtDigitalInModbusFuctionChannel_1 = new JTextField();
		txtDigitalInModbusFuctionChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_1.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_1, "4, 8, fill, default");
		txtDigitalInModbusFuctionChannel_1.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_2 = new JTextField();
		txtDigitalInModbusFuctionChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_2.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_2, "6, 8, fill, default");
		txtDigitalInModbusFuctionChannel_2.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_3 = new JTextField();
		txtDigitalInModbusFuctionChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_3.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_3, "8, 8, fill, default");
		txtDigitalInModbusFuctionChannel_3.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_4 = new JTextField();
		txtDigitalInModbusFuctionChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_4.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_4, "10, 8, fill, default");
		txtDigitalInModbusFuctionChannel_4.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_5 = new JTextField();
		txtDigitalInModbusFuctionChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_5.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_5, "12, 8, fill, default");
		txtDigitalInModbusFuctionChannel_5.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_6 = new JTextField();
		txtDigitalInModbusFuctionChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_6.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_6, "14, 8, fill, default");
		txtDigitalInModbusFuctionChannel_6.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_7 = new JTextField();
		txtDigitalInModbusFuctionChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_7.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_7, "16, 8, fill, default");
		txtDigitalInModbusFuctionChannel_7.setColumns(10);
		
		txtDigitalInModbusFuctionChannel_8 = new JTextField();
		txtDigitalInModbusFuctionChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalInModbusFuctionChannel_8.setEditable(false);
		panel_DigitalInSetting.add(txtDigitalInModbusFuctionChannel_8, "18, 8, fill, default");
		txtDigitalInModbusFuctionChannel_8.setColumns(10);
		
		lblDigitalInModbusAddress = new JLabel("Modbus Address");
		panel_DigitalInSetting.add(lblDigitalInModbusAddress, "2, 10");
		
		txtDigitalInModbusAddressChannel_1 = new JTextField();
		txtDigitalInModbusAddressChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_1, "4, 10, fill, default");
		txtDigitalInModbusAddressChannel_1.setColumns(10);
		
		txtDigitalInModbusAddressChannel_2 = new JTextField();
		txtDigitalInModbusAddressChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_2, "6, 10, fill, default");
		txtDigitalInModbusAddressChannel_2.setColumns(10);
		
		txtDigitalInModbusAddressChannel_3 = new JTextField();
		txtDigitalInModbusAddressChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_3, "8, 10, fill, default");
		txtDigitalInModbusAddressChannel_3.setColumns(10);
		
		txtDigitalInModbusAddressChannel_4 = new JTextField();
		txtDigitalInModbusAddressChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_4, "10, 10, fill, default");
		txtDigitalInModbusAddressChannel_4.setColumns(10);
		
		txtDigitalInModbusAddressChannel_5 = new JTextField();
		txtDigitalInModbusAddressChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_5, "12, 10, fill, default");
		txtDigitalInModbusAddressChannel_5.setColumns(10);
		
		txtDigitalInModbusAddressChannel_6 = new JTextField();
		txtDigitalInModbusAddressChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_6, "14, 10, fill, default");
		txtDigitalInModbusAddressChannel_6.setColumns(10);
		
		txtDigitalInModbusAddressChannel_7 = new JTextField();
		txtDigitalInModbusAddressChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_7, "16, 10, fill, default");
		txtDigitalInModbusAddressChannel_7.setColumns(10);
		
		txtDigitalInModbusAddressChannel_8 = new JTextField();
		txtDigitalInModbusAddressChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalInSetting.add(txtDigitalInModbusAddressChannel_8, "18, 10, fill, default");
		txtDigitalInModbusAddressChannel_8.setColumns(10);
		
		panel_DigitalOut = new JPanel();
		tabbedPane_.addTab("Digital Out", null, panel_DigitalOut, null);
		panel_DigitalOut.setLayout(null);
		
		panel_DigitalOutSetting = new JPanel();
		panel_DigitalOutSetting.setBounds(12, 10, 873, 488);
		panel_DigitalOut.add(panel_DigitalOutSetting);
		panel_DigitalOutSetting.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		//chckbxEnableDigitalOutChannel_1 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_1, "4, 2");
		
		//chckbxEnableDigitalOutChannel_2 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_2, "6, 2");
		
		//chckbxEnableDigitalOutChannel_3 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_3, "8, 2");
		
		//chckbxEnableDigitalOutChannel_4 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_4, "10, 2");
		
		//chckbxEnableDigitalOutChannel_5 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_5, "12, 2");
		
		//chckbxEnableDigitalOutChannel_6 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_6, "14, 2");
		
		//chckbxEnableDigitalOutChannel_7 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_7, "16, 2");
		
		//chckbxEnableDigitalOutChannel_8 = new JCheckBox("Use");
		panel_DigitalOutSetting.add(chckbxEnableDigitalOutChannel_8, "18, 2");
		
		lblDigitalOutValue = new JLabel("Value");
		panel_DigitalOutSetting.add(lblDigitalOutValue, "2, 4");
		
		txtDigitalOutChannelValue_1 = new JTextField();
		txtDigitalOutChannelValue_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_1.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_1, "4, 4, fill, default");
		txtDigitalOutChannelValue_1.setColumns(10);
		
		txtDigitalOutChannelValue_2 = new JTextField();
		txtDigitalOutChannelValue_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_2.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_2, "6, 4, fill, default");
		txtDigitalOutChannelValue_2.setColumns(10);
		
		txtDigitalOutChannelValue_3 = new JTextField();
		txtDigitalOutChannelValue_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_3.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_3, "8, 4, fill, default");
		txtDigitalOutChannelValue_3.setColumns(10);
		
		txtDigitalOutChannelValue_4 = new JTextField();
		txtDigitalOutChannelValue_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_4.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_4, "10, 4, fill, default");
		txtDigitalOutChannelValue_4.setColumns(10);
		
		txtDigitalOutChannelValue_5 = new JTextField();
		txtDigitalOutChannelValue_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_5.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_5, "12, 4, fill, default");
		txtDigitalOutChannelValue_5.setColumns(10);
		
		txtDigitalOutChannelValue_6 = new JTextField();
		txtDigitalOutChannelValue_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_6.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_6, "14, 4, fill, default");
		txtDigitalOutChannelValue_6.setColumns(10);
		
		txtDigitalOutChannelValue_7 = new JTextField();
		txtDigitalOutChannelValue_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_7.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_7, "16, 4, fill, default");
		txtDigitalOutChannelValue_7.setColumns(10);
		
		txtDigitalOutChannelValue_8 = new JTextField();
		txtDigitalOutChannelValue_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutChannelValue_8.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutChannelValue_8, "18, 4, fill, default");
		txtDigitalOutChannelValue_8.setColumns(10);
		
		lblDigitalOutMode = new JLabel("Mode");
		panel_DigitalOutSetting.add(lblDigitalOutMode, "2, 6");
		
		//cmbDigitalOutModeChannel_1 = new JComboBox();
		cmbDigitalOutModeChannel_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_1, "4, 6, fill, default");
		
		//cmbDigitalOutModeChannel_2 = new JComboBox();
		cmbDigitalOutModeChannel_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_2, "6, 6, fill, default");
		
		//cmbDigitalOutModeChannel_3 = new JComboBox();
		cmbDigitalOutModeChannel_3.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_3, "8, 6, fill, default");
		
		//cmbDigitalOutModeChannel_4 = new JComboBox();
		cmbDigitalOutModeChannel_4.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_4, "10, 6, fill, default");
		
		//cmbDigitalOutModeChannel_5 = new JComboBox();
		cmbDigitalOutModeChannel_5.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_5, "12, 6, fill, default");
		
		//cmbDigitalOutModeChannel_6 = new JComboBox();
		cmbDigitalOutModeChannel_6.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_6, "14, 6, fill, default");
		
		//cmbDigitalOutModeChannel_7 = new JComboBox();
		cmbDigitalOutModeChannel_7.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_7, "16, 6, fill, default");
		
		//cmbDigitalOutModeChannel_8 = new JComboBox();
		cmbDigitalOutModeChannel_8.setModel(new DefaultComboBoxModel<Object>(new String[] {"DO", "Pulse"}));
		panel_DigitalOutSetting.add(cmbDigitalOutModeChannel_8, "18, 6, fill, default");
		
		lblDigitalOutModbusFuction = new JLabel("Modbus Function");
		panel_DigitalOutSetting.add(lblDigitalOutModbusFuction, "2, 8");
		
		txtDigitalOutModbusFuctionChannel_1 = new JTextField();
		txtDigitalOutModbusFuctionChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_1.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_1, "4, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_1.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_2 = new JTextField();
		txtDigitalOutModbusFuctionChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_2.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_2, "6, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_2.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_3 = new JTextField();
		txtDigitalOutModbusFuctionChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_3.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_3, "8, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_3.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_4 = new JTextField();
		txtDigitalOutModbusFuctionChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_4.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_4, "10, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_4.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_5 = new JTextField();
		txtDigitalOutModbusFuctionChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_5.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_5, "12, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_5.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_6 = new JTextField();
		txtDigitalOutModbusFuctionChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_6.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_6, "14, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_6.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_7 = new JTextField();
		txtDigitalOutModbusFuctionChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_7.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_7, "16, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_7.setColumns(10);
		
		txtDigitalOutModbusFuctionChannel_8 = new JTextField();
		txtDigitalOutModbusFuctionChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutModbusFuctionChannel_8.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutModbusFuctionChannel_8, "18, 8, fill, default");
		txtDigitalOutModbusFuctionChannel_8.setColumns(10);
		
		lblDigitalOutModbusAddress = new JLabel("Modbus Address");
		panel_DigitalOutSetting.add(lblDigitalOutModbusAddress, "2, 10");
		
		txtDigitalOutModbusAddressChannel_1 = new JTextField();
		txtDigitalOutModbusAddressChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_1, "4, 10, fill, default");
		txtDigitalOutModbusAddressChannel_1.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_2 = new JTextField();
		txtDigitalOutModbusAddressChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_2, "6, 10, fill, default");
		txtDigitalOutModbusAddressChannel_2.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_3 = new JTextField();
		txtDigitalOutModbusAddressChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_3, "8, 10, fill, default");
		txtDigitalOutModbusAddressChannel_3.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_4 = new JTextField();
		txtDigitalOutModbusAddressChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_4, "10, 10, fill, default");
		txtDigitalOutModbusAddressChannel_4.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_5 = new JTextField();
		txtDigitalOutModbusAddressChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_5, "12, 10, fill, default");
		txtDigitalOutModbusAddressChannel_5.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_6 = new JTextField();
		txtDigitalOutModbusAddressChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_6, "14, 10, fill, default");
		txtDigitalOutModbusAddressChannel_6.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_7 = new JTextField();
		txtDigitalOutModbusAddressChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_7, "16, 10, fill, default");
		txtDigitalOutModbusAddressChannel_7.setColumns(10);
		
		txtDigitalOutModbusAddressChannel_8 = new JTextField();
		txtDigitalOutModbusAddressChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddressChannel_8, "18, 10, fill, default");
		txtDigitalOutModbusAddressChannel_8.setColumns(10);
		
		lblDigitalOutHighWidth = new JLabel("H Width(100us)");
		panel_DigitalOutSetting.add(lblDigitalOutHighWidth, "2, 12");
		
		txtDigitalOutHighWidthChannel_1 = new JTextField();
		txtDigitalOutHighWidthChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_1, "4, 12, fill, default");
		txtDigitalOutHighWidthChannel_1.setColumns(10);
		
		txtDigitalOutHighWidthChannel_2 = new JTextField();
		txtDigitalOutHighWidthChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_2, "6, 12, fill, default");
		txtDigitalOutHighWidthChannel_2.setColumns(10);
		
		txtDigitalOutHighWidthChannel_3 = new JTextField();
		txtDigitalOutHighWidthChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_3, "8, 12, fill, default");
		txtDigitalOutHighWidthChannel_3.setColumns(10);
		
		txtDigitalOutHighWidthChannel_4 = new JTextField();
		txtDigitalOutHighWidthChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_4, "10, 12, fill, default");
		txtDigitalOutHighWidthChannel_4.setColumns(10);
		
		txtDigitalOutHighWidthChannel_5 = new JTextField();
		txtDigitalOutHighWidthChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_5, "12, 12, fill, default");
		txtDigitalOutHighWidthChannel_5.setColumns(10);
		
		txtDigitalOutHighWidthChannel_6 = new JTextField();
		txtDigitalOutHighWidthChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_6, "14, 12, fill, default");
		txtDigitalOutHighWidthChannel_6.setColumns(10);
		
		txtDigitalOutHighWidthChannel_7 = new JTextField();
		txtDigitalOutHighWidthChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_7, "16, 12, fill, default");
		txtDigitalOutHighWidthChannel_7.setColumns(10);
		
		txtDigitalOutHighWidthChannel_8 = new JTextField();
		txtDigitalOutHighWidthChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutHighWidthChannel_8, "18, 12, fill, default");
		txtDigitalOutHighWidthChannel_8.setColumns(10);
		
		JLabel lblDigitalOutModbusAddress2 = new JLabel("Modbus Address");
		panel_DigitalOutSetting.add(lblDigitalOutModbusAddress2, "2, 14, right, default");
		
		txtDigitalOutModbusAddress2Channel_1 = new JTextField();
		txtDigitalOutModbusAddress2Channel_1.setEditable(false);
		txtDigitalOutModbusAddress2Channel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_1, "4, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_1.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_2 = new JTextField();
		txtDigitalOutModbusAddress2Channel_2.setEditable(false);
		txtDigitalOutModbusAddress2Channel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_2, "6, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_2.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_3 = new JTextField();
		txtDigitalOutModbusAddress2Channel_3.setEditable(false);
		txtDigitalOutModbusAddress2Channel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_3, "8, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_3.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_4 = new JTextField();
		txtDigitalOutModbusAddress2Channel_4.setEditable(false);
		txtDigitalOutModbusAddress2Channel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_4, "10, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_4.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_5 = new JTextField();
		txtDigitalOutModbusAddress2Channel_5.setEditable(false);
		txtDigitalOutModbusAddress2Channel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_5, "12, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_5.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_6 = new JTextField();
		txtDigitalOutModbusAddress2Channel_6.setEditable(false);
		txtDigitalOutModbusAddress2Channel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_6, "14, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_6.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_7 = new JTextField();
		txtDigitalOutModbusAddress2Channel_7.setEditable(false);
		txtDigitalOutModbusAddress2Channel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_7, "16, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_7.setColumns(10);
		
		txtDigitalOutModbusAddress2Channel_8 = new JTextField();
		txtDigitalOutModbusAddress2Channel_8.setEditable(false);
		txtDigitalOutModbusAddress2Channel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutModbusAddress2Channel_8, "18, 14, fill, default");
		txtDigitalOutModbusAddress2Channel_8.setColumns(10);
		
		lblDigitalOutLowWidth = new JLabel("L Width(100us)");
		panel_DigitalOutSetting.add(lblDigitalOutLowWidth, "2, 16");
		
		txtDigitalOutLowWidthChannel_1 = new JTextField();
		txtDigitalOutLowWidthChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_1, "4, 16, fill, default");
		txtDigitalOutLowWidthChannel_1.setColumns(10);
		
		txtDigitalOutLowWidthChannel_2 = new JTextField();
		txtDigitalOutLowWidthChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_2, "6, 16, fill, default");
		txtDigitalOutLowWidthChannel_2.setColumns(10);
		
		txtDigitalOutLowWidthChannel_3 = new JTextField();
		txtDigitalOutLowWidthChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_3, "8, 16, fill, default");
		txtDigitalOutLowWidthChannel_3.setColumns(10);
		
		txtDigitalOutLowWidthChannel_4 = new JTextField();
		txtDigitalOutLowWidthChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_4, "10, 16, fill, default");
		txtDigitalOutLowWidthChannel_4.setColumns(10);
		
		txtDigitalOutLowWidthChannel_5 = new JTextField();
		txtDigitalOutLowWidthChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_5, "12, 16, fill, default");
		txtDigitalOutLowWidthChannel_5.setColumns(10);
		
		txtDigitalOutLowWidthChannel_6 = new JTextField();
		txtDigitalOutLowWidthChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_6, "14, 16, fill, default");
		txtDigitalOutLowWidthChannel_6.setColumns(10);
		
		txtDigitalOutLowWidthChannel_7 = new JTextField();
		txtDigitalOutLowWidthChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_7, "16, 16, fill, default");
		txtDigitalOutLowWidthChannel_7.setColumns(10);
		
		txtDigitalOutLowWidthChannel_8 = new JTextField();
		txtDigitalOutLowWidthChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DigitalOutSetting.add(txtDigitalOutLowWidthChannel_8, "18, 16, fill, default");
		txtDigitalOutLowWidthChannel_8.setColumns(10);
		
		lblDigitalOutFrequency = new JLabel("Frequency(Hz)");
		panel_DigitalOutSetting.add(lblDigitalOutFrequency, "2, 18");
		
		txtDigitalOutFrequencyChannel_1 = new JTextField();
		txtDigitalOutFrequencyChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_1.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_1, "4, 18, fill, default");
		txtDigitalOutFrequencyChannel_1.setColumns(10);
		
		txtDigitalOutFrequencyChannel_2 = new JTextField();
		txtDigitalOutFrequencyChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_2.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_2, "6, 18, fill, default");
		txtDigitalOutFrequencyChannel_2.setColumns(10);
		
		txtDigitalOutFrequencyChannel_3 = new JTextField();
		txtDigitalOutFrequencyChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_3.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_3, "8, 18, fill, default");
		txtDigitalOutFrequencyChannel_3.setColumns(10);
		
		txtDigitalOutFrequencyChannel_4 = new JTextField();
		txtDigitalOutFrequencyChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_4.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_4, "10, 18, fill, default");
		txtDigitalOutFrequencyChannel_4.setColumns(10);
		
		txtDigitalOutFrequencyChannel_5 = new JTextField();
		txtDigitalOutFrequencyChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_5.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_5, "12, 18, fill, default");
		txtDigitalOutFrequencyChannel_5.setColumns(10);
		
		txtDigitalOutFrequencyChannel_6 = new JTextField();
		txtDigitalOutFrequencyChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_6.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_6, "14, 18, fill, default");
		txtDigitalOutFrequencyChannel_6.setColumns(10);
		
		txtDigitalOutFrequencyChannel_7 = new JTextField();
		txtDigitalOutFrequencyChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_7.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_7, "16, 18, fill, default");
		txtDigitalOutFrequencyChannel_7.setColumns(10);
		
		txtDigitalOutFrequencyChannel_8 = new JTextField();
		txtDigitalOutFrequencyChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutFrequencyChannel_8.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutFrequencyChannel_8, "18, 18, fill, default");
		txtDigitalOutFrequencyChannel_8.setColumns(10);
		
		lblDigitalOutDutyCycle = new JLabel("Duty cycle(%)");
		panel_DigitalOutSetting.add(lblDigitalOutDutyCycle, "2, 20");
		
		txtDigitalOutDutyCycleChannel_1 = new JTextField();
		txtDigitalOutDutyCycleChannel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_1.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_1, "4, 20, fill, default");
		txtDigitalOutDutyCycleChannel_1.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_2 = new JTextField();
		txtDigitalOutDutyCycleChannel_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_2.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_2, "6, 20, fill, default");
		txtDigitalOutDutyCycleChannel_2.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_3 = new JTextField();
		txtDigitalOutDutyCycleChannel_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_3.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_3, "8, 20, fill, default");
		txtDigitalOutDutyCycleChannel_3.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_4 = new JTextField();
		txtDigitalOutDutyCycleChannel_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_4.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_4, "10, 20, fill, default");
		txtDigitalOutDutyCycleChannel_4.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_5 = new JTextField();
		txtDigitalOutDutyCycleChannel_5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_5.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_5, "12, 20, fill, default");
		txtDigitalOutDutyCycleChannel_5.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_6 = new JTextField();
		txtDigitalOutDutyCycleChannel_6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_6.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_6, "14, 20, fill, default");
		txtDigitalOutDutyCycleChannel_6.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_7 = new JTextField();
		txtDigitalOutDutyCycleChannel_7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_7.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_7, "16, 20, fill, default");
		txtDigitalOutDutyCycleChannel_7.setColumns(10);
		
		txtDigitalOutDutyCycleChannel_8 = new JTextField();
		txtDigitalOutDutyCycleChannel_8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitalOutDutyCycleChannel_8.setEditable(false);
		panel_DigitalOutSetting.add(txtDigitalOutDutyCycleChannel_8, "18, 20, fill, default");
		txtDigitalOutDutyCycleChannel_8.setColumns(10);
		
		
		class btnSettingListener implements ActionListener
		{
			private GUI gui = null;
			btnSettingListener(GUI gui) {
				this.gui = gui;
			}

			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						PasswordUI dialog = new PasswordUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						String password = new String(dialog.pwdPassword.getPassword());

						/* WizIO */
						if(discovery_reply.product_code[0] == 0x04 && discovery_reply.product_code[1] == 0x00 && discovery_reply.product_code[2] == 0x00) {
							WizIO_Config wizio_config = new WizIO_Config();
							if(PanelManager.updateFromPanel(gui, selectedMac, wizio_config)) {
								socket.set_info("255.255.255.255", wizio_config.getData(), password.trim());
							}
						}

						break;
					}
				}
			}
		}
		class btnFwUploadingListener implements ActionListener
		{
			private GUI gui = null;
			btnFwUploadingListener(GUI gui) {
				this.gui = gui;
			}

			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						FwUploadUI dialog = new FwUploadUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						byte[] serverIp = new byte[4];
						String[] str_array = dialog.txtServerIp.getText().split("\\.");
						serverIp[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
						serverIp[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
						serverIp[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
						serverIp[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));
						String password = new String(dialog.pwdPassword.getPassword());

						/* WizIO */
						if(discovery_reply.product_code[0] == 0x04 && discovery_reply.product_code[1] == 0x00 && discovery_reply.product_code[2] == 0x00) {
							WizIO_Config wizio_config = new WizIO_Config();
							if(PanelManager.updateFromPanel(gui, selectedMac, wizio_config)) {
								socket.firmware_upload(wizio_config.getData(), serverIp, Short.parseShort(dialog.txtServerPort.getText(), 10), dialog.txtFileName.getText().trim(), password.trim());
							}
						}
						break;
					}
				}
			}
		}
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Firmware Version");
		panel.add(lblNewLabel, "2, 2");
		
		lblNewLabel_1 = new JLabel("Network Status");
		panel.add(lblNewLabel_1, "4, 2");
		
		txtFirmwareVersion = new JTextField();
		txtFirmwareVersion.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirmwareVersion.setEditable(false);
		panel.add(txtFirmwareVersion, "2, 4, fill, default");
		txtFirmwareVersion.setColumns(10);
		
		txtNetworkStatus = new JTextField();
		txtNetworkStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtNetworkStatus.setEditable(false);
		panel.add(txtNetworkStatus, "4, 4, fill, default");
		txtNetworkStatus.setColumns(10);
		
		panel_Buttons = new JPanel();
		GridBagConstraints gbc_panel_Buttons = new GridBagConstraints();
		gbc_panel_Buttons.anchor = GridBagConstraints.NORTH;
		gbc_panel_Buttons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Buttons.gridx = 1;
		gbc_panel_Buttons.gridy = 2;
		contentPane.add(panel_Buttons, gbc_panel_Buttons);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new btnSettingListener(this));
		panel_Buttons.add(btnSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputValidation valid = new InputValidation();
				DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
				DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
				WIZnet_Header wiznet_header = new WIZnet_Header();

				treeIndex = 0;
				btnSearch.setEnabled(false);
				timer.schedule(new treeSelectionTimer(), 1000);

				if(rdbtnIpAddress.isSelected()) {
					if(txtIpAddress.getText().length() > 0) {
						if(!valid.IpValid(txtIpAddress.getText().trim())) {
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "Search IP input error");
							return;
						}
						root.removeAllChildren();
						model.reload(root);
						list.clear();
						socket.discovery(txtIpAddress.getText().trim(), wiznet_header.DISCOVERY_ALL);
					}
					else {
						socket.discovery("255.255.255.255", wiznet_header.DISCOVERY_ALL);
						root.removeAllChildren();
						model.reload(root);
						list.clear();
					}
				}
				else if(rdbtnMacAddress.isSelected()) {
					if(txtMacAddress.getText().length() > 0) {
						if(!valid.MacValid(txtMacAddress.getText().trim())) {
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "Search MAC input error");
							return;
						}
					}
					root.removeAllChildren();
					model.reload(root);
					list.clear();
					socket.discovery("255.255.255.255", wiznet_header.DISCOVERY_ALL);
				}
				else {
					root.removeAllChildren();
					model.reload(root);
					list.clear();
					socket.discovery("255.255.255.255", wiznet_header.DISCOVERY_ALL);
				}
			}
		});
		panel_Buttons.add(btnSetting);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputValidation valid = new InputValidation();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						PasswordUI dialog = new PasswordUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						String password = new String(dialog.pwdPassword.getPassword());
						if(rdbtnIpAddress.isSelected()) {
							if(txtIpAddress.getText().length() > 0) {
								if(!valid.IpValid(txtIpAddress.getText().trim())) {
									JFrame frame = new JFrame();
									JOptionPane.showMessageDialog(frame, "Clear IP input error");
									return;
								}
								socket.clear(txtIpAddress.getText().trim(), discovery_reply.mac_address, password.trim());
							}

							else {
								socket.clear("255.255.255.255", discovery_reply.mac_address, password.trim());
							}
						}
						else {
							socket.clear("255.255.255.255", discovery_reply.mac_address, password.trim());
						}
						break;
					}
				}
			}
		});
		panel_Buttons.add(btnClear);
		
		
		
		JButton btnFwUploading = new JButton("F/W Uploading");
		btnFwUploading.addActionListener(new btnFwUploadingListener(this));
		
		JButton btnLocate = new JButton("Locate");
		btnLocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputValidation valid = new InputValidation();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						PasswordUI dialog = new PasswordUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						String password = new String(dialog.pwdPassword.getPassword());
						if(rdbtnIpAddress.isSelected()) {
							if(txtIpAddress.getText().length() > 0) {
								if(!valid.IpValid(txtIpAddress.getText().trim())) {
									JFrame frame = new JFrame();
									JOptionPane.showMessageDialog(frame, "Locate IP input error");
									return;
								}
								socket.locate(txtIpAddress.getText().trim(), discovery_reply.mac_address, password.trim());
							}

							else {
								socket.locate("255.255.255.255", discovery_reply.mac_address, password.trim());
							}
						}
						else {
							socket.locate("255.255.255.255", discovery_reply.mac_address, password.trim());
						}
						break;
					}
				}
			}
		});
		panel_Buttons.add(btnLocate);
		panel_Buttons.add(btnFwUploading);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputValidation valid = new InputValidation();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						PasswordUI dialog = new PasswordUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						String password = new String(dialog.pwdPassword.getPassword());
						if(rdbtnIpAddress.isSelected()) {
							if(txtIpAddress.getText().length() > 0) {
								if(!valid.IpValid(txtIpAddress.getText().trim())) {
									JFrame frame = new JFrame();
									JOptionPane.showMessageDialog(frame, "Reset IP input error");
									return;
								}
								socket.reset(txtIpAddress.getText().trim(), discovery_reply.mac_address, password.trim());
							}

							else {
								socket.reset("255.255.255.255", discovery_reply.mac_address, password.trim());
							}
						}
						else {
							socket.reset("255.255.255.255", discovery_reply.mac_address, password.trim());
						}
						break;
					}
				}
			}
		});
		panel_Buttons.add(btnReset);
		
		JButton btnFactoryReset = new JButton("Factory Reset");
		btnFactoryReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputValidation valid = new InputValidation();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(selectedNode == null) return;

				WIZnet_Header.Discovery_Reply discovery_reply;
				for(int i=0; i<list.size(); i++) {
					String selectedNodeName = selectedNode.toString();
					discovery_reply = list.get(i);
					String mac_address = String.format("%02X:%02X:%02X:%02X:%02X:%02X",
							discovery_reply.mac_address[0], discovery_reply.mac_address[1],
							discovery_reply.mac_address[2], discovery_reply.mac_address[3],
							discovery_reply.mac_address[4], discovery_reply.mac_address[5]);

					if(selectedNodeName.equals(mac_address)) {
						PasswordUI dialog = new PasswordUI();
						dialog.setVisible(true);

						if(dialog.isOK == false)
							return;

						String password = new String(dialog.pwdPassword.getPassword());
						if(rdbtnIpAddress.isSelected()) {
							if(txtIpAddress.getText().length() > 0) {
								if(!valid.IpValid(txtIpAddress.getText().trim())) {
									JFrame frame = new JFrame();
									JOptionPane.showMessageDialog(frame, "Factory Reset IP input error");
									return;
								}
								socket.factory_reset(txtIpAddress.getText().trim(), discovery_reply.mac_address, password.trim());
							}

							else {
								socket.factory_reset("255.255.255.255", discovery_reply.mac_address, password.trim());
							}
						}
						else {
							socket.factory_reset("255.255.255.255", discovery_reply.mac_address, password.trim());
						}
						break;
					}
				}
			}
		});
		panel_Buttons.add(btnFactoryReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_Buttons.add(btnExit);
	}
}
